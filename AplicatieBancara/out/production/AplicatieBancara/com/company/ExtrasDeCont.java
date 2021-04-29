package com.company;

import java.util.Arrays;

public class ExtrasDeCont {

    private String dataCerereExtras;
    private Tranzactii[] tranzactii;
    private int lastIndex;
    private int numarMaximTranzactii;

    public ExtrasDeCont() {
        this.lastIndex = 0;
        this.tranzactii = new Tranzactii[100];
        this.numarMaximTranzactii = 100;

    }

    public void adaugaTranzactie(Tranzactii tranzactie)    {
        if(lastIndex < tranzactii.length)  {
            tranzactii[lastIndex] = tranzactie;
            lastIndex++;
        }
    }

    public String getDataCerereExtras() {
        return dataCerereExtras;
    }

    public void setDataCerereExtras(String dataCerereExtras) {
        this.dataCerereExtras = dataCerereExtras;
    }

    public Tranzactii[] getTranzactii() {
        return tranzactii;
    }

    public void setTranzactii(Tranzactii[] tranzactii) {
        this.tranzactii = tranzactii;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
