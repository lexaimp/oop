
package ru.academIT.babushkin.List.LinkedList;

import java.util.Objects;

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
            count++;
        }
    }

    public boolean removeItem(T data) {
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = p.getNext()) {
            if (Objects.equals(p.getData(), data)) {
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
            throw new NullPointerException("Спиок пуст");
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
        ListItem<T> p = head;
        ListItem<T> next = p.getNext();
        head.setNext(null);
        while (next != null) {
            ListItem<T> prev = p;
            p = next;
            next = p.getNext();
            p.setNext(prev);
        }
        head = p;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copyList = new SinglyLinkedList<>();
        if (head == null) {
            return copyList;
        }
        ListItem<T> item = new ListItem<>(head.getData(), null);
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p == head) {
                copyList.head = item;
            } else {
                ListItem<T> copyItem = new ListItem<>(p.getData(), null);
                item.setNext(copyItem);
                item = copyItem;
            }
        }
        copyList.count = count;
        return copyList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData())
                    .append(", ");
        }
        if (head != null) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        return stringBuilder.append("}").toString();
    }
}