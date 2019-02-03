package ru.academIT.babushkin.Shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getArea() {
        return Math.abs(0.5 * ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)));
    }

    @Override
    public double getPerimeter() {
        double a = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double b = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double c = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        return a + b + c;
    }

    @Override
    public String toString() {
        return "Треугольник, x1: " + x1 + ", y1: " + y1 + ", x2: " + x2 + ", y2: " + y2 + ", x3: " + x3 + ", y3: " + y3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return triangle.x1 == x1 && triangle.y1 == y1 && triangle.x2 == x2 && triangle.y2 == y2 &&
                triangle.x3 == x3 && triangle.y3 == y3;
    }

    @Override
    public int hashCode() {
        final int prime = 40;
        int hash = 1;
        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(y3);
        return hash;
    }
}
