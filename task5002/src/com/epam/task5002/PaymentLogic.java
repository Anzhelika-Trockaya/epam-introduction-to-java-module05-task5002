package com.epam.task5002;

import java.util.List;

public class PaymentLogic {
    public static Payment createNewPayment() {
        return new Payment(NumbersGeneratorUtil.nextNumber());
    }

    public static Payment createNewPayment(Payment.Product product) {
        if (product != null) {
            return new Payment(NumbersGeneratorUtil.nextNumber(), product);
        } else {
            return new Payment(NumbersGeneratorUtil.nextNumber());
        }
    }

    public static Payment createNewPayment(List<Payment.Product> products) {
        if (products != null) {
            return new Payment(NumbersGeneratorUtil.nextNumber(), products);
        } else {
            return new Payment(NumbersGeneratorUtil.nextNumber());
        }
    }

    public static double getTotal(Payment payment) {
        long total = 0;
        for (Payment.Product product : payment.getProducts()) {
            total += product.getPrice();
        }
        return MoneyConverter.getRubles(total);
    }

    public static void addProduct(Payment payment, Payment.Product product) {
        if (product != null) {
            payment.getProducts().add(product);
        }
    }
}
