package wecc.examples.springboot.security.advanced.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wecc.examples.springboot.security.advanced.model.Greeting;

@Controller
public class ExampleController {

    @RequestMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/greeting")
    public String sendGreeting(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "send-greeting";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/greeting")
    public String readGreeting(@ModelAttribute Greeting greeting) {
        return "read-greeting";
    }

}
