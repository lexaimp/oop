package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.ArrayList.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add("Hi");
        arrayList.add("f");
        arrayList.add("how are you?");
        arrayList.add("f");
        arrayList.add(null);
        arrayList.add("z");
        arrayList.add("x");


        System.out.println(arrayList);

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Hi");
        System.out.println(arrayList1);

        System.out.println(arrayList.lastIndexOf("f"));

        arrayList.trimToSize();
        System.out.println(arrayList.size());
    }
}
