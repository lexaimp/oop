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
        Shape MaxArea = getMaxArea(shapes);
        System.out.println(MaxArea.toString());
        System.out.println("Площадь: " + MaxArea.getArea());
        System.out.println("Периметр: " + MaxArea.getPerimeter());

        Shape secondForMaxPerimeter = getSecondForMaxPerimeter(shapes);
        System.out.println(secondForMaxPerimeter.toString());
        System.out.println("Площадь: " + secondForMaxPerimeter.getArea());
        System.out.println("Периметр: " + secondForMaxPerimeter.getPerimeter());
    }

    private static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, new AreaComparator());
        return shapes[0];
    }

    private static Shape getSecondForMaxPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[1];
    }
}
