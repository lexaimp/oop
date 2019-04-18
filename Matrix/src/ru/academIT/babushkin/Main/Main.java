package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Matrix.*;
import ru.academIT.babushkin.Vector.*;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 5);
        System.out.println("Матрица 3x5:");
        System.out.println(matrix.toString());

        double[][] array = new double[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 15);
            }
        }

        Matrix matrix1 = new Matrix(array);
        System.out.println("Матрица созданная из массива:");
        System.out.println(matrix1.toString());
        System.out.println("MatrixHeight:" + matrix1.getRowsCount() + ", MatrixWidth:" + matrix1.getColumnsCount());

        Vector vector = matrix1.getColumn(1);
        System.out.println("1 столбец матрицы:");
        System.out.println(vector.toString());

        System.out.println("2 строка матрицы:");
        System.out.println(matrix1.getRow(1));
        matrix1.setRow(1, vector);
        System.out.println("Меняем 2 строку матрицы на вектор:");
        System.out.println(matrix1.getRow(1));

        System.out.println("Исходная матрица");
        System.out.println(matrix1.toString());
        matrix1.transposition();
        System.out.println("Транспонирование матрицы:");
        System.out.println(matrix1.toString());

        matrix1.multiplyByScalar(3);
        System.out.println("Умножение на скаляр:");
        System.out.println(matrix1.toString());

        System.out.println("Получение определителя матрицы:");
        System.out.println(matrix1.getDeterminant());

        Vector vector1 = new Vector(array[0]);
        System.out.println("Вектор:");
        System.out.println(vector1.toString());
        System.out.println("Умножение матрицы на вектор:");
        System.out.println(matrix1.getMultiplyByVector(vector1).toString());

        Matrix matrix2 = new Matrix(matrix1);
        System.out.println("Копия предыдущей матрицы:");
        System.out.println(matrix2.toString());
        matrix2.sum(matrix1);
        System.out.println("Результат сложения:");
        System.out.println(matrix2.toString());

        System.out.println("Матрица 1: " + matrix1.toString());
        System.out.println("Матрица 2: " + matrix2.toString());


        Matrix matrix3 = Matrix.getSum(matrix1, matrix2);
        System.out.println("Сумма матрицы 1 и матрицы 2:");
        System.out.println(matrix3);

        matrix3 = Matrix.getDifference(matrix2, matrix1);
        System.out.println("Раздница матрицы 2 и матрицы 1:");
        System.out.println(matrix3);

        double[][] array1 = new double[3][2];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = (int) (Math.random() * 25);
            }
        }

        double[][] array2 = new double[2][3];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j] = (int) (Math.random() * 12);
            }
        }

        matrix1 = new Matrix(array1);
        matrix2 = new Matrix(array2);
        System.out.println("Матрица 1");
        System.out.println(matrix1.toString());
        System.out.println("Матирца 2");
        System.out.println(matrix2.toString());

        System.out.println("Умножение матрицы 1 на матрицу 2:");
        matrix3 = Matrix.getMultiplication(matrix1, matrix2);
        System.out.println(matrix3.toString());


        Vector[] vectors = new Vector[3];
        vectors[0] = vector;
        vectors[1] = vector1;
        vectors[2] = new Vector(4);
        System.out.println("2 вектора");
        System.out.println(vectors[0]);
        System.out.println(vectors[1]);
        System.out.println(vectors[2]);

        Matrix matrix4 = new Matrix(vectors);
        System.out.println("Matrix");
        System.out.println(matrix4);
    }
}
