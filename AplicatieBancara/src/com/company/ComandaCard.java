package com.company;

public class ComandaCard extends Servicii {

    private String culoareCard;
    private Carduri numarCard;

    public ComandaCard(int id, String numePersoana, String dataCerere, String dataLivrare, String culoareCard, Carduri numarCard) {
        super(id, numePersoana, dataCerere);
        this.culoareCard = culoareCard;
        this.numarCard = numarCard;
    }

    public String getCuloareCard() {
        return culoareCard;
    }

    public void setCuloareCard(String culoareCard) {
        this.culoareCard = culoareCard;
    }

    public Carduri getNumarCard() {
        return numarCard;
    }

    public void setNumarCard(Carduri numarCard) {
        this.numarCard = numarCard;
    }
}
