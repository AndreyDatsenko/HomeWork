package com.geekhub;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("Select the type shape: " + Arrays.toString(ShapeType.values()));
            Scanner scanner = new Scanner(System.in);
            String shapeString = scanner.nextLine();

            if (shapeString.equals("")) {
                break;
            }
            for (ShapeType type : ShapeType.values()) {
                if (type.getName().equalsIgnoreCase(shapeString)) {
                    System.out.println("enter the size of the data:");
                    double[] params = new double[type.getParamsCount()];
                    for (int i = 0; i < type.getParamsCount(); i++) {
                        String param = scanner.nextLine();
                        params[i] = Double.valueOf(param);
                    }
                    ShapeFactory factory = new ShapeFactory();
                    Shape shape = factory.getShape(shapeString, params);

                    if (null != shape) {
                        System.out.println(String.format("area = %1$,.2f", shape.calculateArea()));
                        System.out.println(String.format("perimeter = %1$,.2f", shape.calculatePerimeter()));
                    }

                    if (shapeString.equalsIgnoreCase("square")) {
                        Square square = new Square(params[0]);
                        System.out.println(String.format("area triangle = %1$,.2f", square.triangleArea()));
                        System.out.println(String.format("perimeter triangle = %1$,.2f", square.trianglePerimeter()));
                    } else if (shapeString.equalsIgnoreCase("rectangle")) {
                        Rectangle rectangle = new Rectangle(params[0], params[1]);
                        System.out.println(String.format("area triangle = %1$,.2f", rectangle.triangleArea()));
                        System.out.println(String.format("perimeter triangle = %1$,.2f",
                                rectangle.trianglePerimeter()));
                    }
                }
            }
        }
    }
}
