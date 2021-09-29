package com.epam.task5002;

public class ProductLogic {
    public static Payment.Product createNewProduct(String name, double price){
        if (name != null && price >= 0) {
            return new Payment.Product(name,MoneyConverter.getKopecks(price));
        } else {
            throw new IllegalArgumentException("Incorrect data of product!");
        }
    }
}
