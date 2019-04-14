package ru.academIT.babushkin.listWithRandomLink;

import ru.academIT.babushkin.List.LinkedList.ListItem;

class ListItemWithTwoLinks<T> extends ListItem<T> {
    private ListItem<T> randomLink;

    ListItemWithTwoLinks(T data, ListItem<T> next, ListItem<T> randomLink) {
        super(data, next);
        this.randomLink = randomLink;
    }

    ListItem<T> getRandomLink() {
        return randomLink;
    }

    void setRandomLink(ListItem<T> randomLink) {
        this.randomLink = randomLink;
    }
}
