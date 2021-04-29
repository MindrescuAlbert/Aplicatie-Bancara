package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ImprumutSingleton {

    private static ImprumutSingleton single_instance = null;

    public static ImprumutSingleton getInstance() {
        if(single_instance == null)
            single_instance = new ImprumutSingleton();

        return single_instance;
    }

    public static void createFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.createFile(path);
    }

    public static void writeFiles(String fileName, Imprumut imprumut) {
        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path);)  {
            writer.write( imprumut.getSumaCeruta() + ", " + imprumut.getDobanda());

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
