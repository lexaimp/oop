package ru.academIT.babushkin.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add("Hi");
        arrayList.add("how are you?");
        arrayList.add("f");
        arrayList.add(null);
        arrayList.add("z");
        System.out.println(arrayList);
        System.out.println(arrayList.contains("how are you?"));
        System.out.println(arrayList);
        System.out.println(arrayList.remove("hi"));
        System.out.println(arrayList);
    }
}
