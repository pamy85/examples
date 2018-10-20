package wecc.examples.springboot.security.simple.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wecc.examples.springboot.security.simple.model.Greeting;

@Controller
public class ExampleController {

    @RequestMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }

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
