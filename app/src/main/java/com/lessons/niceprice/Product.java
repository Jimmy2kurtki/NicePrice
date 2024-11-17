package com.lessons.niceprice;

class Product {
    private double price, weight;

    Product(double price, double weight){
        this.price = price;
        this.weight = weight;
    }

    public double getResult(){
        return price/weight;
    }
    public double getPrice(){
        return price;
    }
    public double getWeight(){
        return weight;
    }
}
