package ru.academIT.babushkin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Передано неверное количество аргументов");
            return;
        }
        try (Scanner scanner = new Scanner(new FileReader(args[0]))) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (scanner.hasNext()) {
                arrayList.add(scanner.nextLine());
            }
            System.out.println(arrayList);

            ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 123, 5, 6, 6, 9, 98, 6, 3, 3));
            System.out.println(arrayList1);

            removeEvenNumber(arrayList1);
            System.out.println(arrayList1);

            ArrayList<Integer> arrayListWithoutRepeat = deleteRepeat(arrayList1);
            System.out.println(arrayListWithoutRepeat);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось прочитать файл");
        }
    }

    private static void removeEvenNumber(ArrayList<Integer> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; --i) {
            if (arrayList.get(i) % 2 == 0) {
                arrayList.remove(i);
            }
        }
    }

    private static ArrayList<Integer> deleteRepeat(ArrayList<Integer> arrayList) {
        ArrayList<Integer> copyArrayList = new ArrayList<>();
        for (Integer e : arrayList) {
            if (!copyArrayList.contains(e)) {
                copyArrayList.add(e);
            }
        }
        return copyArrayList;
    }
}