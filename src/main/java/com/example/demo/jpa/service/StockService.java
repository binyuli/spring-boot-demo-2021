package com.example.demo.jpa.service;

import com.example.demo.jpa.model.Stock;
import com.example.demo.jpa.repo.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepo stockRepo;

    public List<Stock> findByName(String name){
        return stockRepo.findByName(name);
    }

    public List<Stock> getAllStock(){
        return stockRepo.findAll();
    }

    public void delete(){
        Stock delStock = stockRepo.getOne(10);
        stockRepo.delete(delStock);
    }

    public void deleteStockByID(int id){
        stockRepo.deleteById(id);
    }

    public Stock insertStock(){
        Stock stock = new Stock();
        stock.setID(11);
        stock.setName("machine1");
        stock.setNum(51);
        stock.setDescription("Good");

        return stockRepo.save(stock);
    }

    public Stock updateStock(){
        Stock stock = stockRepo.getById(10);
        stock.setNum(50);
        return stockRepo.save(stock);
    }

    public List<Stock> getStockByDesc(String desc){
        return stockRepo.getStockByDesc(desc);
    }
}
