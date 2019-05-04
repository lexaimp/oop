package ru.academIT.babushkin.HashTabe;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private LinkedList<E>[] items;
    private int size = 0;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        items = new LinkedList[10];
    }

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        items = new LinkedList[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int getKey(E element) {
        return Math.abs(element.hashCode() % items.length);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int initialModCount = modCount;
            private int currentNodeCount = 0;
            private int currentArrayIndex = 0;
            private int currentItemIndex = -1;

            @Override
            public boolean hasNext() {
                return currentNodeCount < size;
            }
//todo
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Нет такого элемента");
                }
                if (initialModCount != modCount) {
                    throw new ConcurrentModificationException("Произошло изменение во время обхода коллекции");
                }
                while (items[currentArrayIndex] == null) {
                    currentArrayIndex++;
                }
                if (items[currentArrayIndex].size() - 1 == currentItemIndex) {
                    currentItemIndex = -1;
                    currentArrayIndex++;
                }
                currentNodeCount++;
                currentItemIndex++;
                return items[currentArrayIndex].get(currentItemIndex);
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        int key = getKey(e);
        if (items[key] == null) {
            items[key] = new LinkedList<>();
        }
        items[key].add(e);
        modCount++;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (E e : this) {
            stringBuilder.append(e)
                    .append(", ");
        }
        if (size != 0) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        return stringBuilder.append("]").toString();
    }
}
