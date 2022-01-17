package com.example.demo.jpa.service;

import com.example.demo.jpa.model.Stock;
import com.example.demo.jpa.repo.StockRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({MockitoExtension.class})
class StockServiceTest {

    @Mock
    private StockRepo stockRepo;
    @InjectMocks
    private StockService stockService;

    @Test
    public void testOK() {
        Stock stock = new Stock();
        stock.setID(100);
        stock.setName("MockedData");
        stock.setNum(100);
        stock.setDescription("Mocked OK");

        List<Stock> list = new ArrayList<>();
        list.add(stock);
        Mockito.when(stockRepo.findByName("MockData")).thenReturn(list);
        List<Stock> result = stockService.findByName("MockData");
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getDescription(), "Mocked OK");

        List<Stock> emptyList = new ArrayList<>();
        Mockito.when(stockRepo.findByName("empty")).thenReturn(emptyList);
        List<Stock> emptyResult = stockService.findByName("empty");
        assertEquals(emptyResult.size(), 0);
    }

    @Test
    public void testException() {
        Mockito.when(stockRepo.findByName("Exception")).thenThrow(new RuntimeException("Data Error"));

        try {
            stockService.findByName("Exception");
        } catch (Exception e) {
            assertTrue(e.getMessage().indexOf("Data Error") != -1);
        }
    }
}