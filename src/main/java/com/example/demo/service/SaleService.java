package com.example.demo.service;

import com.example.demo.model.Sale;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void saveSales(List<Sale> sales) {
        saleRepository.saveAll(sales);
    }

    public List<Sale> getAllSales() {
        System.out.println("Retrieved sales: " + saleRepository.findAll());
        return saleRepository.findAll();
    }



}
