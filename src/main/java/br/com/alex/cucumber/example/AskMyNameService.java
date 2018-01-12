package br.com.alex.cucumber.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskMyNameService {

    @RequestMapping("/whatsyourname")
    public String askMyName() {
        return "Alex";
    }
}
