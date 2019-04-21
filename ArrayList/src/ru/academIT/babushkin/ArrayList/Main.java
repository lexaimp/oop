package ru.academIT.babushkin.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add("Hi");
        arrayList.add("how are you?");
        arrayList.add(null);
        System.out.println(arrayList);
        System.out.println(arrayList.contains("how are you?"));
    }
}
