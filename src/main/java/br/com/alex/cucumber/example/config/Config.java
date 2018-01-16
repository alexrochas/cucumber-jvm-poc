package br.com.alex.cucumber.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value("${service.whatsyourage.url}") private String whatsYourAgeServiceUrl;
    @Value("${service.whatsyourmiddlename.url}") private String whatsYourMiddleNameServiceUrl;
    @Value("${service.whatsyourjob.url}") private String whatsYourJobServiceUrl;

    public String getWhatsYourAgeServiceUrl() {
        return whatsYourAgeServiceUrl;
    }

    public String getWhatsYourMiddleNameServiceUrl() {
        return whatsYourMiddleNameServiceUrl;
    }

    public String getWhatsYourJobServiceUrl() {
        return whatsYourJobServiceUrl;
    }
}
