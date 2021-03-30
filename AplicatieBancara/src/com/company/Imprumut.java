package com.company;

public class Imprumut extends Servicii {

    private double sumaCeruta;
    private double dobanda;

    public Imprumut(String numePersoana, String dataCerere, double sumaCeruta, double dobanda) {
        super(numePersoana, dataCerere);
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
