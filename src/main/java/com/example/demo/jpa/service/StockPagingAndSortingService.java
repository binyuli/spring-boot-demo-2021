package com.example.demo.jpa.service;

import com.example.demo.jpa.model.Stock;
import com.example.demo.jpa.repo.StockPagingAndSortingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPagingAndSortingService {

    @Autowired
    private StockPagingAndSortingRepo stockPagingAndSortingRepo;

    public List<Stock> sortByName() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        return (List<Stock>) stockPagingAndSortingRepo.findAll(sort);
    }

    public List<Stock> splitPage() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Stock> list = stockPagingAndSortingRepo.findAll(pageable);
        return list.getContent();
    }
}
