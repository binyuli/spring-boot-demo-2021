package com.example.demo.jpa.controller;

import com.example.demo.jpa.model.Stock;
import com.example.demo.jpa.service.StockForTransService;
import com.example.demo.jpa.service.StockPagingAndSortingService;
import com.example.demo.jpa.service.StockService;
import com.example.demo.jpa.tool.HttpCodeEnum;
import com.example.demo.jpa.tool.HttpReturn;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1") // version control
public class JpaController {

    @Autowired
    StockService stockService;

    @GetMapping("/stock/name/{name}")
    @ApiOperation(value = "Get the Stock By name", notes = "not fuzzy query")
    @ApiResponses({
            @ApiResponse(code = 200, message = "good response"),
            @ApiResponse(code = 400, message = "parameter error"),
            @ApiResponse(code = 404, message = "page not found"),
            @ApiResponse(code = 500, message = "unknown server error")
    })
    public HttpReturn<List<Stock>> getStockByName(@PathVariable String name) {
        return new HttpReturn<>(HttpCodeEnum.OK, stockService.findByName(name));
    }

    @GetMapping("/stock/desc/{desc}")
    public HttpReturn<List<Stock>> getStockByDesc(@PathVariable String desc) {
        return new HttpReturn<>(HttpCodeEnum.OK, stockService.getStockByDesc(desc));
    }

    @GetMapping("/stocks")
    public HttpReturn<List<Stock>> getAllStocks() {
        return new HttpReturn<>(HttpCodeEnum.OK, stockService.getAllStock());
    }

    @PostMapping("/stock")
    public HttpReturn<Stock> insertStock(@RequestBody Stock stock) {
        return new HttpReturn<>(HttpCodeEnum.CREATEOK, stockService.insertStock(stock));
    }

    @PutMapping("/updateStock")
    public HttpReturn<Stock> updateStock(@RequestBody Stock stock) {
        return new HttpReturn<>(HttpCodeEnum.OK, stockService.updateStock(stock));
    }

    @DeleteMapping("/stock")
    public HttpReturn<String> deleteStock(@RequestBody Stock stock) {
        stockService.delete(stock);
        return new HttpReturn<>(HttpCodeEnum.OK, "Delete the Stock Correctly");
    }

    @DeleteMapping("/stock/{ID}")
    public HttpReturn<String> deleteStockByID(@PathVariable String ID) {
        stockService.deleteStockByID(Integer.parseInt(ID));
        return new HttpReturn<>(HttpCodeEnum.OK, "Delete the Stock By ID Correctly");
    }

    @Autowired
    StockPagingAndSortingService stockPagingAndSortingService;

    @GetMapping("/sortedStocks")
    public HttpReturn<List<Stock>> getStocksSortedByField(@RequestParam(value = "sortByField", defaultValue = "name") String sortByField) {
        return new HttpReturn<>(HttpCodeEnum.OK, stockPagingAndSortingService.getStocksSortedByField(sortByField));
    }

    @GetMapping("/pagedStocks")
    HttpReturn<List<Stock>> getStocksSortedByField(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "3") int size) {
        return new HttpReturn<>(HttpCodeEnum.OK, stockPagingAndSortingService.getStocksWithSplitPage(page, size));
    }

    @Autowired
    StockForTransService stockForTransService;

    @PutMapping("/transOK")
    void transOK() {
        stockForTransService.updateStockOK();
    }

    @PutMapping("/transError")
    void transError() {
        stockForTransService.updateStockError();
    }
}
