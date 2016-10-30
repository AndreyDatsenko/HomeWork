package com.geekhub;

public enum ShapeType {

    TRIANGLE("TRIANGLE", 3),
    CIRCLE("CIRCLE", 1),
    RECTANGLE("RECTANGLE", 2),
    SQUARE("SQUARE", 1);

    String name;
    int paramsCount;

    ShapeType(String name, int paramsCount) {
        this.name = name;
        this.paramsCount = paramsCount;
    }

    public String getName() {
        return name;
    }

    public int getParamsCount() {
        return paramsCount;
    }
}
