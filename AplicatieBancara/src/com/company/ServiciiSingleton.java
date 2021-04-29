package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ServiciiSingleton {
    private static ServiciiSingleton single_instance = null;

    public static ServiciiSingleton getInstance() {
        if(single_instance == null)
            single_instance = new ServiciiSingleton();

        return single_instance;
    }

    public static void createFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.createFile(path);
    }

    public static void writeFiles(String fileName, Servicii servicii) {
        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path);)  {
            writer.write(servicii.getDataCerere() + ", " + servicii.getNumePersoana());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAndPrintAllLines(String fileName)   {
        Path path = Paths.get(fileName);
        try {
            List<String> input = Files.readAllLines(path);
            //byte[] input = Files.readAllBytes(path);
            for(String line : input)    {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
