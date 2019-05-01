package ru.academIT.babushkin.ArrayList;

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

        ArrayList<String> arrayList1 = new ArrayList<>(2);
        arrayList1.add("hey");
        arrayList1.add("f");

        System.out.println(arrayList1);
        System.out.println(arrayList.retainAll(arrayList1));
        System.out.println(arrayList);

        arrayList.trimToSize();
        System.out.println(arrayList.size());
    }
}
