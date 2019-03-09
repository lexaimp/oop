package ru.academIT.babushkin.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConvertingCsvToHtml {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("csv/src/ru/academIT/babushkin/csv/example.csv"));
             PrintWriter printWriter = new PrintWriter("csv/src/ru/academIT/babushkin/csv/example.html")) {
            printWriter.print("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                    "<title>example</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1>Таблица</h1>\n" +
                    "<table border=\"1\">\n");

            boolean problem = false;
            while (scanner.hasNext()) {
                if (!problem) {
                    printWriter.print("<tr><td>");
                }
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    char symbol = string.charAt(i);

                    if (symbol == '"') {
                        if (i == string.length() - 1) {
                            problem = !problem;
                        } else if (string.charAt(i + 1) == '"' && problem) {
                            printWriter.print(symbol);
                            ++i;
                        } else {
                            problem = !problem;
                        }
                    } else if (symbol == ',') {
                        if (problem) {
                            printWriter.print(",");
                        } else {
                            printWriter.print("</td><td>");
                        }
                    } else {
                        printWriter.print(symbol);
                    }

                }
                if (problem) {
                    printWriter.print("<br/>");
                } else {
                    printWriter.print("</td></tr>");
                }
            }
            printWriter.print("\n</table>\n" +
                    "</body>\n" +
                    "</html>");
        } catch (FileNotFoundException notFound) {
            System.out.println("Не удалось найти файл");
        }
    }
}