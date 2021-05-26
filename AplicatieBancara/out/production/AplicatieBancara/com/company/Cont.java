package com.company;

public class Cont {

    private int id;
    private String numeTitular;
    private String IBAN;
    private double totalBaniCont;

    public Cont(int id, String numeTitular, String IBAN, double totalBaniCont) {
        this.id = id;
        this.numeTitular = numeTitular;
        this.IBAN = IBAN;
        this.totalBaniCont = totalBaniCont;


    }

    public double calculeazaDobanda(int numarAni) {
        System.out.println("Într-un cont normal veți primi o dobândă de " + (double)(0.02*totalBaniCont)*numarAni + " lei în " + numarAni + " ani");
        return (0.02 * totalBaniCont) * numarAni;
    }

    public void retrageBani (double sumaRetrasa, String dataTranzactie) {
        System.out.println("A fost retrasă suma de: " + sumaRetrasa + " lei, la data de " + dataTranzactie + ".");
        totalBaniCont = totalBaniCont - sumaRetrasa;

        Tranzactii tranzactie = new Tranzactii(1, "Retragere", dataTranzactie, sumaRetrasa);

        System.out.println("În cont au rămas " + totalBaniCont + " lei.\n");
    }

    public void depuneBani (double sumaDepusa, String dataTranzactie) {
        System.out.println("A fost depusă suma de: " + sumaDepusa + " lei, la data de " + dataTranzactie + ".");
        totalBaniCont = totalBaniCont + sumaDepusa;

        Tranzactii tranzactie = new Tranzactii(2,"Depunere", dataTranzactie, sumaDepusa);

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

}
