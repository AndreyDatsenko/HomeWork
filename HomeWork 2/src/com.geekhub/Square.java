package com.geekhub;

import static java.lang.Math.sqrt;

public class Square implements Shape {
    private double side_a;

    public Square(double[] params) {
        this.side_a = params[0];
    }


    @Override
    public double calculateArea() {
        return side_a * side_a;
    }

    @Override
    public double calculatePerimeter() {
        return side_a * 4;
    }

    public double triangleArea() {
        return (side_a * 4) / 2;
    }

    public double trianglePerimeter() {
        return (sqrt(2) * side_a) + (side_a * 2);
    }
}
