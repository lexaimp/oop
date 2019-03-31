package ru.academIT.babushkin.List;

import java.util.List;

public class ArrayList<E> implements List<E> {
    private E[] elements;
    private int length;

    public ArrayList(E[] elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (E e : elements) {
            if (!e.equals(o)) {
                return false;
            }
        }
        return true;
    }

    class Iterable //todo посмотреть реализацию итератора
    public E getFirstElement() {
        if (length == 0) {
            throw new NullPointerException("Невозможно отобразить 1 элемент пустого массива");
        }
        return elements[0];
    }

    public E setElement(int index, E element) {
        if (length < 0 || index > length) {
            throw new IllegalArgumentException("Невозможно положить элемент по индексу меньше нулия или длинны данного массива");
        }

    }
}
