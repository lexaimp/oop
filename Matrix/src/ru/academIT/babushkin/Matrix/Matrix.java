package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;

public class Matrix {
    private Vector[] rows;

    public Matrix(int columnsCount, int rowsCount) {
        if (columnsCount <= 0 || rowsCount <= 0) {
            throw new IllegalArgumentException("Количество столбцов и строк должны быть больше нуля");
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnsCount);
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
        int maxLength = 0;
        for (double[] e : array) {
            if (maxLength < e.length) {
                maxLength = e.length;
            }
        }
        if (maxLength == 0) {
            throw new IllegalArgumentException("Длинна хотябы одного элемента массива должна быть больше нуля");
        }
        rows = new Vector[array.length];
        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxLength, array[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors == null) {
            throw new NullPointerException("Входной массив не может быть NULL");
        }
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Входной массив не может быть пустым");
        }
        int maxLength = 0;
        for (Vector e : vectors) {
            if (maxLength < e.getSize()) {
                maxLength = e.getSize();
            }
        }
        rows = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            double[] row = new double[vectors[i].getSize()];
            for (int j = 0; j < vectors[i].getSize(); j++) {
                row[j] = vectors[i].getComponent(j);
            }
            rows[i] = new Vector(maxLength, row);
        }
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Строки по такому индексу не существует");
        }
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Длина передаваемого вектора не равна длине строки матрицы");
        }
        rows[index] = new Vector(vector);
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Строки по такому индексу не существует");
        }
        return new Vector(rows[index]);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= this.getColumnsCount()) {
            throw new IndexOutOfBoundsException("Столбца по такому индексу не существует");
        }
        Vector column = new Vector(this.getRowsCount());
        for (int i = 0; i < this.getRowsCount(); ++i) {
            column.setComponent(i, rows[i].getComponent(index));
        }
        return column;
    }

    public void transposition() {
        Vector[] vectors = new Vector[this.getColumnsCount()];
        for (int i = 0; i < this.getColumnsCount(); ++i) {
            vectors[i] = this.getColumn(i);
        }
        this.rows = vectors;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector e : rows) {
            e.multiplyByScalar(scalar);
        }
    }

    public double getDeterminant() {
        if (this.getColumnsCount() != this.getRowsCount()) {
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
                    minor.rows[i - 1].setComponent(temp, rows[i].getComponent(j));
                    temp++;
                }
            }
            det += Math.pow(-1, k) * rows[0].getComponent(k) * minor.getDeterminant();
        }
        return det;
    }

    public Vector getMultiplyByVector(Vector vector) {
        if (this.getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Число столбцов в матрице не совпадает с числом строк в векторе столбце");
        }
        Vector vector1 = new Vector(this.getRowsCount());
        for (int i = 0; i < vector1.getSize(); i++) {
            vector1.setComponent(i, Vector.getScalarProduct(rows[i], vector));
        }
        return vector1;
    }

    public void sum(Matrix matrix) {
        if (this.getRowsCount() != matrix.getRowsCount() || this.getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        for (int i = 0; i < matrix.getRowsCount(); i++) {
            this.rows[i].sum(matrix.rows[i]);
        }
    }

    private void difference(Matrix matrix) {
        if (this.getRowsCount() != matrix.getRowsCount() || this.getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        for (int i = 0; i < matrix.getRowsCount(); i++) {
            this.rows[i].difference(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        Matrix matrix = new Matrix(matrix1);
        matrix.sum(matrix2);
        return matrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsCount() != matrix2.getRowsCount() || matrix1.getColumnsCount() != matrix2.getColumnsCount()) {
            throw new IllegalArgumentException("Размеры матриц не совпадают");
        }
        Matrix matrix = new Matrix(matrix1);
        matrix.difference(matrix2);
        return matrix;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Количество столбцов 1 матрицы не соответствует количеству строк 2 матрицы");
        }
        Matrix resultMatrix = new Matrix(matrix2.getColumnsCount(), matrix1.getRowsCount());
        for (int i = 0; i < matrix1.getRowsCount(); i++) {
            Vector vector = new Vector(matrix2.getColumnsCount());
            for (int j = 0; j < matrix2.getColumnsCount(); j++) {
                vector.setComponent(j, Vector.getScalarProduct(matrix1.rows[i], matrix2.getColumn(j)));
            }
            resultMatrix.rows[i] = vector;
        }
        return resultMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Vector e : rows) {
            stringBuilder.append(e.toString())
                    .append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }
}
