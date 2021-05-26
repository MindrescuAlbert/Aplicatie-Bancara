package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContEconomii extends Cont {

    private String dataUtilizare;
    private double sumaMaximaAdmisa;
    private double totalBaniCont;

    public ContEconomii(int id, String numeTitular, String IBAN, double totalBaniCont, String dataUtilizare, double sumaMaximaAdmisa) {
        super(id, numeTitular, IBAN, totalBaniCont);
        this.dataUtilizare = dataUtilizare;
        this.sumaMaximaAdmisa = sumaMaximaAdmisa;
        totalBaniCont = 0;
    }

    @Override
    public double calculeazaDobanda(int numarAni) {
        System.out.println("Într-un cont de economii veți primi o dobândă de " + super.calculeazaDobanda(numarAni)*3 + " lei în " + numarAni + " ani");
        return super.calculeazaDobanda(numarAni) * 3;
    }

    @Override
    public void retrageBani (double sumaRetrasa, String dataTranzactie) {
        System.out.println("A fost retrasă suma de: " + sumaRetrasa + " lei, la data de " + dataTranzactie + ".");
        totalBaniCont = totalBaniCont - sumaRetrasa;

        System.out.println("În cont au rămas " + totalBaniCont + " lei.\n");
    }

    @Override
    public void depuneBani (double sumaDepusa, String dataTranzactie) {
        System.out.println("A fost depusă suma de: " + sumaDepusa + " lei, la data de " + dataTranzactie + ".");
        totalBaniCont = totalBaniCont + sumaDepusa;

        System.out.println("Acum sunt în cont " + totalBaniCont + " lei.\n");
    }

    public String getDataUtilizare() {
        return dataUtilizare;
    }

    public void setDataUtilizare(String dataUtilizare) {
        this.dataUtilizare = dataUtilizare;
    }

    public double getSumaMaximaAdmisa() {
        return sumaMaximaAdmisa;
    }

    public void setSumaMaximaAdmisa(double sumaMaximaAdmisa) {
        this.sumaMaximaAdmisa = sumaMaximaAdmisa;
    }

    @Override
    public double getTotalBaniCont() {
        return totalBaniCont;
    }
}
