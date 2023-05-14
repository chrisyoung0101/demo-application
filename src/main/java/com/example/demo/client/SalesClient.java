package com.example.demo.client;

import com.example.demo.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SalesClient {

    private final RestTemplate restTemplate;

    @Autowired
    public SalesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Sale getSaleById(Long id) {
        String url = "http://localhost:8081/sales/" + id;
        Sale sale = restTemplate.getForObject(url, Sale.class);
        System.out.println("Sale: " + sale);
        return sale;
    }

    // Retrieves a list of all sales
    public List<Sale> getAllSales() {
        // Defines the URL for the API endpoint to retrieve all sales
        String url = "http://localhost:8081/sales";

        // Performs a GET request to the specified URL and captures the response
        ResponseEntity<List<Sale>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Sale>>() {}
        );

        // Retrieves the list of sales from the response body
        List<Sale> sales = response.getBody();

        // Prints the retrieved list of sales
        System.out.println("Sales from SalesClient.getAllSales() : " + sales);

        // Returns the list of sales
        return sales;
    }


}
