package ru.academIT.babushkin.Vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равана 0");
        }
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равана 0");
        }
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть меньше или равана 0");
        }
        this.components = Arrays.copyOf(components, n);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double e : components) {
            stringBuilder.append(e)
                    .append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }

    public void sum(Vector vector) {
        if (getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            components[i] += vector.components[i];
        }
    }

    public void difference(Vector vector) {
        if (getSize() < vector.getSize()) {
            components = Arrays.copyOf(components, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        this.multiplyByScalar(-1);
    }

    public double getLength() {
        double sum = 0;
        for (double e : components) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Компоненты по такому индексу не существует");
        }
        return components[index];
    }

    public void setComponent(double component, int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new IndexOutOfBoundsException("Компоненты по такому индексу не существует");
        }
        components[index] = component;
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
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
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

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double product = 0;
        int minSize = Math.min(vector1.getSize(), vector2.getSize());
        for (int i = 0; i < minSize; i++) {
            product += vector1.components[i] * vector2.components[i];
        }
        return product;
    }
}