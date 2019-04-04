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

    private ListItem<T> findItem(int index) {
        if (count == 0) {
            throw new NullPointerException("Список пуст");
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

    public T removeItem(int index) {
        if (index == 0) {
            return removeFirstItem();
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

    public void add(T data, int index) {
        if (index == 0) {
            this.add(data);
        } else {
            ListItem<T> p = new ListItem<>(data, findItem(index));
            findItem(index - 1).setNext(p);
        }
        count++;
    }

    public boolean removeItem(T data) {
        int index = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p.getData().equals(data)) {
                this.removeItem(index);
                return true;
            }
            index++;
        }
        return false;
    }

    private T removeFirstItem() {
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    //  todo
    public void reversList() {
        ListItem<T> p = head;
        while (p != null) {
            ListItem<T> s = new ListItem<>();
            p.getNext().setNext(p);
        }
    }
}