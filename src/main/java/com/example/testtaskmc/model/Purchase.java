package com.example.testtaskmc.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Entity
@Table(name = "purchases")

public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "purchase_item")
    private String purchaseItem;

    @Column(name = "count")
    private int count;

    @Column(name = "amount")
    private double amount;

    @Column(name = "purchase_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Purchase() {
    }

    public long getId() {
        return id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    @XmlElement
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public java.lang.String toString() {
        return "Purchase{" +
                "id=" + id +
                ", purchaseItem=" + purchaseItem +
                ", count=" + count +
                ", amount=" + amount +
                ", purchaseDate=" + purchaseDate +
                ", user=" + user +
                '}';
    }
}
