package hello.ldap;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// The entire class is marked up with @RestController so Spring MVC can autodetect
// the controller using it’s built-in scanning features and automatically configure web routes.
// @RestController also tells Spring MVC to write the text directly into the HTTP response body, because there aren’t any views.
// Instead, when you visit the page, you’ll get a simple message in the browser as the focus of this guide is securing the page with LDAP.
@RestController
public class HomeController {

    @GetMapping("/ldap")
    public String index() {
        return "Welcome to the home page!";
    }
}
