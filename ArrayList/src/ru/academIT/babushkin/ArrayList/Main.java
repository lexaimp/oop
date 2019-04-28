package ru.academIT.babushkin.ArrayList;

import java.util.Collection;
import java.util.Iterator;

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
        System.out.println(arrayList.remove("f"));
        System.out.println(arrayList);

        ArrayList<String> arrayList1 = new ArrayList<>(2);
        arrayList1.add("how are you?");
        arrayList1.add("z");
        System.out.println(arrayList1);
        System.out.println("________________");
        System.out.println(arrayList);
        System.out.println(arrayList.addAll(arrayList1));
        System.out.println(arrayList);
        System.out.println(arrayList.containsAll(arrayList1));

        System.out.println("________________");
        System.out.println("from: " + arrayList1);
        System.out.println("to: " + arrayList);
        System.out.println(arrayList.addAll(2, arrayList1));
        System.out.println(arrayList);
    }
}
