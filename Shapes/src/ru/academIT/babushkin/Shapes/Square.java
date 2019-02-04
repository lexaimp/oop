package ru.academIT.babushkin.Shapes;

public class Square implements Shape {
    private double sidelength;

    public Square(double sidelength) {
        this.sidelength = sidelength;
    }

    @Override
    public double getWidth() {
        return sidelength;
    }

    @Override
    public double getHeight() {
        return sidelength;
    }

    @Override
    public double getArea() {
        return Math.pow(sidelength, 2);
    }

    @Override
    public double getPerimeter() {
        return sidelength * 4;
    }

    @Override
    public String toString() {
        return "Квадрат, длина стороны: " + sidelength;
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
        return square.sidelength == sidelength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sidelength);
    }
}
