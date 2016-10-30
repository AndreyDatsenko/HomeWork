package com.geekhub;

import static java.lang.Math.sqrt;

public class Triangle implements Shape {

    private double side_a;
    private double side_b;
    private double side_c;

    public Triangle(double[] params) {
        this.side_a = params[0];
        this.side_b = params[1];
        this.side_c = params[2];
    }

    @Override
    public double calculateArea() {
        double halfPerimeter = (side_a + side_b + side_c) / 2;

        return sqrt(halfPerimeter * (halfPerimeter - side_a) * (halfPerimeter - side_b) * (halfPerimeter - side_c));
    }

    @Override
    public double calculatePerimeter() {
        return side_a + side_b + side_c;
    }
}