package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Vector.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер вектора: ");
        int size = scanner.nextInt();
        Vector vector1 = new Vector(size);
        System.out.println(vector1.toString());

        double[] array = {5, 7.88, 19, 7, 6.3};
        Vector vector2 = new Vector(array);
        System.out.println("Вектор созданный из массива: " + vector2.toString() + ", Размерность: "
                + vector2.getSize());

        vector1 = new Vector(vector2);
        System.out.println("Скопированный вектор: " + vector1.toString() + " Длинна: " + vector1.getLength());

        System.out.println("Равны ли вектора 1 и 2?: " + vector1.equals(vector2));

        vector2 = new Vector(7, array);
        System.out.println("Вектор созданный из массива: " + vector2.toString() + ", Размерность: "
                + vector2.getSize());

        vector1.sum(vector2);
        System.out.println("Сумма 2х предыдущих векторов векторов: " + vector1.toString());

        vector2.difference(vector1);
        System.out.println("Разность векторов: " + vector2.toString());

        vector2.multiplyByScalar(5);
        System.out.println("Результат умножения вектора на скаляр = 5: " + vector2.toString());

        vector2.setArrayComponent(5.5, 5);
        System.out.println("Компонента по номеру 5: " + vector2.getArrayComponent(5));

        Vector vector3 = Vector.getSum(vector1, vector2);
        System.out.println("Вектор 3 это сумма 2х предыдущих векторов: " + vector3.toString());

        Vector vector4 = Vector.getDifference(vector3, vector2);
        System.out.println("Вектор 4 это разности вектора 3 и вектора 2:" + vector4.toString());

        vector4 = Vector.getScalarProduct(vector4, vector3);
        System.out.println("Скалярное произведение вкеторов 4 и 3: " + vector4);

        vector4.reverseVector();
        System.out.println("Обратный вектор: " + vector4.toString());
    }
}
