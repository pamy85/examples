package wecc.examples.springboot.mvc.forms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import wecc.examples.springboot.mvc.forms.model.Greeting;

@Controller
public class ExampleController {

    @GetMapping("/greeting")
    public String sendGreeting(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "send-greeting";
    }

    @PostMapping("/greeting")
    public String readGreeting(@ModelAttribute Greeting greeting) {
        return "read-greeting";
    }

}
