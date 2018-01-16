package br.com.alex.cucumber.example;

import br.com.alex.cucumber.example.config.Config;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AskMyNameService {

    @Autowired
    private Config config;

    @RequestMapping("/whatsyourname")
    public String askMyName() {
        return "Alex";
    }

    @RequestMapping("/whatsyourage")
    public String askMyAge() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(config.getWhatsYourAgeServiceUrl() + "/whatsyourage");
        CloseableHttpResponse response = httpClient.execute(getRequest);
        return EntityUtils.toString(response.getEntity());
    }

    @RequestMapping("/whatsyourmiddlename")
    public String askMyMiddleName() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(config.getWhatsYourMiddleNameServiceUrl() + "/whatsyourmiddlename");
        CloseableHttpResponse response = httpClient.execute(getRequest);
        return EntityUtils.toString(response.getEntity());
    }

    @RequestMapping("/whatsyourjob")
    public String askMyJob() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(config.getWhatsYourJobServiceUrl() + "/whatsyourjob");
        CloseableHttpResponse response = httpClient.execute(getRequest);
        return EntityUtils.toString(response.getEntity());
    }

}
