package com.epam.task5002;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment(new Payment.Product("Short", 9.99));
        payment.addProduct(new Payment.Product("Jeans for men", 124.99));
        payment.addProduct(new Payment.Product("Dress for girl", 750.11));
        payment.addProduct(new Payment.Product("Winter coat for woman", 1111.01));
        System.out.println(payment);
    }
}
