package br.com.alex.cucumber.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class MyCustomWorld {
    String name;
}
