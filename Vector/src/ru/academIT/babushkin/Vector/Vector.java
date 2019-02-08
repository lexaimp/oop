package ru.academIT.babushkin.Vector;

import java.util.Arrays;

public class Vector {
    private double[] array;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.array = new double[n];
    }

    public Vector(Vector vector) {
        this.array = Arrays.copyOf(vector.array, vector.array.length);
    }

    public Vector(double[] array) {
        if (array.length <= 0) {
            throw new IllegalArgumentException();
        }
        this.array = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.array = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return array.length;
    }

    private static Vector getVectorWithMaxSize(Vector vector1, Vector vector2) {
        return vector1.getSize() >= vector2.getSize() ? vector1 : vector2;
    }

    private static Vector getVectorWithMinSize(Vector vector1, Vector vector2) {
        return vector1.getSize() <= vector2.getSize() ? vector1 : vector2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        int var = 0;

        while (true) {
            stringBuilder.append(array[var]);
            if (var == array.length - 1) {
                return stringBuilder.append("}").toString();
            }

            stringBuilder.append(", ");
            ++var;
        }
    }

    public void getSum(Vector vector) {
        if (getSize() <= vector.getSize()) {
            array = Arrays.copyOf(array, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            array[i] += vector.array[i];
        }
    }

    public void getReverseVector(Vector vector) {
        if (getSize() <= vector.getSize()) {
            array = Arrays.copyOf(array, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            array[i] = vector.array[i] * -1;
        }
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector max = Vector.getVectorWithMaxSize(vector1, vector2);
        Vector min = Vector.getVectorWithMinSize(vector1, vector2);
        for (int i = 0; i < min.getSize(); i++) {
            max.array[i] = vector1.array[i] + vector2.array[i];
        }
        return max;
    }
}