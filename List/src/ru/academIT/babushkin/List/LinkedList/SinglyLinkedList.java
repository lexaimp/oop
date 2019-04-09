/* 1. Вынесите доп задачу в отдельный модуль, т.к. она не по курсу, и мешает проверять :) -

        2. У списка метод getHeadData без аргументов - по имени не понятен смысл +

        3. setData - лучше назвать setData +

        4. При проверке индексов есть более подходящий тип исключения +

        5. Методы с проверкой индекса - можно не проверять пустоту списка, там и так вылетит исключение +

        6. findItem - у счетчика должно быть имя i +

        7. Например, getHeadData без аргументов - должен кидать исключение если список пуст. + -
        Некоторые другие методы тоже

        8. setData - по факту сейчас обход списка делается дважды, это неэффективно

        9. removeItem - можно обойтись одним обходом вместо 2

        10. addToBeginning с индексом - есть ошибка.
        И можно обойтись одним обходом.
        Обход - дорогая операция, требует линейное время

        11. removeItem(T) - не умеет работать с null данными.
        И надо удалить за 1 проход

        12. Разворот:
        - опечатка в имени метода +
        - в имени метода лишнее слово list, это и так класс списка +
        - не должен падать на пустом списке

        13. Копирование - нужно без разворота, за 1 проход

        14. Имя метода addToBeginning - по имени не понятно, что это вставка в начало.
        По умолчанию считается, что это вставка в конец */

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

    public T getHeadData(int index) {
        return findItem(index).getData();
    }

    public T setData(T data, int index) {
        T temp = getHeadData(index);
        findItem(index).setData(data);
        return temp;
    }

    public T removeItem(int index) {
        if (index == 0) {
            return removeFirstItem();
        }
        T temp = getHeadData(index);
        findItem(index - 1).setNext(findItem(index).getNext());
        count--;
        return temp;
    }


    public void addToBeginning(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void addToBeginning(int index, T data) {
        if (index == 0) {
            this.addToBeginning(data);
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

    public void reverse() {
        if (size() == 0) {
            throw new NullPointerException("Нельзя развернуть пустой список");
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

    public SinglyLinkedList<T> copyList() {
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