package dev.fringe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.*;

@Controller
@Service
@RequestMapping("/api")
public class ApiService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${spring.profiles}")
    private String profile;

    @RequestMapping("/greeting")
    @ResponseBody
    String greet() {
        System.out.println("profile = "+ profile + ", time  = " + new Date().getTime());
        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();
        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }
}
