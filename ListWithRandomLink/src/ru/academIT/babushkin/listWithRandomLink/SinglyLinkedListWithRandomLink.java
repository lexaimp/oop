package ru.academIT.babushkin.listWithRandomLink;

import com.sun.org.apache.xpath.internal.operations.String;
import ru.academIT.babushkin.List.LinkedList.ListItem;

public class SinglyLinkedListWithRandomLink<T> {
    private ListItemWithTwoLinks<T> head;
    private int count;

    public void test() {
        ListItem<Integer> listItem = new ListItemWithTwoLinks<>(1, null, null);
    }
}
