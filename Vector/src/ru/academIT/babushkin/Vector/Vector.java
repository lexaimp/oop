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

    public Vector sum(Vector vector) {
        if (getSize() <= vector.getSize()) {
            array = Arrays.copyOf(array, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            array[i] += vector.array[i];
        }
        return vector;
    }

    public void difference(Vector vector) {
        this.reverseVector(vector);
        this.sum(vector);
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < this.getSize(); i++) {
            this.array[i] *= scalar;
        }
    }

    public void multiplyByScalar(int scalar) {
        for (int i = 0; i < this.getSize(); i++) {
            this.array[i] *= scalar;
        }
    }

    public void reverseVector(Vector vector) {
        if (getSize() <= vector.getSize()) {
            array = Arrays.copyOf(array, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            array[i] = vector.array[i] * -1;
        }
    }

    public double getVectorLength() {
        double sum = 0;
        for (double e : array) {
            sum = Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double getArrayComponent(int index) {
        if (index < 0 || index > this.getSize() - 1) {
            throw new IllegalArgumentException();
        }
        return array[index];
    }

    public void setArrayComponent(double component, int index) {
        if (index < 0 || index > this.getSize() - 1) {
            throw new IllegalArgumentException();
        }
        array[index] = component;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Vector vector = (Vector) o;
        return Arrays.equals(array, vector.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.sum(vector2);
        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);
        vector.difference(vector2);
        return vector;
    }

    // TODO: 08.02.19
   /* public static Vector getScalarProduct(Vector vector1, Vector vector2) {

    }*/
}