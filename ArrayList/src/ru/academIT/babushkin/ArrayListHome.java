package ru.academIT.babushkin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("ArrayList/src/ru/academIT/babushkin/test.txt"))) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (scanner.hasNextInt()) {
                arrayList.add(scanner.nextInt());
            }
            System.out.println(arrayList);
            removeEvenNumber(arrayList);
            System.out.println(arrayList);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось прочитать файл");
        }
    }

    private static void removeEvenNumber(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
    }
}