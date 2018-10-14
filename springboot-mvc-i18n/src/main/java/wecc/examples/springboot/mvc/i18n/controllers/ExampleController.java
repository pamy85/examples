package wecc.examples.springboot.mvc.i18n.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/greeting")
    public String greeting(){
        return "greeting";
    }

}

