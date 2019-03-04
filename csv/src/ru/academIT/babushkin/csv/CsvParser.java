package ru.academIT.babushkin.csv;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvParser {
    private String delimiter = ",";
    private String doubleQuote = "\"\"";
    private String newString = ""; // не понятно как выглядит
    private String emptyLine = "";
    private FileWriter fileWriter;
    private FileReader fileReader;

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public CsvParser() {

    }

    public FileWriter CsvToHtml(FileReader fileReader) throws IOException {
        Scanner scanner = new Scanner(fileReader);
        FileWriter fileWriter = null;
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

        return fileWriter;
    }
}
