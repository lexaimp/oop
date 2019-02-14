package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {
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

    public Matrix(Vector[] vectors) {
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
        matrix[index] = new Vector(vector);
    }

    public Vector getLine(int index) {
        return matrix[index];
    }

    public Vector getColumn(int index) {
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
