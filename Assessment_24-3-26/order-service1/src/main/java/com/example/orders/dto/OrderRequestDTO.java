package com.example.orders.dto;

import jakarta.validation.constraints.*;


public class OrderRequestDTO {

    @NotNull
    @NotBlank
    @Size(min = 3)
    private String customerName;
    @Email
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String productName;
    @Min(value = 1)
    private Integer quantity;
    @Min(value = 1)
    @DecimalMin(value = "0.01")
    private Double pricePerUnit;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(String customerName, String email, String productName, Integer quantity, Double pricePerUnit) {
        this.customerName = customerName;
        this.email = email;
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
