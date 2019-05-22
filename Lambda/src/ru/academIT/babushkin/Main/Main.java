package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Lambda.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person("Коля", 30));
        peoples.add(new Person("Оля", 30));
        peoples.add(new Person("Коля", 72));
        peoples.add(new Person("Петя", 19));
        peoples.add(new Person("Максим", 23));
        peoples.add(new Person("Светлана", 31));

        String names = peoples.stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));
        System.out.println(names);

        OptionalDouble averageAge = peoples.stream()
                .filter(x -> x.getAge() < 18)
                .mapToInt(Person::getAge)
                .average();
        System.out.println(averageAge.isPresent() ? averageAge.getAsDouble() : 0);

        Map<String, Double> map = peoples.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        System.out.println(map.toString());

        StringBuilder stringBuilder = new StringBuilder();
        peoples.stream().filter(x -> x.getAge() >= 20 && x.getAge() <= 45)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .forEachOrdered(person -> stringBuilder.append(person.getName()).append(", "));
        stringBuilder.setLength(stringBuilder.length() - 2);
        System.out.println(stringBuilder);

        //task2 endlessNumbersStream
        Scanner scanner = new Scanner(System.in);
        System.out.print("count of elements: ");
        DoubleStream squares = DoubleStream.iterate(0, x -> x + 1)
                .map(Math::sqrt).limit(scanner.nextInt());
        squares.forEach(System.out::println);

        //endlessNumbersStreamFibonacci
        IntStream.iterate(0, x -> x + 1)
                .map(x -> (int) (Math.pow((1 + Math.sqrt(5)) / 2, x) / Math.sqrt(5) + 0.5))
                .limit(30)
                .forEach(System.out::println);
    }
}