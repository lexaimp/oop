package ru.academIT.babushkin.Shapes;

public class Square implements Shape {
    private double lengthOfSide;

    public Square(double lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    @Override
    public double getWidth() {
        return lengthOfSide;
    }

    @Override
    public double getHeight() {
        return lengthOfSide;
    }

    @Override
    public double getArea() {
        return Math.pow(lengthOfSide, 2);
    }

    @Override
    public double getPerimeter() {
        return lengthOfSide * 4;
    }
}
