package com.example.demo.jpa.repo;

import com.example.demo.jpa.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StockRepo extends JpaRepository<Stock, Integer> {

    public List<Stock> findByName(String name);
    @Override
    public void delete(Stock stock);
    @Override
    void deleteById(Integer id);
    @Override
    public Stock save(Stock stock);

    @Query("select s from Stock s where s.description like ?1%")
    public List<Stock> getStockByDesc(String desc);
}
