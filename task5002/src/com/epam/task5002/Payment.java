package com.epam.task5002;

//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

import java.util.ArrayList;

public class Payment {
    private static int currentNumber = 100000001;
    private final int number;
    private final ArrayList<Product> products;

    public Payment(ArrayList<Product> products) {
        number = currentNumber++;
        this.products = products;
    }

    public Payment(Product product) {
        number = currentNumber++;
        products = new ArrayList<>();
        products.add(product);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotal() {
        long total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return MoneyConverter.getRubles(total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("Payment №").append(number).append("\n")
                .append("------------------------------------------------------------------------------\n")
                .append("Product                                                 |        Price\n")
                .append("------------------------------------------------------------------------------\n");
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        sb.append("------------------------------------------------------------------------------\n")
                .append("Total:                                                   ")
                .append(String.format("%13.2f", getTotal())).append("\n");
        return sb.toString();
    }

    public static class Product {
        private final String name;
        private long price;

        public Product(String name, double price) {
            if (name != null && price >= 0) {
                this.name = name;
                this.price = MoneyConverter.getKopecks(price);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void setPrice(double newPrice) {
            if (newPrice > 0) {
                this.price = MoneyConverter.getKopecks(newPrice);
            }
        }

        @Override
        public String toString() {
            return String.format("%-56s", name) + '|' +
                    String.format("%13.2f", MoneyConverter.getRubles(price));
        }
    }
}
