package com.example.testtaskmc.model.Dto;

import com.example.testtaskmc.model.Purchase;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Date;

@Schema(description = "Entity for validate purchase in post-request")
@XmlRootElement(name = "purchase")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PurchaseDto {

    @NotEmpty(message = "The purchased item is required.")
    @Size(min = 2, max = 50, message = "The length of purchased item must be between 2 and 50 characters.")
    private String purchaseItem;

    @NotNull(message = "The count of purchased item is required.")
    @Positive(message = "The count of purchased item must be positive.")
    private int count;

    @NotNull(message = "The amount is required.")
    @Positive(message = "The amount must be positive.")
    private double amount;

    @NotNull(message = "The date of purchase is required.")
    @Past(message = "The date of purchase must be in past.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "date of purchase", example = "2019-08-12")
    private Date purchaseDate;

    @Valid
    @NotNull
    private UserDto user;

    public Purchase toPurchase() {
        Purchase purchase = new Purchase();
        purchase.setPurchaseItem(purchaseItem);
        purchase.setCount(count);
        purchase.setAmount(amount);
        purchase.setPurchaseDate(purchaseDate);
        purchase.setUser(user.toUser());
        return purchase;
    }

    public PurchaseDto() {
    }

    public PurchaseDto(String purchaseItem, int count, double amount, Date purchaseDate, UserDto user) {
        this.purchaseItem = purchaseItem;
        this.count = count;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.user = user;
    }

    public String getPurchaseItem() {
        return purchaseItem;
    }

    @XmlElement
    public void setPurchaseItem(String purchaseItem) {
        this.purchaseItem = purchaseItem;
    }

    public int getCount() {
        return count;
    }

    @XmlElement
    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    @XmlElement
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    @XmlElement
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public UserDto getUser() {
        return user;
    }

    @XmlElement
    public void setUser(UserDto user) {
        this.user = user;
    }
}
