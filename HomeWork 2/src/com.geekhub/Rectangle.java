package com.geekhub;

import static java.lang.Math.sqrt;

public class Rectangle implements Shape {

    private double side_a;
    private double side_b;

    public Rectangle(double[] params) {
        this.side_a = params[0];
        this.side_b = params[1];
    }

    @Override
    public double calculateArea() {
        return side_a * side_b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (side_a + side_b);
    }

    public double triangleArea() {
        return (side_a * side_b) / 2;
    }

    public double trianglePerimeter() {
        double diagonal = sqrt(Math.pow(side_a, 2) + Math.pow(side_b, 2));
        return diagonal + side_a + side_b;
    }
}
