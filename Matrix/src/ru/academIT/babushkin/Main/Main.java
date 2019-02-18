package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Matrix.*;
import ru.academIT.babushkin.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 5);
        System.out.println(matrix.toString());

        double[][] array = new double[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 15);
            }
        }

        Matrix matrix1 = new Matrix(array);
        System.out.println(matrix1.toString());

        System.out.println(matrix1.getHeight() + " " + matrix1.getWidth());

        Vector vector = matrix1.getColumn(1);
        System.out.println(vector.toString());

        matrix1.transposition();
        System.out.println(matrix1.toString());

        matrix1.multiplyByScalar(3);
        System.out.println(matrix1.toString());

        System.out.println(matrix1.getDeterminant());

        Vector vector1 = new Vector(array[0]);

        System.out.println(vector1.toString());
        System.out.println(matrix1.getMultiplyByVector(vector1).toString());

        Matrix matrix2 = new Matrix(matrix1);

        System.out.println(matrix2.toString());
        matrix2.sum(matrix1);
        System.out.println(matrix2.toString());

        matrix1.getMultiplyByVector(vector);
        System.out.println("Проверка умноежния");
        System.out.println(matrix1.toString());
        System.out.println(matrix2.toString());
        System.out.println("Результат");

        Matrix matrix3 = Matrix.getMultiplication(matrix1,matrix2);
        System.out.println(matrix3.toString());
    }
}
