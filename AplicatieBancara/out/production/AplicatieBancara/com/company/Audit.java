package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    FileWriter writer;

    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logAction(String action) throws IOException {
        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }


    public Audit() {
        try{
            createFile("My_Folder/operatiiEfectuate.txt");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public static void createFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.createFile(path);
    }

    public static void writeFiles(String fileName, String operatie) {
        Path path = Paths.get(fileName);
        try(BufferedWriter writer = Files.newBufferedWriter(path);)  {
            writer.write(operatie + " ");
            writer.write(formatter.format(LocalDateTime.now()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
