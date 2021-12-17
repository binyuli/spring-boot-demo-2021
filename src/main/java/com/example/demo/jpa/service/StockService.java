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

    public void delete(Stock delStock){
        stockRepo.delete(delStock);
    }

    public void deleteStockByID(int id){
        stockRepo.deleteById(id);
    }

    public Stock insertStock(Stock stock){
        return stockRepo.save(stock);
    }

    public Stock updateStock(Stock stock){
        return stockRepo.save(stock);
    }

    public List<Stock> getStockByDesc(String desc){
        return stockRepo.getStockByDesc(desc);
    }
}
