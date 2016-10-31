package com.geekhub;

import static java.lang.Math.sqrt;

public class Square implements Shape {
    private double sideA;

    public Square(double sideA) {
        this.sideA = sideA;
    }

    @Override
    public double calculateArea() {
        return sideA * sideA;
    }

    @Override
    public double calculatePerimeter() {
        return sideA * 4;
    }

    public double triangleArea() {
        return (sideA * 4) / 2;
    }

    public double trianglePerimeter() {
        return (sqrt(2) * sideA) + (sideA * 2);
    }
}
