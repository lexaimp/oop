package ru.academIT.babushkin.ArrayList;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int size = 0;
    private int modCount = 0;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        items = (T[]) new Object[5];
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
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
        return (indexOf(o) != -1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int initialModCount = modCount;
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
                if (initialModCount != modCount) {
                    throw new ConcurrentModificationException();
                } else {
                    currentIndex++;
                    return items[currentIndex];
                }
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
            //noinspection SuspiciousSystemArraycopy
            System.arraycopy(items, 0, a.getClass(), 0, size);
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
            items = Arrays.copyOf(items, size * 2);
        }
        items[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        return (remove(index) != null);
    }

    private void ensureCapacityInternal(int capacity) {
        if (capacity <= size) {
            return;
        }
        items = Arrays.copyOf(items, capacity);
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
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
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        ensureCapacityInternal(size + c.size());
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(c.toArray(), 0, items, size, c.size());
        size += c.size();
        modCount++;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        if (c.isEmpty()) {
            return false;
        }
        if (index == size) {
            return addAll(c);
        }
        ensureCapacityInternal(size + c.size());
        System.arraycopy(items, index, items, index + c.size(), size - index);
        for (T o : c) {
            items[index] = o;
            index++;
        }
        modCount++;
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int modCount = this.modCount;
        for (Object o : c) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(items[i], o)) {
                    remove(i);
                    i--;
                }
            }
        }
        return modCount != this.modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int modCount = this.modCount;
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (Object o : c) {
                if (Objects.equals(items[i], o)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                remove(i);
                i--;
            }
        }
        return modCount != this.modCount;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        T itemCopy = items[index];
        items[index] = element;
        return itemCopy;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        if (index == size) {
            add(element);
            return;
        }
        modCount++;
        ensureCapacityInternal(size * 2);
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        T itemCopy = items[index];
        if (size == 1) {
            clear();
        } else {
            System.arraycopy(items, index + 1, items, index, size - index);
            size--;
            modCount++;
        }
        return itemCopy;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
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
