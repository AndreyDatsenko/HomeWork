package com.geekhub;

import static java.lang.Math.sqrt;

public class Rectangle implements Shape {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (sideA + sideB);
    }

    public double triangleArea() {
        return (sideA * sideB) / 2;
    }

    public double trianglePerimeter() {
        double diagonal = sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        return diagonal + sideA + sideB;
    }
}
