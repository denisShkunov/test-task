package com.example.testtaskmc.service;

import com.example.testtaskmc.model.Purchase;
import com.example.testtaskmc.reository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements  PurchaseService{

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void save(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> findAll() {
        List<Purchase> purchaseList = purchaseRepository.findAll();
        return purchaseList;
    }
}
