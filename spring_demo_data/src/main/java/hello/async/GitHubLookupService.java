package hello.async;
/**
 * The GitHubLookupService class uses Spring’s RestTemplate to invoke a remote REST point (api.github.com/users/),
 * and then convert the answer into a User object.
 * Spring Boot automatically provides a RestTemplateBuilder that customizes the defaults with any auto-configuration bits (i.e. MessageConverter).
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * The class is marked with the @Service annotation,
 * making it a candidate for Spring’s component scanning to detect it and add it to the application context.
 */
@Service
public class GitHubLookupService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * 1. The findUser method is flagged with Spring’s @Async annotation, indicating it will run on a separate thread.
     * The method’s return type is CompletableFuture<User> instead of User, a requirement for any asynchronous service.
     * This code uses the completedFuture method to return a CompletableFuture instance which is already completed with result of the GitHub query.
     *
     * 2. Creating a local instance of the GitHubLookupService class does NOT allow the findUser method to run asynchronously.
     * It must be created inside a @Configuration class or picked up by @ComponentScan.
     *
     * @param user
     * @return
     * @throws InterruptedException
     */
    @Async
    public CompletableFuture<Account> findUser(String user) throws InterruptedException {
        logger.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        Account results = restTemplate.getForObject(url, Account.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}
