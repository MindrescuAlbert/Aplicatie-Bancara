package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Imprumut extends Servicii {

    private double sumaCeruta;
    private double dobanda;

    public Imprumut(int id, String numePersoana, String dataCerere, double sumaCeruta, double dobanda) {
        super(id, numePersoana, dataCerere);
        this.sumaCeruta = sumaCeruta;
        this.dobanda = dobanda;
    }

    public double getSumaCeruta() {
        return sumaCeruta;
    }

    public void setSumaCeruta(double sumaCeruta) {
        this.sumaCeruta = sumaCeruta;
    }

    public double getDobanda() {
        return dobanda;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }
}
