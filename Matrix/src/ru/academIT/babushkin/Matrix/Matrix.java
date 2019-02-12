package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;

import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        matrix = new Vector[m];
        for (int i = 0; i < m; i++) {
            matrix[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        this.matrix = Arrays.copyOf(matrix.matrix, matrix.matrix.length);
    }

    public Matrix(double[][] array) {
        for(int i = 0; i < array.length; i++) {
            matrix[i] = new Vector(array[i].length, array[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        int var = 0;

        while (true) {
            stringBuilder.append(matrix[var].toString());
            if (var == matrix.length - 1) {
                return stringBuilder.append("}").toString();
            }

            stringBuilder.append(", ");
            ++var;
        }
    }
}
