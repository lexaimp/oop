package ru.academIT.babushkin.List.LinkedListMain;

import ru.academIT.babushkin.List.LinkedList.*;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("с");
        String a = list.getData(2);
        System.out.println(a);
        System.out.println(list.size());

        System.out.println("________________________");

        System.out.println(list.changeData("change", 2));
        System.out.println(list.getData(2));

        System.out.println("________________________");

        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        System.out.println(list.removeItem(1));
    }
}
