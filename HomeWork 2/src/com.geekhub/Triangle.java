package com.geekhub;

import static java.lang.Math.sqrt;

public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double[] params) {
        this.a = params[0];
        this.b = params[1];
        this.c = params[2];
    }

    @Override
    public double calculateArea() {
        double p = (a + b + c) / 2;

        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}