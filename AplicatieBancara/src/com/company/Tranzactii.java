package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tranzactii {

    private String tipTranzactie;
    private String dataTranzactie;
    private double suma;

    public Tranzactii(String tipTranzactie, String dataTranzactie, double suma) {
        this.tipTranzactie = tipTranzactie;
        this.dataTranzactie = dataTranzactie;
        this.suma = suma;
    }

    public String toString()    {
        if(tipTranzactie == "Retragere")
            return "Tip Tranzacție: " + tipTranzactie +
                    ", Dată tranzacție: " + dataTranzactie +
                    ", Suma retrasă: " + suma;
        else
            return "Tip Tranzacție: " + tipTranzactie +
                    ", Dată tranzacție: " + dataTranzactie +
                    ", Suma depusă: " + suma;
    }

    public String getTipTranzactie() {
        return tipTranzactie;
    }

    public String getDataTranzactie() {
        return dataTranzactie;
    }

    public double getSuma() {
        return suma;
    }
}
