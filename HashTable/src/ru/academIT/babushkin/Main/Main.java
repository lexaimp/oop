package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.HashTabe.HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        HashTable<Integer> hashTable = new HashTable<>(30);
        HashTable<Integer> hashTable1 = new HashTable<>();
        for (int i = 0; i < 24; i++) {
            hashTable.add((int) (Math.random() * 30));
            hashTable1.add((int) (Math.random() * 30));
        }
        System.out.println(hashTable);
        System.out.println(hashTable1);

        System.out.println(hashTable.contains(3));

        Integer[] array = new Integer[40];
        for (int i = 0; i < 40; i++) {
            array[i] = 24 * (i + 5);
        }
        System.out.println(Arrays.toString(array));
        hashTable.toArray(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Добавление 1 коллекции во 2: " + hashTable.addAll(hashTable1));
        System.out.println("_______________________________");
        System.out.println(hashTable);
        System.out.println(hashTable.size());
        System.out.println("removeAll" + hashTable.removeAll(hashTable1));
        System.out.println(hashTable.size());
        System.out.println(hashTable);
    }
}