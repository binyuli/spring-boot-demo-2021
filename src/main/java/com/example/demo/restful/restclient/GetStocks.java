package com.example.demo.restful.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetStocks {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Get all the stocks");
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/v1/stocks", String.class);
        System.out.println(entity.getBody());
        System.out.println("Get the stock by ID:1");
        entity = restTemplate.getForEntity("http://localhost:8080/v1/stock/200", String.class);
        System.out.println(entity.getBody());
    }
}
