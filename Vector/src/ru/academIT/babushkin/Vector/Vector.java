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
        if (array == null) {
            return "null";
        } else {
            int var1 = array.length - 1;
            if (var1 == -1) {
                return "{}";
            } else {
                StringBuilder var2 = new StringBuilder();
                var2.append("{");
                int var3 = 0;

                while (true) {
                    var2.append(array[var3]);
                    if (var3 == var1) {
                        return var2.append("}").toString();
                    }

                    var2.append(", ");
                    ++var3;
                }
            }
        }
    }
}
