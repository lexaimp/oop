package ru.academIT.babushkin.Matrix;

import ru.academIT.babushkin.Vector.*;
public class Matrix {
    private Vector[] matrix;

    public Matrix (int n, int m){
        matrix = new Vector[m];
        for (int i = 0; i < m; i++){
            matrix[i] = new Vector(n);
        }
    }
}
