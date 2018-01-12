package br.com.alex.cucumber.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AskMyAgeService {

    @RequestMapping("/whatsyourjob")
    public String askMyJob() {
        System.out.println("Still seeking one");
        return "Still seeking one";
    }
}
