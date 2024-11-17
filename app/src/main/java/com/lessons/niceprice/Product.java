package com.lessons.niceprice;

class Product {
    private double price, weight, result;

    Product(double price, double weight){
        this.price = price;
        this.weight = weight;
        this.result = price / weight;
    }

    double getResult(){
        return result;
    }
    double getPrice(){
        return price;
    }
    double getWeight(){
        return weight;
    }
}
