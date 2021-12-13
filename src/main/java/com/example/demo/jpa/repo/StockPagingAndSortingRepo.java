package com.example.demo.jpa.repo;

import com.example.demo.jpa.model.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface StockPagingAndSortingRepo extends PagingAndSortingRepository<Stock, Integer> {

}
