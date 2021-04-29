package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContEconomiiSingleton {

    private static ContEconomiiSingleton single_instance = null;

    public static ContEconomiiSingleton getInstance() {
        if(single_instance == null)
            single_instance = new ContEconomiiSingleton();

        return single_instance;
    }

    public static void createFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.createFile(path);
    }

    public static void writeFiles(String fileName, ContEconomii contEconomii) {
        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path);)  {
            writer.write(contEconomii.getDataUtilizare() + ", " + contEconomii.getTotalBaniCont() + ", " + contEconomii.getSumaMaximaAdmisa());

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
