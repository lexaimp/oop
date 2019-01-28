package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range segment = new Range(3, 45);
        System.out.println(segment.getLength());
        System.out.println(segment.isInside(14));
        segment.setFrom(15);
        System.out.println(segment.getLength());
        System.out.println(segment.isInside(14));

        System.out.println("Введите данные первого интервала:");
        Range range1 = new Range(scanner.nextDouble(), scanner.nextDouble());
        System.out.println("Введите данные второго интервала:");
        Range range2 = new Range(scanner.nextDouble(), scanner.nextDouble());

        System.out.println("Пересечение:");
        System.out.print("Интервал пересечения двух интервалов: ");
        Range range3 = range1.getIntersection(range2);
        if (range3 == null) {
            System.out.println("null");
        } else {
            System.out.println("(" + range3.getFrom() + "; " + range3.getTo() + ")");
        }
        System.out.println("Объединение:");
        Range[] range4 = range1.getUnion(range2);
        if (range4.length == 2) {
            System.out.println("Получилось 2 интервала объединения: 1 интервал: (" + range4[0].getFrom() + "; " + range4[0].getTo() + ") и 2 интервал: (" + range4[1].getFrom() + "; " + range4[1].getTo() + ")");
        } else {
            System.out.println("Интервал объединения двух интервалов: (" + range4[0].getFrom() + "; " + range4[0].getTo() + ")");
        }
        System.out.println("Разность:");
        range4 = range1.getDifference(range2);
        if (range4.length == 2) {
            System.out.println("Получилось 2 интервала разности: 1 интервал: (" + range4[0].getFrom() + "; " + range4[0].getTo() + ") и 2 интервал: (" + range4[1].getFrom() + "; " + range4[1].getTo() + ")");
        } else if (range4.length == 1) {
            System.out.println("Интервал разности двух интервалов: (" + range4[0].getFrom() + "; " + range4[0].getTo() + ")");
        } else {
            System.out.println("Пустое множество");
        }
    }
}