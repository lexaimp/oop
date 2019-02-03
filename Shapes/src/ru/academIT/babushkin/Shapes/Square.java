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

    @Override
    public String toString() {
        return "Квадрат, длинна стороны: " + lengthOfSide;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return square.lengthOfSide == lengthOfSide;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(lengthOfSide);
    }
}
