package com.sg.VendingMachine2.dto;

import java.math.BigDecimal;

/**
 *
 * @author lukem
 */
public class Items {
    private String itemSelected;
    private BigDecimal price;
    private int amountInStock;

    public String getItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(String itemSelected) {
        this.itemSelected = itemSelected;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }
    
}

