package ru.academIT.babushkin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Передано неверное количество аргументов");
            return;
        }
        try (Scanner scanner = new Scanner(new FileReader(args[0]))) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (scanner.hasNextInt()) {
                arrayList.add(scanner.nextInt());
            }
            System.out.println(arrayList);
            removeEvenNumber(arrayList);
            System.out.println(arrayList);
            arrayList.add(0, 2);
            arrayList.add(1, 18);
            System.out.println(arrayList);
            removeEvenNumber2(arrayList);
            System.out.println(arrayList);

            ArrayList<Integer> arrayListWithoutRepeat = deleteRepeat(arrayList);
            System.out.println(arrayListWithoutRepeat);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось прочитать файл");
        }
    }

    private static void removeEvenNumber(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            while (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
    }

    private static void removeEvenNumber2(ArrayList<Integer> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
    }

    private static ArrayList<Integer> deleteRepeat(ArrayList<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        ArrayList<Integer> copyArrayList = new ArrayList<>();
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            int currentItem = arrayList.get(i);
            if (arrayList.indexOf(currentItem) == arrayList.lastIndexOf(currentItem)) {
                copyArrayList.add(currentItem);
            }
        }
        return copyArrayList;
    }
}