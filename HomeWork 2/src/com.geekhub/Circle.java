package com.geekhub;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle implements Shape {

    private double radius;

    public Circle(double[] params) {
        this.radius = params[0];
    }

    @Override
    public double calculateArea() {
        return PI * pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }
}