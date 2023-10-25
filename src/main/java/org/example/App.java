package org.example;

import org.apache.commons.io.FileUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        File inputFile = new File("src/main/java/datos.txt");
        File outputFile = new File("src/main/java/pakeistosDatos.txt");

        try {
            List<String> lines = FileUtils.readLines(inputFile);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String line : lines) {
                    String result = line.replaceAll("^(?i)data ", "");
                    writer.write(result);
                    writer.newLine();
                    System.out.println(result);
                }
                System.out.println("---------------------------------------------------");
                System.out.println("Duomenys irasyti i " + outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}