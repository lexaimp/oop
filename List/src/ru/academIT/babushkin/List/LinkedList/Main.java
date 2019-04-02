package ru.academIT.babushkin.List.LinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        String a = list.getData(1);
        System.out.println(a);
    }
}
