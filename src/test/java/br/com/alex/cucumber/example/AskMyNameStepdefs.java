package br.com.alex.cucumber.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class AskMyNameStepdefs extends ApplicationTests implements cucumber.api.java8.En {

    @Autowired
    private MyCustomWorld world;
    public AskMyNameStepdefs() {
        Before(() -> {
            SpringApplication.run(Application.class);
        });


        Given("a running application", () -> {
        });

        When("accessing the endpoint (.*)", (String endpoint) -> {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet("http://localhost:8080" + endpoint);
            CloseableHttpResponse response = httpClient.execute(getRequest);
            world.name = EntityUtils.toString(response.getEntity());
        });

        Then("should return (.*)", (String name) -> {
            assertThat(world.name, is(name));
        });
    }
}
