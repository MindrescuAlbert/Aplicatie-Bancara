package com.company;

public class Cont {

    private String numeTitular;
    private double totalBaniCont;
    private String IBAN;
    private ExtrasDeCont extrasDeCont;
    private Carduri card;

    public Cont(String numeTitular, String IBAN, ExtrasDeCont extrasDeCont) {
        this.numeTitular = numeTitular;
        this.totalBaniCont = 0;
        this.IBAN = IBAN;
        this.extrasDeCont = extrasDeCont;

    }

    public double calculeazaDobanda(int numarAni) {
        System.out.println("Într-un cont normal veți primi o dobândă de " + (double)(0.02*totalBaniCont)*numarAni + " lei în " + numarAni + " ani");
        return (0.02 * totalBaniCont) * numarAni;
    }

    public void retrageBani (double sumaRetrasa, String dataTranzactie) {
        System.out.println("A fost retrasă suma de: " + sumaRetrasa + " lei, la data de " + dataTranzactie + ".");
        totalBaniCont = totalBaniCont - sumaRetrasa;

        Tranzactii tranzactie = new Tranzactii("Retragere", dataTranzactie, sumaRetrasa);
        extrasDeCont.adaugaTranzactie(tranzactie);

        System.out.println("În cont au rămas " + totalBaniCont + " lei.\n");
    }

    public void depuneBani (double sumaDepusa, String dataTranzactie) {
        System.out.println("A fost depusă suma de: " + sumaDepusa + " lei, la data de " + dataTranzactie + ".");
        totalBaniCont = totalBaniCont + sumaDepusa;

        Tranzactii tranzactie = new Tranzactii("Depunere", dataTranzactie, sumaDepusa);
        extrasDeCont.adaugaTranzactie(tranzactie);

        System.out.println("Acum sunt în cont " + totalBaniCont + " lei.\n");
    }

    public String getNumeTitular() {
        return numeTitular;
    }

    public void setNumeTitular(String numeTitular) {
        this.numeTitular = numeTitular;
    }

    public double getTotalBaniCont() {
        return totalBaniCont;
    }

    public void setTotalBaniCont(double totalBaniCont) {
        this.totalBaniCont = totalBaniCont;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public ExtrasDeCont getExtrasDeCont() {
        return extrasDeCont;
    }

    public void setExtrasDeCont(ExtrasDeCont extrasDeCont) {
        this.extrasDeCont = extrasDeCont;
    }

    public Carduri getCard() {
        return card;
    }

    public void setCard(Carduri card) {
        this.card = card;
    }
}
