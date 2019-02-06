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
        this.array = vector.array;
    }

    public Vector(double[] array) {
        this.array = array;
    }

    public Vector(int n, double[] array) {
        this.array = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return array.length;
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

   /* public static Vector getSum (Vector vector1, Vector vector2) {
        vector1.array
    }*/
}