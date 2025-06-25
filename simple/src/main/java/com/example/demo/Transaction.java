package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    private int id;
    private String productID;
    private String productName;
    private String amount;
    private String customerName;
    private String createBy;
    private LocalDateTime transactionDate;
    private LocalDateTime createOn;

    @ManyToOne
    private Status status;

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getAmount() {
        return amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    public Status getStatus() {
        return status;
    }
}
