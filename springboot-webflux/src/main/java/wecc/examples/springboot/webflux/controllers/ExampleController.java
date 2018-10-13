package wecc.examples.springboot.webflux.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveSSEDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class ExampleController {

    @GetMapping("/count")
    public String count(Model model){
        Flux<Integer> flux = Flux.range(1,10).delayElements(Duration.ofSeconds(1));
        model.addAttribute("numbers", flux);
        return "count";
    }

    @GetMapping("/count/v2")
    public String countV2(Model model){
        Flux<Integer> flux = Flux.range(1,10).delayElements(Duration.ofSeconds(1));
        IReactiveSSEDataDriverContextVariable statusDataDriver =
                new ReactiveDataDriverContextVariable(flux, 1);
        model.addAttribute("numbers", statusDataDriver);
        return "count";
    }

}
