package com.company;

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

}
