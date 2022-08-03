package com.example.testtaskmc.service;

import com.example.testtaskmc.model.Purchase;

import java.util.List;

public interface PurchaseService {
    public void save(Purchase purchase);

    public List<Purchase> findAll();
}
