package com.example.demo.jpa.repo;

import com.example.demo.jpa.model.Stock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StockRepoTest {

    @Autowired
    private StockRepo stockRepo;

    @Test
    public void testOK() {
        Stock stock = new Stock();
        stock.setID(50);
        stock.setName("Test");
        stock.setNum(100);
        stock.setDescription("OK");

        stockRepo.save(stock);

        List<Stock> result = stockRepo.findByName("Test");
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getDescription(), "OK");

        stockRepo.deleteById(50);
        result = stockRepo.findByName("Test");
        assertEquals(result.size(), 0);
    }
}