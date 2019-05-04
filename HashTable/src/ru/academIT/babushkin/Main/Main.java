package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.HashTabe.HashTable;

public class Main {
    public static void main(String args[]) {
        HashTable<String> hashTable = new HashTable<>(30);
        hashTable.add("a");
        hashTable.add("n");
        System.out.println(hashTable);
    }
}
