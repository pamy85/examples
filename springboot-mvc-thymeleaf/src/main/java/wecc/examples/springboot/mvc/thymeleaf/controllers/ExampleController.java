package wecc.examples.springboot.mvc.thymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wecc.examples.springboot.mvc.thymeleaf.model.ExampleObject;

import java.util.Arrays;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/text")
    public String text(Model model){
        ExampleObject exampleObject =
                new ExampleObject("Lionel","Messi");
        model.addAttribute("greetings", "Hi guys!");
        model.addAttribute("obj", exampleObject);
        return "text";
    }

    @GetMapping("/conditional")
    public String conditional(Model model){
        model.addAttribute("hidden", "false");
        return "conditional";
    }

    @GetMapping("/iteration")
    public String iteration(Model model){
        List<String> greetings = Arrays.asList("Hi!","Hello!","What's up!");
        model.addAttribute("greetings", greetings);
        return "iteration";
    }

}

