package com.epam.task5002;

public class PaymentLogic {
    public static double getTotal(Payment payment) {
        long total = 0;
        for (Payment.Product product : payment.getProducts()) {
            total += product.getPrice();
        }
        return MoneyConverter.getRubles(total);
    }

    public static void addProduct(Payment payment, Payment.Product product) {
        if(product!=null) {
            payment.getProducts().add(product);
        }
    }

    public static String paymentToString(Payment payment) {
        StringBuilder sb = new StringBuilder().append("Payment №").append(payment.getNumber()).append("\n")
                .append("------------------------------------------------------------------------------\n")
                .append("Product                                                 |        Price\n")
                .append("------------------------------------------------------------------------------\n");
        for (Payment.Product product : payment.getProducts()) {
            sb.append(productToString(product)).append("\n");
        }
        sb.append("------------------------------------------------------------------------------\n")
                .append("Total:                                                   ")
                .append(String.format("%13.2f", getTotal(payment))).append("\n");
        return sb.toString();
    }

    public static String productToString(Payment.Product product) {
        return String.format("%-56s", product.getName()) + '|' +
                String.format("%13.2f", MoneyConverter.getRubles(product.getPrice()));
    }
}
