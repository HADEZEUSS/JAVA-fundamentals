package org.example.homeworks.homework7.task5;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "productName", "price"})
public class Product {
    @JsonProperty("id")
    private int productId;
    private String productName;
    private double price;
    @JsonIgnore
    private String internalSKU;

    public Product(int productId, String productName, double price, String internalSKU) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.internalSKU = internalSKU;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getInternalSKU() {
        return internalSKU;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInternalSKU(String internalSKU) {
        this.internalSKU = internalSKU;
    }
}
