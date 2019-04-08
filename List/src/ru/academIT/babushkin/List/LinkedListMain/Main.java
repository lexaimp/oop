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

        System.out.print(list);
        System.out.println();
        list.add("Вася", 1);
        System.out.print(list);
        System.out.println();
        System.out.println("________________________");

        System.out.println(list.removeItem(0));
        System.out.print(list);
        System.out.println();
        System.out.println("________________________");

        list.add("куку");
        System.out.println(list);
        list.reversList();
        System.out.println("revers");
        SinglyLinkedList<String> copyList = list.copyList();
        System.out.println(copyList);
        System.out.println("________________________");

        System.out.println(list.removeItem("Вася"));
        System.out.println(list);
        System.out.println(copyList);
        System.out.println(copyList.getData());
    }
}
