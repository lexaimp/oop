package ru.academIT.babushkin.List.LinkedListMain;

import ru.academIT.babushkin.List.LinkedList.*;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addToBeginning("a");
        list.addToBeginning("b");
        list.addToBeginning("c");
        String a = list.getData(1);
        System.out.println(a);
        System.out.println(list.size());
        System.out.println("________________________");

        System.out.println(list.setData(2, "change"));
        System.out.println(list.getData(2));
        System.out.println("________________________");

        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        list1.addToBeginning("hey");
        System.out.println(list1.removeItem(0));
        System.out.println("________________________");

        System.out.print(list);
        System.out.println();
        list.add(1, "Вася");
        System.out.print(list);
        System.out.println();
        System.out.println("________________________");

        System.out.println(list.removeItem(0));
        System.out.print(list);
        System.out.println();
        System.out.println("________________________");

        list.addToBeginning("куку");
        System.out.println(list);
        list.reverse();
        System.out.println("reverse");
        System.out.println(list);
        SinglyLinkedList list2 = new SinglyLinkedList();
        System.out.println(list2);
        System.out.println("list1 = " + list1);
        SinglyLinkedList<String> copyList = list1.copy();
        System.out.println(copyList);
        System.out.println(copyList.size());
        System.out.println("________________________");

        System.out.println(list.size());
        System.out.println(list.removeItem("Вася"));
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(copyList);
        System.out.println(copyList.getHeadData());
    }
}
