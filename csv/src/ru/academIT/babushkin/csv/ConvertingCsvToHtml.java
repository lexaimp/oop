package ru.academIT.babushkin.csv;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ConvertingCsvToHtml {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("csv/src/ru/academIT/babushkin/csv/example.csv")); FileWriter fileWriter = new FileWriter("csv/src/ru/academIT/babushkin/csv/example.html")) {
            fileWriter.append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<head>\n")
                    .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n")
                    .append("<title>example</title>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>Таблица</h1>\n")
                    .append("<table border=\"1\">\n")
                    .append("<tr>");

            while (scanner.hasNext()) {
                String[] strings = scanner.nextLine().split(",");
                for (int i = 0; i < strings.length; i++) {
                    fileWriter.append("<td>")
                            .append(strings[i])
                            .append("</td>");
                }
            }

            fileWriter.append("</tr>")
                    .append("\n</table>\n")
                    .append(("</body>\n"))
                    .append("</html>");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
/*
<tr><th>текст заголовка</th><th>текст заголовка</th></tr> <!--ряд с ячейками заголовков-->
<tr><td>данные</td><td>данные</td></tr> <!--ряд с ячейками тела таблицы-->
</table>*/