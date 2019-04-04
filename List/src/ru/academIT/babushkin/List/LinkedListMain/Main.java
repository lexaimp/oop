package ru.academIT.babushkin.List.LinkedListMain;

import ru.academIT.babushkin.List.LinkedList.*;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String a = list.getData(1);
        System.out.println(a);
        System.out.println(list.size());

        System.out.println("________________________");

        System.out.println(list.changeData("change", 2));
        System.out.println(list.getData(2));

        System.out.println("________________________");

        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        list1.add("hey");
        System.out.println(list1.removeItem(0));

        System.out.println("________________________");
        System.out.print(list.getData(0) + ", " + list.getData(1) + ", " + list.getData(2));
        System.out.println();
        list.add("Вася", 1);
        System.out.print(list.getData(0) + ", " + list.getData(1) + ", " + list.getData(2) + ", " + list.getData(3));
        System.out.println();


        System.out.println(list.removeItem(0));
        System.out.print(list.getData(0) + ", " + list.getData(1) + ", " + list.getData(2));
        System.out.println();

        System.out.println("________________________");
        System.out.print(list.getData(0) + ", " + list.getData(1) + ", " + list.getData(2));
        list.reversList();
        System.out.print(list.getData(0) + ", " + list.getData(1) + ", " + list.getData(2));
    }
}
