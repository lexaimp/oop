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
        arrayList1.add("f");
        System.out.println(arrayList1);

        System.out.println(arrayList.retainAll(arrayList1));
        System.out.println(arrayList);

        arrayList.trimToSize();
        arrayList.remove(0);
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        String[] array = {"a", "b", "c", "d"};
        String[] array2 = arrayList.toArray(array);
        for (String e: array2) {
            System.out.println(e);
        }
    }
}
