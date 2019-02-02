package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape triangle1 = new Triangle(1, 7, 15, 3, 2, 6);
        Shape rectangle1 = new Rectangle(5, 3);
        Shape rectangle2 = new Rectangle(2, 7.3);
        Shape shapes[] = {new Square(1), new Circle(23.3), new Circle(5.55)};
        System.out.println(Arrays.toString(shapes));
        Arrays.sort(shapes, new AreaComparator());
        System.out.println(Arrays.toString(shapes));
        Arrays.sort(shapes, new PerimeterComparator());
        System.out.println(Arrays.toString(shapes));
    }
}
