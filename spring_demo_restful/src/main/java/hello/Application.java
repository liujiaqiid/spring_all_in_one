package hello;

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
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
