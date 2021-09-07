package com.epam.task5002;

public class Main {
    public static void main(String[] args) {
        Payment payment;

        payment = new Payment(new Payment.Product("Short", 9.99));

        PaymentLogic.addProduct(payment, new Payment.Product("Jeans for men", 124.99));
        PaymentLogic.addProduct(payment, new Payment.Product("Dress for girl", 750.11));
        PaymentLogic.addProduct(payment, new Payment.Product("Winter coat for woman", 1111.01));

        System.out.println(PaymentLogic.paymentToString(payment));
    }
}
