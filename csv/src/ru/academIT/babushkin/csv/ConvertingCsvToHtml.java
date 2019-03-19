//Добрый день!
//
//1. Пусть программа берет пути к файлам из аргументов программы +
//
//2. Плохо использовать \n, он не для всех платформ+
//
//3. Надо обработать >, <, &
//
//4. problem - неинформативное имя

package ru.academIT.babushkin.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConvertingCsvToHtml {
    public static void main(String[] args) {
        if (args.length == 1) {
            if (args[0].equals("--help")) {
                System.out.println(getHelp());
            }
            if (args[0].equals("--version")) {
                System.out.println(getVersion());
            }
            return;
        }
        if (args.length == 2) {
            try (Scanner scanner = new Scanner(new FileReader(args[0]));
                 PrintWriter printWriter = new PrintWriter(args[1])) {
                String ls = System.lineSeparator();
                printWriter.print("<!DOCTYPE html>\n" +
                        "<html>" + ls +
                        "<head>" + ls +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">" + ls +
                        "<title>example</title>" + ls +
                        "</head>" + ls +
                        "<body>" + ls +
                        "<h1>Таблица</h1>" + ls +
                        "<table border=\"1\">");

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
                printWriter.println("</table>" + ls +
                        "</body>" + ls +
                        "</html>");
            } catch (FileNotFoundException notFound) {
                System.out.println("Не удалось найти файл");
                System.out.println(getHelp());
            }
        } else {
            System.out.println("Передано неверное количество аргументов");
            System.out.println(getHelp());
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