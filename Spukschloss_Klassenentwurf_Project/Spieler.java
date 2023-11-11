public class Spieler {

    private String name;

    private Raum aktuellerRaum;


    private int maxGewicht;

    public Spieler (String name){

        this.name = name;
    }
    public void betreteRaum(Raum raum){
        aktuellerRaum = raum;
    }

    public Raum getAktuellerRaum(){
        return aktuellerRaum;
    }

    public String getName(){
        return name;
    }



    private boolean kannGegenstandTragen(String name)
    {
        boolean kannTragen = true;
        Gegenstand gegenstand = aktuellerRaum.getGegenstand(name);
        if(gegenstand == null) {
            kannTragen = false;
        }
        else {
            int totalWeight = gegenstand.getGesamtgewicht() + gegenstand.getGegenstandGewicht();
            if(totalWeight > maxGewicht) {
                kannTragen = false;
            }
        }
        return kannTragen;
    }

}
