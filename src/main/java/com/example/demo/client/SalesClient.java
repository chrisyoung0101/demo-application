package com.example.demo.client;

import com.example.demo.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SalesClient {

    private final RestTemplate restTemplate;

    @Autowired
    public SalesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Sale getSaleById(Long id) {
        String url = "http://localhost:8081/sales/" + id;
        return restTemplate.getForObject(url, Sale.class);
    }

}
