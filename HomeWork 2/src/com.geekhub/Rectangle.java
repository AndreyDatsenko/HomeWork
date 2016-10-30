package com.geekhub;

public class Rectangle implements Shape {

    private double a;
    private double b;

    public Rectangle(double[] params) {
        this.a = params[0];
        this.b = params[1];
    }

    @Override
    public double calculateArea() {
        return a * b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (a + b);
    }
}
