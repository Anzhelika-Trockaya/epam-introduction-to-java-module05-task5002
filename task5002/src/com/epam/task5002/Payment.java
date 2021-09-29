package com.epam.task5002;

//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment implements Serializable {
    private int number;
    private List<Product> products;

    public Payment() {
        number = 0;
        this.products = new ArrayList<>();
    }

    public Payment(int number) {
        this.number = number;
        products = new ArrayList<>();
    }

    public Payment(int number, List<Product> products) {
        this.number = number;
        this.products = products;
    }

    public Payment(int number, Product product) {
        this.number = number;
        products = new ArrayList<>();
        products.add(product);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
        return getClass().getSimpleName() + "{" +
                "number=" + number +
                ", products=" + products +
                '}';
    }

    public static class Product {
        private String name;
        private long price;

        public Product() {
            this.name = "";
            this.price = 0;
        }

        public Product(String name, long price) {
            this.name = name;
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public long getPrice() {
            return price;
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
            return getClass().getSimpleName() + "{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
