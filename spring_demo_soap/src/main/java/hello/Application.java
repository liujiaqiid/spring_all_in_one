package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
@SuppressWarnings("unused")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }
}
