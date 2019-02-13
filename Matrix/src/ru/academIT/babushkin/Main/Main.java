package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Matrix.*;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        System.out.println(matrix.toString());

        double[][] array = new double[4][2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 10);
            }
        }

        Matrix matrix1 = new Matrix(array);
        System.out.println(matrix1.toString());
    }
}
