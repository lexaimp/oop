package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Vector.*;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(5);
        System.out.println(vector.toString());
        Vector vector1 = new Vector(vector);
        System.out.println(vector1.toString());
        double[] array = {1.2, 15.4, 18.23, 1.1, 45};
        Vector vector2 = new Vector(array);
        System.out.println(vector2.toString());
        Vector vector3 = new Vector(10, array);
        System.out.println(vector3.toString());
        System.out.println(vector2.getSize());
    }
}
