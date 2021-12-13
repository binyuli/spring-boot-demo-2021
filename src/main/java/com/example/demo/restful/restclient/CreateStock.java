package com.example.demo.restful.restclient;

import com.example.demo.restful.model.Stock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class CreateStock {
    public static void main(String[] args) {

        String url = "http://localhost:8080/v1/stock";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        Stock stock = new Stock();
        stock.setID(1);
        stock.setName("Computer");
        stock.setNum(10);
        stock.setDescription("good");

        HttpEntity<Stock> requestEntity = new HttpEntity<Stock>(stock, requestHeaders);
        Map resultMap = restTemplate.postForObject(url, requestEntity, Map.class);
        System.out.println(resultMap);
    }
}
