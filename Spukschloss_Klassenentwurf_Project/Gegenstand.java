public class Gegenstand {


    private String gegenstandBeschreibung;

    private int gegenstandGewicht;

    public Gegenstand(String gegenstandBeschreibung, int gegenstandGewicht) {
        this.gegenstandBeschreibung = gegenstandBeschreibung;
        this.gegenstandGewicht = gegenstandGewicht;
    }

    public String getGegenstandBeschreibung() {
        return gegenstandBeschreibung;
    }

    public int getGegenstandGewicht() {
        return gegenstandGewicht;
    }
}

