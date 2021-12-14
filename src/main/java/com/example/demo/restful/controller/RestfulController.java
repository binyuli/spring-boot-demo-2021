package com.example.demo.restful.controller;

import com.example.demo.restful.exception.ParamException;
import com.example.demo.restful.model.Stock;
import com.example.demo.restful.tool.HttpCodeEnum;
import com.example.demo.restful.tool.HttpReturn;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@RequestMapping("/v1") //统一定义版本号
public class RestfulController {
    //模拟数据库，在其中存放数据
    static HashMap<Integer, Stock> stockHM = new HashMap<Integer, Stock>();

    //根据ID找Stock
    @RequestMapping( value = "/stock/{id}",method = RequestMethod.GET)
    @ApiOperation(value="Get the Stock By ID", notes="id need less than 100")
    @ApiResponses({
            @ApiResponse(code=200,message="请求正确"),
            @ApiResponse(code=400,message="参数错误"),
            @ApiResponse(code=404,message="页面没找到"),
            @ApiResponse(code=500,message="服务错误")
    })
    public HttpReturn<Stock> getStockByID(@PathVariable Integer id) {
        //如果id大于100，则抛出自定义的异常
        if (id > 100) {
            throw new ParamException(400, "Param id is more than 100");
        }
        return new HttpReturn<>(HttpCodeEnum.OK, stockHM.get(id));
    }

    //返回所有的Stock
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public HttpReturn getStocks() {
        //返回整个HashMap里包含的数据
        return new HttpReturn(HttpCodeEnum.OK, stockHM);
    }

    //插入Stock
    @RequestMapping(value = "/stock", method = RequestMethod.POST)
    public HttpReturn addStock(@RequestBody Stock stock) {
        //插入到HashMap里，模拟在数据库里插入数据
        stockHM.put(stock.getID(), stock);
        return new HttpReturn(HttpCodeEnum.CREATEOK, "Create the Stock Correctly");
    }

    //更新Stock
    @RequestMapping(value = "/stock", method = RequestMethod.PUT)
    public HttpReturn updateStock(@RequestBody Stock stock) {
        //删除老数据，插入新数据
        stockHM.remove(stock.getID());
        stockHM.put(stock.getID(), stock);
        return new HttpReturn(HttpCodeEnum.OK, "Update the Stock Correctly");
    }

    //删除Stock
    @RequestMapping(value = "/stock/{id}", method = RequestMethod.DELETE)
    public HttpReturn deleteStock(@PathVariable Integer id) {
        //删除库存数据
        stockHM.remove(id);
        return new HttpReturn(HttpCodeEnum.OK, "Delete the Stock Correctly");
    }
}