package com.example.testtaskmc.controller;

import com.example.testtaskmc.model.Dto.PurchaseDto;
import com.example.testtaskmc.model.Purchase;
import com.example.testtaskmc.service.PurchaseService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Controller
@Tag(name = "Purchases Controller",description = "Allows you to save purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @Operation(description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "all good"),
            @ApiResponse(responseCode = "404", description = "page dont found"),
            @ApiResponse(responseCode = "403", description = "auth error"),
            @ApiResponse(responseCode = "500", description = "server error")
    })
    @PostMapping("/purchases")
    @ResponseBody
    public Purchase savePurchase(@Valid @RequestBody PurchaseDto purchaseDto){
        purchaseService.save(purchaseDto.toPurchase());

        return purchaseDto.toPurchase();
    }

    @GetMapping("/allPurchases")
    public String allPurchases(Model model){
        List<Purchase> purchaseList = purchaseService.findAll();
        model.addAttribute("purchases", purchaseList);
        return "all-Purchase";
    }

}
