package com.lessons.niceprice;

class Product {
    private double price, weight, result;

    Product(double price, double weight){
        this.price = price;
        this.weight = weight;
        this.result = price / weight;
    }

    public double getResult(){
        return result;
    }
    public double getPrice(){
        return price;
    }
    public double getWeight(){
        return weight;
    }
}
