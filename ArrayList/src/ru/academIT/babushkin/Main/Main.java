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

        System.out.println(arrayList);

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Hi");
        arrayList1.add("j");
        System.out.println(arrayList1);

        System.out.println("retain: " + arrayList.retainAll(arrayList1));
        System.out.println(arrayList);

        arrayList.trimToSize();
        System.out.println(arrayList.size());
    }
}
