package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Lambda.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person("Коля", 30));
        peoples.add(new Person("Оля", 30));
        peoples.add(new Person("Коля", 72));
        peoples.add(new Person("Петя", 10));
        peoples.add(new Person("Максим", 23));
        peoples.add(new Person("Светлана", 17));

        String names = peoples.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));
        System.out.println(names);

        OptionalDouble averageAge = peoples.stream()
                .mapToInt(Person::getAge)
                .filter(x -> x < 18)
                .average();
        System.out.println(averageAge);

        Map<String, Double> map = peoples.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        System.out.println(map.toString());

        StringBuilder stringBuilder = new StringBuilder();
        peoples.stream().filter(x -> x.getAge() >= 20 && x.getAge() <= 45)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .forEachOrdered(person -> stringBuilder.append(person.getName()).append(", "));
        stringBuilder.setLength(stringBuilder.length() - 2);
        System.out.println(stringBuilder);
    }
}
