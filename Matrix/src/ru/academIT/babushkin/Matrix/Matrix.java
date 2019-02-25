package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Неправильно задана размерность матрицы");
        }
        matrix = new Vector[m];
        for (int i = 0; i < m; i++) {
            matrix[i] = new Vector(n);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.matrix);
    }

    public Matrix(double[][] array) {
        matrix = new Vector[array.length];
        for (int i = 0; i < array.length; i++) {
            matrix[i] = new Vector(array[i]);
        }
    }

    private Matrix(Vector[] vectors) {
        matrix = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            matrix[i] = new Vector(vectors[i]);
        }
    }

    public int getHeight() {
        return matrix.length;
    }

    public int getWidth() {
        return matrix[0].getSize();
    }

    public void setLine(int index, Vector vector) {
        if (index < 0 || index >= matrix.length) {
            throw new IndexOutOfBoundsException("Строки по такому индексу не существует");
        }
        matrix[index] = new Vector(vector);
    }

    public Vector getLine(int index) {
        if (index < 0 || index >= matrix.length) {
            throw new IndexOutOfBoundsException("Строки по такому индексу не существует");
        }
        return matrix[index];
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= this.getHeight()) {
            throw new IndexOutOfBoundsException("Столбца по такому индексу не существует");
        }
        Vector column = new Vector(this.getHeight());
        for (int i = 0; i < this.getHeight(); ++i) {
            column.setComponent(matrix[i].getComponent(index), i);
        }
        return column;
    }

    public void transposition() {
        Matrix matrix = new Matrix(this.getHeight(), this.getWidth());
        for (int i = 0; i < this.getWidth(); ++i) {
            matrix.matrix[i] = this.getColumn(i);
        }
        this.matrix = matrix.matrix;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector e : matrix) {
            e.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (this.getWidth() != this.getHeight()) {
            throw new IllegalArgumentException("Матрица не является квадратной");
        }
        if (matrix.length == 1) {
            return matrix[0].getComponent(0);
        }
        if (matrix.length == 2) {
            return matrix[0].getComponent(0) * matrix[1].getComponent(1) - matrix[0].getComponent(1) * matrix[1].getComponent(0);
        }
        double det = 0;
        for (int k = 0; k < matrix.length; k++) {
            Matrix minor = new Matrix(matrix.length - 1, matrix.length - 1);
            for (int i = 1; i < matrix.length; i++) {
                int temp = 0;
                for (int j = 0; j < matrix.length; j++) {
                    if (j == k) {
                        continue;
                    }
                    minor.matrix[i - 1].setComponent(matrix[i].getComponent(j), temp);
                    temp++;
                }
            }
            det += Math.pow(-1, k) * matrix[0].getComponent(k) * minor.getDeterminant();
        }
        return det;
    }

    public Vector getMultiplyByVector(Vector vector) {
        if (this.getHeight() != vector.getSize()) {
            throw new IllegalArgumentException("Высота матрицы не соответствует ширине вектора");
        }
        Vector vector1 = new Vector(this.getHeight());
        for (int i = 0; i < vector.getSize(); i++) {
            vector1.setComponent(Vector.getScalarProduct(matrix[i], vector), i);
        }
        return vector1;
    }

    public void sum(Matrix matrix) {
        if (this.getHeight() != matrix.getHeight() || this.getHeight() != matrix.getHeight()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        for (int i = 0; i < matrix.getHeight(); i++) {
            this.matrix[i].sum(matrix.matrix[i]);
        }
    }

    private void difference(Matrix matrix) {
        if (this.getHeight() != matrix.getHeight() || this.getHeight() != matrix.getHeight()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        for (int i = 0; i < matrix.getHeight(); i++) {
            this.matrix[i].difference(matrix.matrix[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getHeight() != matrix2.getHeight() || matrix1.getWidth() != matrix2.getWidth()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        Matrix matrix = new Matrix(matrix1);
        matrix.sum(matrix2);
        return matrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getHeight() != matrix2.getHeight() || matrix1.getWidth() != matrix2.getWidth()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        Matrix matrix = new Matrix(matrix1);
        matrix.difference(matrix2);
        return matrix;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getHeight() != matrix2.getWidth()) {
            throw new IllegalArgumentException("Высота умножаемой матрицы не соответствует ширине матрицы на которую умножают");
        }
        Matrix resultMatrix = new Matrix(matrix1.getHeight(), matrix2.getWidth());
        for (int i = 0; i < matrix1.getHeight(); i++) {
            Matrix matrix = new Matrix(matrix1);
            resultMatrix.matrix[i] = matrix.getMultiplyByVector(matrix2.getColumn(i));
        }
        return resultMatrix;
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