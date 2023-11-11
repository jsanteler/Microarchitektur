public abstract class WR implements IUmrechnen {

    protected WR naechster;

    public abstract String getKennung();

    public void setNaechster(WR naechster) {
        this.naechster = naechster;
    }

    //Template-Methode
    @Override
    public double umrechnen(String variante, double betrag) {
        if(zustaendig(variante))
        {
            double ergebnis = getFaktor() * betrag;
            return ergebnis;

        } else if (this.naechster != null) {
            return this.naechster.umrechnen(variante,betrag);
        }
        throw new IllegalArgumentException("Kein passender Währungsrechner gefunden");
    }


    //Abstrakte Methode (Hook-Methoden) für die Unterklassen

    public abstract boolean zustaendig(String variante);

    public abstract double getFaktor();



    public void rechnerHinzufuegen(WR newRechner) {
        WR aktuell = this;
        while (aktuell.naechster != null) {
            aktuell = aktuell.naechster;
        }
        aktuell.setNaechster(newRechner);
    }

    public void rechnerEntfernen(String kennung) {
        WR aktuell = this;
        WR vorheriger = null;

        while (aktuell != null) {
            if (aktuell.getKennung().equals(kennung)) {
                if (vorheriger != null) {
                    vorheriger.setNaechster(aktuell.naechster);
                }
                break;
            }
            vorheriger = aktuell;
            aktuell = aktuell.naechster;
        }
    }







}
