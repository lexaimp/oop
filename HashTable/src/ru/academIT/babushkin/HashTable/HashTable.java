//1. Опечатка в имени пакета +
//
//2. Сейчас допускается вместимость 0, но тогда ничего не удастся вставить +
//
//3. Лучше сделать, чтобы getKey принимал Object.+
//И тогда убрать лишние глушения warning'ов +
//
//4. Коллекция должна нормально работать с null данными +
//
//5. iterator-  warning при объявлении.
//И стоит TODO, если все сделано, то нужно убрать +
//
//6. removeAll - можно использовать свой remove

package ru.academIT.babushkin.HashTable;

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
        if (capacity < 1) {
            throw new IllegalArgumentException("Вместимость не может быть меньше 1");
        }
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

    private int getKey(Object obj) {
        return Math.abs(obj.hashCode() % items.length);
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        int key = getKey(o);
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
        if (a == null) {
            throw new NullPointerException("Передаваемый массив не может быть null");
        }
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
        if (e == null) {
            throw new NullPointerException("Передаваемый объект не может быть null");
        }
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
        if (o == null) {
            throw new NullPointerException("Передаваемый объект не может быть null");
        }
        int key = getKey(o);
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
        if (c == null) {
            throw new NullPointerException("Передаваемая коллекция не может быть null.");
        }
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Передаваемая коллекция не может быть null.");
        }
        if (c.isEmpty()) {
            return false;
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException("Передаваемая коллекция не может быть null.");
        }
        int modCount = this.modCount;
        for (Object o : c) {
            int key = getKey(o);
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
        if (c == null) {
            throw new NullPointerException("Передаваемая коллекция не может быть null.");
        }
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].retainAll(c)) {
                    modCount++;
                }
                size += items[i].size();
                if (items[i].size() == 0) {
                    items[i] = null;
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
