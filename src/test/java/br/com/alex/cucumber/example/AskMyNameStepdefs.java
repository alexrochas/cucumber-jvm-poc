package br.com.alex.cucumber.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "br.com.alex.cucumber.example")
@ContextConfiguration(loader = SpringBootContextLoader.class, classes = Application.class)
public class AskMyNameStepdefs extends ApplicationTests implements cucumber.api.java8.En {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8081);

    @Autowired
    private MyCustomWorld world;

    public AskMyNameStepdefs() {
        Before(new String[]{"@MockedApi"}, () -> {
            world.wireMockServer = new WireMockServer(wireMockConfig().port(8081)); //No-args constructor will start on port 8080, no HTTPS
            world.wireMockServer.start();
            world.wireMockServer.stubFor(get(WireMock.urlMatching(".*whatsyourmiddlename.*"))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "text/plain")
                            .withStatus(200)
                            .withBody("Rocha")));
        });

        After(new String[]{"@MockedApi"}, () -> {
            world.wireMockServer.stop();
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
