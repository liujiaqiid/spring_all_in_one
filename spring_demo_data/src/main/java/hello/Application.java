package hello;

import hello.cache.Quote;
import hello.cache.QuoteService;
import hello.gemfire.User;
import hello.gemfire.UserRepository;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

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
 */
@SpringBootApplication
@ClientCacheApplication(name = "AccessingDataGemFireApplication", logLevel = "error")
@EnableEntityDefinedRegions(basePackageClasses = User.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
@EnableGemfireRepositories
@ImportResource("/hello/integration.xml")
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
