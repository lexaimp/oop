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
        //noinspection unchecked
        int key = getKey((E) o);
        return items[key] != null && items[key].contains(o);
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
                    throw new ConcurrentModificationException("Произошло изменение коллекции во время обхода");
                }
                if (items[currentArrayIndex] == null || items[currentArrayIndex].size() - 1 == currentItemIndex) {
                    currentItemIndex = -1;
                    currentArrayIndex++;
                }
                while (items[currentArrayIndex] == null) {
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
        Object[] array = new Object[size];
        int i = 0;
        for (Object e : this) {
            array[i] = e;
            i++;
        }
        return array;
    }

    @SuppressWarnings({"unchecked", "SuspiciousSystemArraycopy"})
    @Override
    public <T> T[] toArray(T[] a) {
        if (size > a.length) {
            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
        }
        System.arraycopy(toArray(), 0, a, 0, size);
        if (a.length > size) {
            a[this.size] = null;
        }
        return a;
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
        //noinspection unchecked
        int key = getKey((E) o);
        if (items[key] != null && items[key].remove(o)) {
            if (items[key].size() == 0) {
                items[key] = null;
            }
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @SuppressWarnings({"SuspiciousMethodCalls", "unchecked"})
    @Override
    public boolean removeAll(Collection<?> c) {
        int modCount = this.modCount;
        for (Object o : c) {
            int key = getKey((E) o);
            while (items[key] != null && items[key].remove(o)) {
                if (items[key].size() == 0) {
                    items[key] = null;
                }
                size--;
                this.modCount++;
            }
        }
        return modCount != this.modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int size = 0;
        for (LinkedList<E> list : items) {
            if (list != null && list.retainAll(c)) {
                modCount++;
            }
            if (list != null) {
                size += list.size();
                if (list.size() == 0) {
                    list = null;
                }
            }
        }
        if (size == this.size) {
            return false;
        }
        this.size = size;
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        size = 0;
        modCount++;
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
