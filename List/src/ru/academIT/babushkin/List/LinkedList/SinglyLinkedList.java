package ru.academIT.babushkin.List.LinkedList;

import org.omg.CosNaming.NamingContextPackage.NotFound;

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

    private ListItem<T> findItem(int index) {
        if (count == 0) {
            return head;
        }
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Неправильно укзан индекс");
        }
        int count = 1;
        ListItem<T> p = head;
        while (count <= index) {
            p = p.getNext();
            count++;
        }
        return p;
    }

    public T getData() {
        return head.getData();
    }

    public T getData(int index) {
        return findItem(index).getData();
    }

    public T changeData(T data, int index) {
        T temp = getData(index);
        findItem(index).setData(data);
        return temp;
    }

    //    todo Найти подходящий тип исключения если пвтаемся удалить элемент из пустого свписка
    public T removeItem(int index) {
        if (size() == 0) {
        }
        T temp = getData(index);
        findItem(index - 1).setNext(findItem(index).getNext());
        count--;
        return temp;
    }


    public void add(T data) {
        ListItem<T> p = new ListItem<>(data, head);
        head = p;
        count++;
    }

    public void add(ListItem<T> listItem, int index) {

    }
}