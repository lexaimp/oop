package ru.academIT.babushkin.List.LinkedList;

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
