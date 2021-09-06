package com.epam.task5002;

//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {
    private final int number;
    private final List<Product> products;

    public Payment(List<Product> products) {
        number = NumbersGeneratorUtil.nextNumber();
        this.products = products;
    }

    public Payment(Product product) {
        number = NumbersGeneratorUtil.nextNumber();
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

    public String string() {
        StringBuilder sb = new StringBuilder().append("Payment №").append(number).append("\n")
                .append("------------------------------------------------------------------------------\n")
                .append("Product                                                 |        Price\n")
                .append("------------------------------------------------------------------------------\n");
        for (Product product : products) {
            sb.append(product.string()).append("\n");
        }
        sb.append("------------------------------------------------------------------------------\n")
                .append("Total:                                                   ")
                .append(String.format("%13.2f", getTotal())).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return number == payment.number &&
                Objects.equals(products, payment.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, products);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "number=" + number +
                ", products=" + products +
                '}';
    }

    public static class Product {
        private String name;
        private long price;

        public Product() {
            this.name = "";
            this.price = MoneyConverter.getKopecks(0.0);
        }

        public Product(String name, double price) {
            if (name != null && price >= 0) {
                this.name = name;
                this.price = MoneyConverter.getKopecks(price);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void setName(String name) {
            if (name != null) {
                this.name = name;
            } else {
                this.name = "";
            }
        }

        public String getName() {
            return name;
        }

        public void setPrice(double newPrice) {
            if (newPrice > 0) {
                this.price = MoneyConverter.getKopecks(newPrice);
            }
        }

        public long getPrice() {
            return price;
        }

        public String string() {
            return String.format("%-56s", name) + '|' +
                    String.format("%13.2f", MoneyConverter.getRubles(price));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            return price == product.price &&
                    name.equals(product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
