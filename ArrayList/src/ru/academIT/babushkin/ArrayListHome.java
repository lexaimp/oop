package ru.academIT.babushkin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ArrayList {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("ArrayList/src/ru/academIT/babushkin/test.txt"))) {
            ArrayList<String> arrayList = new ArrayList();
            while(scanner.hasNextLine()){

            }
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось прочитать файл");
        }
    }
}
