package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape triangle1 = new Triangle(1, 7, 15, 3, 2, 6);
        Shape rectangle1 = new Rectangle(5, 3);
        Shape rectangle2 = new Rectangle(2, 7.3);
        Shape square1 = new Square(55);
        Shape triangle2 = new Triangle(12, 4, 5.4, 23, 11.1, 15.7);
        Shape circle1 = new Circle(23.7);

        Shape[] shapes = {triangle1, rectangle1, rectangle2, square1, triangle2, circle1};

        Shape maxArea = getMaxArea(shapes);
        System.out.println(maxArea.toString());
        System.out.println("Площадь: " + maxArea.getArea());
        System.out.println("Периметр: " + maxArea.getPerimeter());

        Shape secondLargestPerimeter = getSecondLargestPerimeter(shapes);
        System.out.println(secondLargestPerimeter.toString());
        System.out.println("Площадь: " + secondLargestPerimeter.getArea());
        System.out.println("Периметр: " + secondLargestPerimeter.getPerimeter());
    }

    private static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }

    private static Shape getSecondLargestPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - 2];
    }
}
