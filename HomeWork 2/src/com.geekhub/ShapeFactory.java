package com.geekhub;

public class ShapeFactory {

    public Shape getShape(String shapeType, double[] params) {
        if (null == shapeType || null == params || params.length == 0) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle(params);
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle(params);
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square(params);
        }else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle(params);
        }

        return null;
    }
}
