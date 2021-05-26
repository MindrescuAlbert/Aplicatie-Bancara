package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class ClasaServiciu {

//    private Tranzactii tranzactii;

    public ClasaServiciu() {
    }

   // public Cont creeazaCont (String numeTitular, String iban, ExtrasDeCont extrasDeCont) {
   //     return new Cont(0, numeTitular, iban, extrasDeCont);
  //  }

    public ContEconomii creeazaContEconomii (int id, String numeTitular, String iban, double totalBaniCont, String dataExpirare, double sumaMaximaAdmisa) {
        return new ContEconomii(id, numeTitular, iban, totalBaniCont, dataExpirare, sumaMaximaAdmisa);
    }

    public void imprumut (double suma, Cont cont) {

        cont.setTotalBaniCont(cont.getTotalBaniCont() + suma);
        System.out.println("Total de bani din contul dumneavoastră este de: " + cont.getTotalBaniCont());
    }

    public void comandaCard (String culoare) {

        System.out.println("Cardul dumneavoastră va avea culoarea " + culoare + " și va fi livrat cât de curând.");
    }
}


