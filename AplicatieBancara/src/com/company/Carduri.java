package com.company;

public class Carduri {

    private int id;
    private String numarCard;
    private String numeDetinator;
    private String CVV;
    private String dataExpirare;
    private int id_cont;

    public Carduri(int id, String numarCard, String numeDetinator, String CVV, String dataExpirare, int id_cont) {
        this.id = id;
        this.numarCard = numarCard;
        this.numeDetinator = numeDetinator;
        this.CVV = CVV;
        this.dataExpirare = dataExpirare;
        this.id_cont = id_cont;
    }

    public String getNumarCard() {
        return numarCard;
    }

    public void setNumarCard(String numarCard) {
        this.numarCard = numarCard;
    }

    public String getNumeDetinator() {
        return numeDetinator;
    }

    public void setNumeDetinator(String numeDetinator) {
        this.numeDetinator = numeDetinator;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public int getId_cont() {
        return id_cont;
    }

    public void setId_cont(int id_cont) {
        this.id_cont = id_cont;
    }

    public String toString() {
        return  "Număr card: " + numarCard +
                "\nCVV: " + CVV +
                "\nData expirare: " + dataExpirare;
    }
}
