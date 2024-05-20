package com.example;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class Application {

    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/")
    String index() {
        return fetchJsonData().toString();
    }

    public Map<String, Object> fetchJsonData() {
        String url = "https://dummyjson.com/products/1";
        return restTemplate.getForObject(url, Map.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
