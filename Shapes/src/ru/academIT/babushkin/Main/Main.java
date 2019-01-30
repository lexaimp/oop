package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Shapes.*;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(13, 78, 874, -87, 98, 7812);
        System.out.println(triangle.getArea());
    }
}
