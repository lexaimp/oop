package ru.academIT.babushkin.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try(PrintWriter writer = new PrintWriter("table.html");
            Scanner scanner = new Scanner(new FileInputStream("РазборCSV.csv"), "windows-1251")) {
            while (scanner.hasNextLine()) {
                writer.println(scanner.nextLine());
            }
        }
    }
}