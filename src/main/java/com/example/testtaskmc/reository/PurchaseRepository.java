package com.example.testtaskmc.reository;

import com.example.testtaskmc.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
