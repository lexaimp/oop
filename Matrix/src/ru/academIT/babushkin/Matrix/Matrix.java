package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;

public class Matrix {
    private Vector[] rows;

    public Matrix(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Неправильно задана размерность матрицы");
        }
        rows = new Vector[width];
        for (int i = 0; i < width; i++) {
            rows[i] = new Vector(height);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.rows);
    }

    public Matrix(double[][] array) {
        if (array == null) {
            throw new NullPointerException("Входной массив не может быть NULL");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Входной массив не может быть пустым");
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i].length != array[i - 1].length) {
                throw new IllegalArgumentException("Разная размерность входного массива");
            }
        }
        rows = new Vector[array.length];
        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(array[i]);
        }
    }

    private Matrix(Vector[] vectors) {
        rows = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            rows[i] = new Vector(vectors[i]);
        }
    }

    public int getHeight() {
        return rows.length;
    }

    public int getWidth() {
        return rows[0].getSize();
    }

    public void setLine(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Строки по такому индексу не существует");
        }
        rows[index] = new Vector(vector);
    }

    public Vector getLine(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Строки по такому индексу не существует");
        }
        return rows[index];
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= this.getHeight()) {
            throw new IndexOutOfBoundsException("Столбца по такому индексу не существует");
        }
        Vector column = new Vector(this.getHeight());
        for (int i = 0; i < this.getHeight(); ++i) {
            column.setComponent(rows[i].getComponent(index), i);
        }
        return column;
    }

    public void transposition() {
        Matrix matrix = new Matrix(this.getHeight(), this.getWidth());
        for (int i = 0; i < this.getWidth(); ++i) {
            matrix.rows[i] = this.getColumn(i);
        }
        this.rows = matrix.rows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector e : rows) {
            e.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (this.getWidth() != this.getHeight()) {
            throw new IllegalArgumentException("Матрица не является квадратной");
        }
        if (rows.length == 1) {
            return rows[0].getComponent(0);
        }
        if (rows.length == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[0].getComponent(1) * rows[1].getComponent(0);
        }
        double det = 0;
        for (int k = 0; k < rows.length; k++) {
            Matrix minor = new Matrix(rows.length - 1, rows.length - 1);
            for (int i = 1; i < rows.length; i++) {
                int temp = 0;
                for (int j = 0; j < rows.length; j++) {
                    if (j == k) {
                        continue;
                    }
                    minor.rows[i - 1].setComponent(rows[i].getComponent(j), temp);
                    temp++;
                }
            }
            det += Math.pow(-1, k) * rows[0].getComponent(k) * minor.getDeterminant();
        }
        return det;
    }

    public Vector getMultiplyByVector(Vector vector) {
        if (this.getHeight() != vector.getSize()) {
            throw new IllegalArgumentException("Высота матрицы не соответствует ширине вектора");
        }
        Vector vector1 = new Vector(this.getHeight());
        for (int i = 0; i < vector.getSize(); i++) {
            vector1.setComponent(Vector.getScalarProduct(rows[i], vector), i);
        }
        return vector1;
    }

    public void sum(Matrix matrix) {
        if (this.getHeight() != matrix.getHeight() || this.getHeight() != matrix.getHeight()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        for (int i = 0; i < matrix.getHeight(); i++) {
            this.rows[i].sum(matrix.rows[i]);
        }
    }

    private void difference(Matrix matrix) {
        if (this.getHeight() != matrix.getHeight() || this.getHeight() != matrix.getHeight()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        for (int i = 0; i < matrix.getHeight(); i++) {
            this.rows[i].difference(matrix.rows[i]);
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
            resultMatrix.rows[i] = matrix.getMultiplyByVector(matrix2.getColumn(i));
        }
        return resultMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        int var = 0;

        while (true) {
            stringBuilder.append(rows[var].toString());
            if (var == rows.length - 1) {
                return stringBuilder.append("}").toString();
            }

            stringBuilder.append(", ");
            ++var;
        }
    }
}