package ru.academIT.babushkin.List.LinkedList;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        count = 0;
    }

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        count = 1;
    }

    public int size() {
        return count;
    }

    public T getData() {
        return head.getData();
    }

    public T getData(int index) {
        int count = 0;
        ListItem<T> p = head;
        while (count <= index) {
            p = p.getNext();
            count++;
        }
        return p.getData();
    }

    public void add(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
        count++;
    }

    public void add(ListItem<T> listItem, int index) {

    }
}