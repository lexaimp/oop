package ru.academIT.babushkin.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConvertingCsvToHtml {
    public static void main(String[] args) {
        if (args.length == 1) {
            switch (args[0]) {
                case "--help":
                    System.out.println(getHelp());
                    break;
                case "--version":
                    System.out.println(getVersion());
                    break;
            }
            return;
        }
        if (args.length != 2) {
            System.out.println("Передано неверное количество аргументов");
            System.out.println(getHelp());
        }
        try (Scanner scanner = new Scanner(new FileReader(args[0]));
             PrintWriter printWriter = new PrintWriter(args[1])) {
            String ls = System.lineSeparator();
            printWriter.print("<!DOCTYPE html>" + ls +
                    "<html>" + ls +
                    "<head>" + ls +
                    "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" + ls +
                    "<title>example</title>" + ls +
                    "</head>" + ls +
                    "<body>" + ls +
                    "<h1>Таблица</h1>" + ls +
                    "<table border=\"1\">");

            boolean cellInQuotes = false;
            while (scanner.hasNext()) {
                if (!cellInQuotes) {
                    printWriter.print("<tr><td>");
                }
                String string = scanner.nextLine();
                for (int i = 0; i < string.length(); i++) {
                    char symbol = string.charAt(i);

                    if (symbol == '"') {
                        if (i == string.length() - 1) {
                            cellInQuotes = !cellInQuotes;
                        } else if (string.charAt(i + 1) == '"' && cellInQuotes) {
                            printWriter.print(symbol);
                            ++i;
                        } else {
                            cellInQuotes = !cellInQuotes;
                        }
                    } else if (symbol == ',') {
                        if (cellInQuotes) {
                            printWriter.print(",");
                        } else {
                            printWriter.print("</td><td>");
                        }
                    } else if (symbol == '<') {
                        printWriter.print("&lt;");
                    } else if (symbol == '>') {
                        printWriter.print("&gt;");
                    } else if (symbol == '&') {
                        printWriter.print("&amp;");
                    } else {
                        printWriter.print(symbol);
                    }

                }
                if (cellInQuotes) {
                    printWriter.print("<br/>");
                } else {
                    printWriter.print("</td></tr>");
                }
            }
            printWriter.println("</table>" + ls +
                    "</body>" + ls +
                    "</html>");
        } catch (FileNotFoundException notFound) {
            System.out.println("Не удалось найти файл");
        }
    }

    private static String getHelp() {
        return "use: --help для получения справки," + System.lineSeparator() +
                "--version для получения версии программы" + System.lineSeparator() +
                System.lineSeparator() +
                "Необходимо передать 1 аргументом путь к входному файлу и 2 путь к сохранению выходного файла";
    }

    private static String getVersion() {
        return "version 1.0";
    }
}