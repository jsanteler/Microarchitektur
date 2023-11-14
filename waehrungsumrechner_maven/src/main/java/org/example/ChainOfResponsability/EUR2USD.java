package org.example.ChainOfResponsability;


import org.example.WR.WR;

public class EUR2USD extends WR {

    private double faktor;

    private EUR2USD(double faktor) {
        this.faktor = faktor;
    }

    @Override
    public double getFaktor(){
        return faktor;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (variante.equals("EURO2DOLLAR")) {
            return true;
        } else {
            return false;
        }
    }

    public static class Builder{
        private double faktor;
        private WR next;

        public Builder mitFaktor(double faktor){
            this.faktor = faktor;
            return this;
        }

        public Builder mitNaechsteKettenMitglied(WR next){
            this.next = next;
            return this;
        }

        public EUR2USD build(){
            EUR2USD waehrungskonventierer = new EUR2USD(faktor);
            if (next != null){
                waehrungskonventierer.addChain(next);
            }
            return waehrungskonventierer;
        }}
}