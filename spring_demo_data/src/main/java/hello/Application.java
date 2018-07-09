package hello;

import hello.cache.Quote;
import hello.cache.QuoteService;
import hello.customer.Customer;
import hello.customer.CustomerRepository;
import hello.gemfire.User;
import hello.gemfire.UserRepository;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.Executor;

import static java.util.Arrays.asList;
import static java.util.stream.StreamSupport.stream;


/**
 * 1. @SpringBootApplication is a convenience annotation that adds all of the following:
 *      1. @Configuration tags the class as a source of bean definitions for the application context.
 *      2. @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
 *      3. Normally you would add @EnableWebMvc for a Spring MVC app, 
 *          but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. 
 *          This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
 *      4. @ComponentScan tells Spring to look for other components, configurations, and services in the hello package, 
 *          allowing it to find the controllers.
 * 2. The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
 *
 *
 * 3. @EnableJms triggers the discovery of methods annotated with @JmsListener,
 *    creating the message listener container under the covers.
 *
 * 4. @EnableAsync annotation switches on Spring’s ability to run @Async methods in a background thread pool.
 *    This class also customizes the used Executor.
 *    In our case, we want to limit the number of concurrent threads to 2 and limit the size of the queue to 500. There are many more things you can tune. By default, a SimpleAsyncTaskExecutor is used.
 */
@SpringBootApplication
@ClientCacheApplication(name = "AccessingDataGemFireApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = User.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@ImportResource("/hello/integration.xml")
@EnableAsync
@SuppressWarnings("unused")
public class Application{

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =  SpringApplication.run(Application.class, args);
        System.out.println("Hit Enter to terminate");
        try{
            System.in.read();
        }catch (IOException io){
            System.out.println("IOException: " + io);
        }

        ctx.close();
    }

    @Bean
    ApplicationRunner runner_1(UserRepository personRepository) {

        return args -> {

            User alice = new User("Alice", 40);
            User bob = new User("Baby Bob", 1);
            User carol = new User("Teen Carol", 13);

            System.out.println("Before accessing data in Pivotal GemFire...");

            asList(alice, bob, carol).forEach(person -> System.out.println("\t" + person));

            System.out.println("Saving Alice, Bob and Carol to Pivotal GemFire...");

            personRepository.save(alice);
            personRepository.save(bob);
            personRepository.save(carol);

            System.out.println("Lookup each person by name...");

            asList(alice.getName(), bob.getName(), carol.getName())
                    .forEach(name -> System.out.println("\t" + personRepository.findByName(name)));

            System.out.println("Query adults (over 18):");

            stream(personRepository.findByAgeGreaterThan(18).spliterator(), false)
                    .forEach(person -> System.out.println("\t" + person));

            System.out.println("Query babies (less than 5):");

            stream(personRepository.findByAgeLessThan(5).spliterator(), false)
                    .forEach(person -> System.out.println("\t" + person));

            System.out.println("Query teens (between 12 and 20):");

            stream(personRepository.findByAgeGreaterThanAndAgeLessThan(12, 20).spliterator(), false)
                    .forEach(person -> System.out.println("\t" + person));
        };
    }

    @Bean
    ApplicationRunner runner_2(QuoteService quoteService) {

        return args -> {
            Quote quote = requestQuote(quoteService, 12L);
            requestQuote(quoteService, quote.getId());
            requestQuote(quoteService, 10L);
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            System.out.println("Bean list ..........");
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            System.out.println("......... Bean list end");
        };
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {

            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers
            log.info("Customers found with findAll():");
            System.out.println("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

    private Quote requestQuote(QuoteService quoteService, Long id) {

        long startTime = System.currentTimeMillis();

        Quote quote = Optional.ofNullable(id)
                .map(quoteService::requestQuote)
                .orElseGet(quoteService::requestRandomQuote);

        long elapsedTime = System.currentTimeMillis();

        System.out.printf("\"%1$s\"%nCache Miss [%2$s] - Elapsed Time [%3$s ms]%n", quote,
                quoteService.isCacheMiss(), (elapsedTime - startTime));

        return quote;
    }
}
