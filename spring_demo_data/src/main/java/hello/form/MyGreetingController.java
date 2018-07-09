package hello.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyGreetingController {

    @GetMapping("/mygreeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "mygreeting";
    }

    @PostMapping("/mygreeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "result";
    }

}
