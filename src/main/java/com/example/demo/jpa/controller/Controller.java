package com.example.demo.jpa.controller;

import com.example.demo.jpa.model.Stock;
import com.example.demo.jpa.service.StockForTransService;
import com.example.demo.jpa.service.StockPagingAndSortingService;
import com.example.demo.jpa.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    StockService stockService;

    @RequestMapping("/getStockByName/{name}")
    public List<Stock> getStockByName(@PathVariable String name){
        return stockService.findByName(name);
    }

    @RequestMapping("/getAllStocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStock();
    }

    @RequestMapping("/getStockByDesc/{desc}")
    public List<Stock> getStockByDesc(@PathVariable String desc){
        return stockService.getStockByDesc(desc);
    }

    @RequestMapping("/deleteStock")
    public void deleteStock(){
        stockService.delete();
    }

    @RequestMapping("/deleteStockByID/{ID}")
    public void deleteStockByID(@PathVariable String  ID){
        stockService.deleteStockByID(Integer.parseInt(ID));
    }

    @RequestMapping("/insertStock")
    public Stock insertStock(){
        return stockService.insertStock();
    }

    @RequestMapping("/updateStock")
    Stock updateStock(){
        return stockService.updateStock();
    }


    @Autowired
    StockPagingAndSortingService stockPagingAndSortingService;

    @RequestMapping("/sortByName")
    List<Stock> sortByName(){
        return stockPagingAndSortingService.sortByName();
    }

    @RequestMapping("/splitPage")
    List<Stock> splitPage(){
        return stockPagingAndSortingService.splitPage();
    }


    @Autowired
    StockForTransService stockForTransService;

    @RequestMapping("/transOK")
    void transOK(){
        stockForTransService.updateStockOK();
    }

    @RequestMapping("/transError")
    void transError(){
        stockForTransService.updateStockError();
    }
}
