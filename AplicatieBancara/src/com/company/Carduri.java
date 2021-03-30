package com.company;

public class Carduri {

    private String numarCard;
    private String numeDetinator;
    private String CVV;
    private String dataExpirare;
    private Cont cont;

    public Carduri(String numarCard, String numeDetinator, String CVV, String dataExpirare, Cont cont) {
        this.numarCard = numarCard;
        this.numeDetinator = numeDetinator;
        this.CVV = CVV;
        this.dataExpirare = dataExpirare;
        this.cont = cont;
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

    public Cont getNumeTitularCont() {
        return cont;
    }

    public void setNumeTitularCont(Cont numeTitularCont) {
        this.cont = numeTitularCont;
    }

    public String toString() {
        return  "Nume deținător card: " + cont.getNumeTitular() +
                "\nNumăr card: " + numarCard +
                "\nCVV: " + CVV +
                "\nData expirare: " + dataExpirare;
    }
}
