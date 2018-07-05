package hello.hateoas;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HiController {
    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/hi")
    public HttpEntity<Hi> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Hi greeting = new Hi(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(HiController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}
