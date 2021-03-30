package com.company;

import java.util.Arrays;

public class ClasaServiciu {

//    private Tranzactii tranzactii;

    public ClasaServiciu() {
    }

    public Cont creeazaCont (String numeTitular, String iban, ExtrasDeCont extrasDeCont) {
        return new Cont(numeTitular, iban, extrasDeCont);
    }

    public void afiseazaExtrasulDeCont (Cont cont) {

        for (int i = 0; i < cont.getExtrasDeCont().getLastIndex(); i++) {
            System.out.println(cont.getExtrasDeCont().getTranzactii()[i]);
        }
        System.out.println();
    }

    public Carduri creeazaCard (String numarCard, String cvv, String dataExpirare, Cont cont) {

        Carduri cardNou = new Carduri(numarCard, cont.getNumeTitular(), cvv, dataExpirare, cont);
        System.out.println("Cardul a fost creat.\n");

        cont.setCard(cardNou);
        return cardNou;
    }

    public void afiseazaCard (Cont cont) {
        System.out.println(cont.getCard());
        System.out.println();
    }

    public ContEconomii creeazaContEconomii (String numeTitular, String iban, ExtrasDeCont extrasDeCont, String dataExpirare, double sumaMaximaAdmisa) {
        return new ContEconomii(numeTitular, iban, extrasDeCont, dataExpirare, sumaMaximaAdmisa);
    }

    public void imprumut (double suma, Cont cont) {

        cont.setTotalBaniCont(cont.getTotalBaniCont() + suma);
        System.out.println("Total de bani din contul dumneavoastră este de: " + cont.getTotalBaniCont());
    }

    public void comandaCard (String culoare) {

        System.out.println("Cardul dumneavoastră va avea culoarea " + culoare + " și va fi livrat cât de curând.");
    }
}
