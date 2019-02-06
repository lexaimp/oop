package ru.academIT.babushkin.Vector;

public class Vector {
    private int n;
    private double[] array;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.array = new double[n];
        for (int i = 0; i == n; i++) {
            this.array[i] = 0;
        }
    }

    public Vector(Vector vector){
        this.n = vector.n;
        this.array = vector.array;
    }

    public Vector ()
    public Vector(int n, double[] array) {
        this.n = n;
        this.array = array;
    }
}
