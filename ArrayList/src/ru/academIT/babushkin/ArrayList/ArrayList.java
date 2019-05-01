package ru.academIT.babushkin.ArrayList;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
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

    private void ensureCapacityInternal(int capacity) {
        if (capacity <= size) {
            return;
        }
        modCount++;
        items = Arrays.copyOf(items, capacity);
    }

    void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains = false;
        for (Object o : c) {
            contains = false;
            for (T t : this) {
                if (Objects.equals(o, t)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                return false;
            }
        }
        return contains;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        ensureCapacityInternal(size + c.size());
        for (T t : c) {
            this.add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size + c.size()) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        if (c.isEmpty()) {
            return false;
        }
        if (index == size) {
            return (addAll(c));
        }
        ensureCapacityInternal(size + c.size());
        System.arraycopy(items, index, items, index + c.size(), size - index);
        for (T o : c) {
            items[index++] = o;
        }
        modCount++;
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int modCount = this.modCount;
        for (Object o : c) {
            remove(o);
        }
        return modCount != this.modCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int modCount = this.modCount;
        int i = 0;
        while (i < size) {
            if (!contains(i)) {
                remove(i);
            }
            i++;
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
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Index incorrect");
        }
        if (isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
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
        ensureCapacityInternal(size + 1);
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
        System.arraycopy(items, index + 1, items, index, size - index);
        size--;
        modCount++;
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
        for (int i = size - 1; i != 0; i--) {
            if (Objects.equals(items[i], o)) {
                return size - i;
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
