package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Matrix.*;
import ru.academIT.babushkin.Vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 5);
        System.out.println(matrix.toString());

        double[][] array = new double[5][5];
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

        System.out.println(matrix1.determinant());

        matrix1.getLine(5);
    }
}
