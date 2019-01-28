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

        Range range1 = new Range(scanner.nextDouble(), scanner.nextDouble());
        Range range2 = new Range(scanner.nextDouble(), scanner.nextDouble());
        Range range3 = range1.getIntersection(range2);
        if (range3 == null) {
            System.out.println("null");
        } else {
            System.out.println(range3.getFrom() + " " + range3.getTo());
        }
        Range[] range4 = range1.getUnion(range2);
        if (range4.length == 2) {
            System.out.println(range4[0].getFrom() + " " + range4[0].getTo() + " " + range4[1].getFrom() + " " + range4[1].getTo());
        } else {
            System.out.println(range4[0].getFrom() + " " + range4[0].getTo());
        }
        range4 = range1.getDifference(range2);
        if (range4.length == 2) {
            System.out.println(range4[0].getFrom() + " " + range4[0].getTo() + " " + range4[1].getFrom() + " " + range4[1].getTo());
        } else if (range4.length == 1) {
            System.out.println(range4[0].getFrom() + " " + range4[0].getTo());
        } else {
            System.out.println("Пустое множество");
        }
    }
}