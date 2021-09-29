package com.epam.task5002;

//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

public class Main {
    public static void main(String[] args) {
        Payment payment;

        payment = PaymentLogic.createNewPayment(ProductLogic.createNewProduct("Short", 9.99));

        PaymentLogic.addProduct(payment, ProductLogic.createNewProduct("Jeans for men", 124.99));
        PaymentLogic.addProduct(payment, ProductLogic.createNewProduct("Dress for girl", 750.11));
        PaymentLogic.addProduct(payment, ProductLogic.createNewProduct("Winter coat for woman", 1111.01));

        View.printPayment(payment);
    }
}
