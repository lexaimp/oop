package ru.academIT.babushkin.ArrayList;

import java.util.*;
import java.util.function.Consumer;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость списка не может быть меньше 0");
        }
        items = (T[]) new Object[capacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (T t : this) {
            if (Objects.equals(t, o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int initialModCount = modCount;
            private int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex + 1 < size();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("Нет такого элемента");
                }
                if (initialModCount == modCount) {
                    currentIndex++;
                    return items[currentIndex];
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public void remove() {
                if (currentIndex + 1 != size) {
                    System.arraycopy(items, currentIndex + 1, items, currentIndex, size - currentIndex);
                }
                size--;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (size > a.length) {
            return Arrays.copyOf(a, a.length);
        } else {
            System.arraycopy(items, 0, a, 0, size);
            if (a.length > size) {
                a[this.size] = null;
            }
            return a;
        }
    }

    @Override
    public boolean add(T t) {
        modCount++;
        if (size == items.length) {
            items = Arrays.copyOf(items, size + 10);
        }
        items[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), o)) {
                modCount++;
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains = false;
        for (T t : this) {
            contains = false;
            for (Object o : c) {
                if (Objects.equals(t, o)){
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (T t : this) {
            stringBuilder.append(t)
                    .append(", ");
        }
        if (size != 0) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        return stringBuilder.append("]").toString();
    }
}
