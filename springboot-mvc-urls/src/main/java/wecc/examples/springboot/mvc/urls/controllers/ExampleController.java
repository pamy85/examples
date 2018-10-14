package wecc.examples.springboot.mvc.urls.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController {

    @GetMapping
    public String select() {
        return "select";
    }

    @GetMapping("/view")
    public String query(@RequestParam String view) {
        return view;
    }

    @GetMapping("/view/{view}")
    public String path(@PathVariable String view) {
        return view;
    }

}
