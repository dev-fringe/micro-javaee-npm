package dev.fringe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class RootController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    String root() {
        return "welcome";
    }

    @RequestMapping("/template")
    String data(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "template";
    }

    @RequestMapping("/greeting")
    @ResponseBody
    String greet() {
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();
        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }
}
