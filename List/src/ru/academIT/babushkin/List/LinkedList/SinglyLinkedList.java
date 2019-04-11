/* 1. Вынесите доп задачу в отдельный модуль, т.к. она не по курсу, и мешает проверять :) -

        13. Копирование - нужно без разворота, за 1 проход

        14. Имя метода add - по имени не понятно, что это вставка в начало.
        По умолчанию считается, что это вставка в конец + */

package ru.academIT.babushkin.List.LinkedList;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
        count = 0;
    }

    public int size() {
        return count;
    }

    private ListItem<T> findItem(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Неправильно укзан индекс");
        }
        int i = 1;
        ListItem<T> p = head;
        while (i <= index) {
            p = p.getNext();
            i++;
        }
        return p;
    }

    public T getHeadData() {
        if (size() == 0) {
            throw new NullPointerException("Нельзя получить данные у пустого списка");
        }
        return head.getData();
    }

    public T getData(int index) {
        return findItem(index).getData();
    }

    public T setData(int index, T data) {
        ListItem<T> desiredItem = findItem(index);
        T temp = desiredItem.getData();
        desiredItem.setData(data);
        return temp;
    }

    public T removeItem(int index) {
        if (index == 0) {
            return removeFirstItem();
        }
        ListItem<T> prevItem = findItem(index - 1);
        T temp = prevItem.getNext().getData();
        prevItem.setNext(prevItem.getNext().getNext());
        count--;
        return temp;
    }


    public void addToBeginning(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void add(int index, T data) {
        if (index == 0) {
            this.addToBeginning(data);
        } else {
            ListItem<T> temp = findItem(index - 1);
            temp.setNext(new ListItem<>(data, temp.getNext()));
        }
        count++;
    }

    public boolean removeItem(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                if (prev == null) {
                    clear();
                    return true;
                }
                prev.setNext(p.getNext());
                count--;
                return true;
            }
        }
        return false;
    }

    private void clear() {
        head = null;
        count = 0;
    }

    private T removeFirstItem() {
        if (size() == 0) {
            throw new IllegalArgumentException("Спиок пуст");
        }
        T temp = head.getData();
        head = head.getNext();
        count--;
        return temp;
    }

    public void reverse() {
        if (size() == 0) {
            return;
        }
        ListItem<T> prev;
        ListItem<T> p = head;
        ListItem<T> next = p.getNext();
        head.setNext(null);
        while (next != null) {
            prev = p;
            p = next;
            next = p.getNext();
            p.setNext(prev);
        }
        head = p;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            copyList.addToBeginning(p.getData());
        }
        copyList.reverse();
        return copyList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData())
                    .append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }
}