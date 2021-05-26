package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Servicii {

    private int id;
    private String numePersoana;
    private String dataCerere;

    public Servicii(int id, String numePersoana, String dataCerere) {
        this.id = id;
        this.numePersoana = numePersoana;
        this.dataCerere = dataCerere;
    }

    public String getNumePersoana() {
        return numePersoana;
    }

    public void setNumePersoana(String numePersoana) {
        this.numePersoana = numePersoana;
    }

    public String getDataCerere() {
        return dataCerere;
    }

    public void setDataCerere(String dataCerere) {
        this.dataCerere = dataCerere;
    }
}
