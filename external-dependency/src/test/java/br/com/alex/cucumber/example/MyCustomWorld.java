package br.com.alex.cucumber.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class MyCustomWorld {
    String name;
    ConfigurableApplicationContext springContext;
    WireMockServer wireMockServer;
}
