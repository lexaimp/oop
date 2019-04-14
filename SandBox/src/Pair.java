public class Pair<K, V> {
    private K k;
    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;

    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    public void setK(K k) {
        this.k = k;
    }

    public void setV(V v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;
        return k == pair.k && v == pair.v;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>();
        ListItem<T> first = head;
        ListItem<T> second = first.getNext();
        ListItem<T> item = new ListItem<>(head.getData(), null);
        ListItem<T> nextItem;

        while (second != null) {
            if (first == head) {
                listCopy.head = item;
                listCopy.listSize++;
            } else {
                nextItem = new ListItem<>(first.getData(), null);
                item.setNext(nextItem);
                item = nextItem;
                listCopy.listSize++;
            }
            first = second;
            second = second.getNext();
        }
        return listCopy;
    }

}
