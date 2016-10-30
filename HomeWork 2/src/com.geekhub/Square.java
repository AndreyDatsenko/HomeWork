package com.geekhub;

public class Square implements Shape {
    private double a;

    public Square(double[] params) {
        this.a = params[0];
    }

    @Override
    public double calculateArea() {
        return a * a;
    }

    @Override
    public double calculatePerimeter() {
        return a * 4;
    }
}
