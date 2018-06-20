package hello.greeting;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// This is a resource controller
// HTTP requests are handled by a controller
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     *  1. @RequestMapping
     *      1. The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
     *      2. We can use @RequestMapping(method=GET) to narrow this mapping. By default it will maps all HTTP operations by default. 
     *  2. @RequestParam
     *      1. @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. 
     *      2. If the name parameter is absent in the request, the defaultValue of "World" is used.
     *  3. @RestController
     *      1. This code uses Spring 4’s new @RestController annotation
     *      2. which marks the class as a controller where every method returns a domain object instead of a view. 
     *      3. It’s shorthand for @Controller and @ResponseBody rolled together
     *  4. return
     *      1. This RESTful web service controller simply populates and returns a Greeting object. 
     *      2. The object data will be written directly to the HTTP response as JSON.
     *      3. The Greeting object must be converted to JSON. 
     *      4. Thanks to Spring’s HTTP message converter support, you don’t need to do this conversion manually. 
     *      5. Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically chosen to convert the Greeting instance to JSON.
     */
     @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
