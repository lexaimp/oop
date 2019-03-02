package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;

public class Matrix {
    private Vector[] rows;

    public Matrix(int columnCount, int rowsCount) {
        if (columnCount <= 0 || rowsCount <= 0) {
            throw new IllegalArgumentException("Неправильно задана размерность матрицы");
        }
        rows = new Vector[rowsCount];
        for (int i = 0; i < rowsCount; i++) {
            rows[i] = new Vector(columnCount);
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
        double length = array[0].length;
        for (double[] e : array) {
            if (length != e.length) {
                throw new IllegalArgumentException("Разная размерность входного массива");
            }
        }
        rows = new Vector[array.length];
        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(array[i]);
        }
    }

    private Matrix(Vector[] vectors) {
        if (vectors == null) {
            throw new NullPointerException("Входной массив не может быть NULL");
        }
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Входной массив не может быть пустым");
        }
        if (vectors.length != 1) {
            for (int i = 1; i < vectors.length; i++) {
                if (vectors[i].getSize() != vectors[i - 1].getSize()) {
                    throw new IllegalArgumentException("Разная размерность входного массива");
                }
            }
        }
        rows = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            rows[i] = new Vector(vectors[i]);
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
        if (rows[0].getSize() != vector.getSize()) {
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
            column.setComponent(rows[i].getComponent(index), i);
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
                    minor.rows[i - 1].setComponent(rows[i].getComponent(j), temp);
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
            vector1.setComponent(Vector.getScalarProduct(rows[i], vector), i);
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
        Matrix matrix = new Matrix(matrix1.getRowsCount(), matrix2.getColumnsCount());
        for (int i = 0; i < matrix2.getColumnsCount(); i++) {
            matrix.setRow(i, matrix1.getMultiplyByVector(matrix2.getColumn(i)));
        }
        matrix.transposition();
        return matrix;
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
