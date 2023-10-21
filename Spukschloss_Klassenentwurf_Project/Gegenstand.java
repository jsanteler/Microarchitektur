
public class Gegenstand {

    private String name;
    private String gegenstandBeschreibung;

    private int gegenstandGewicht;



    public Gegenstand(String name, String gegenstandBeschreibung, int gegenstandGewicht) {
        this.name = name;
        this.gegenstandBeschreibung = gegenstandBeschreibung;
        this.gegenstandGewicht = gegenstandGewicht;

    }



    public String getGegenstandBeschreibung() {
        return gegenstandBeschreibung;
    }

    public int getGegenstandGewicht() {
        return gegenstandGewicht;
    }

    public void setGegenstandBeschreibung(String gegenstandBeschreibung) {
        this.gegenstandBeschreibung = gegenstandBeschreibung;
    }

    public void setGegenstandGewicht(int gegenstandGewicht) {
        this.gegenstandGewicht = gegenstandGewicht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

