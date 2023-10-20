import java.util.Set;

/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul".
 *  "Die Welt von Zuul" ist ein sehr einfaches, textbasiertes
 *  Adventure-Game. Ein Spieler kann sich in einer Umgebung bewegen,
 *  mehr nicht. Das Spiel sollte auf jeden Fall ausgebaut werden,
 *  damit es interessanter wird!
 * 
 *  Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und
 *  an ihr die Methode "spielen" aufgerufen werden.
 * 
 *  Diese Instanz erzeugt und initialisiert alle anderen Objekte
 *  der Anwendung: Sie legt alle Räume und einen Parser an und
 *  startet das Spiel. Sie wertet auch die Befehle aus, die der
 *  Parser liefert, und sorgt für ihre Ausführung.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 2016.02.29
 */

public class Spiel
{
    private Parser parser;
    private Raum aktuellerRaum;

    private Gegenstand gegenstand;

    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel()
    {
        raeumeAnlegen();
        parser = new Parser();

    }

    /**
     * Erzeuge alle Räume und verbinde ihre Ausgänge miteinander.
     */
    private void raeumeAnlegen()
    {
        Raum draussen, halle, keller, saal, kammer;

        // die Räume erzeugen
        draussen = new Raum("vor dem Haupteingang des verlasssenen Schlosses");
        halle = new Raum("in der Eingangshalle des Schlosses");
        keller = new Raum("im Keller");
        saal = new Raum("im Speisesaal");
        kammer = new Raum("in der Folterkammer");

        // die Ausgänge initialisieren
        draussen.setzeAusgang("north", halle);
        halle.setzeAusgang("west", saal);
        halle.setzeAusgang("east", keller);
        halle.setzeAusgang("south", draussen);
        saal.setzeAusgang("east", halle);
        keller.setzeAusgang("north", kammer);
        keller.setzeAusgang("west", halle);
        kammer.setzeAusgang("south", keller);

        aktuellerRaum = draussen;  // das Spiel startet draussen


    }

    private void gegenstandAnlegen(){

        Gegenstand schluessel, taschenlampe, apfel, medizin, knochen;

        schluessel = new Gegenstand("", 3);
        taschenlampe = new Gegenstand("Damit findet man sich besser zurecht", 6);
        apfel = new Gegenstand("Gegen den Hunger", 4);
        medizin = new Gegenstand("Für schwere Zeiten", 4);

        

    }

    /**
     * Die Hauptmethode zum Spielen. Läuft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen()
    {
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und führen sie aus, bis das Spiel beendet wird.

        boolean beendet = false;
        while (! beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begrüßungstext für den Spieler ausgeben.
     */
    private void willkommenstextAusgeben() {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        System.out.println("Tippen Sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
        System.out.println(aktuellerRaum.gibAusgaengeAlsString());

    }




    /**
     * Verarbeite einen gegebenen Befehl (führe ihn aus).
     * @param befehl   der zu verarbeitende Befehl.
     * @return true    wenn der Befehl das Spiel beendet, false sonst
     */
    private boolean verarbeiteBefehl(Befehl befehl)
    {
        boolean moechteBeenden = false;

        if(befehl.istUnbekannt()) {
            System.out.println("Ich weiss nicht, was Sie meinen ...");
            return false;
        }
        String befehlswort = befehl.gibBefehlswort();
        if (befehlswort.equals("help")) {
            hilfstextAusgeben();
        }
        else if (befehlswort.equals("go")) {
            wechsleRaum(befehl);
        }
        else if (befehlswort.equals("look")){
            umsehen();
        } else if (befehlswort.equals("eat")) {
            essen();
        } else if (befehlswort.equals("quit")) {
            moechteBeenden = beenden(befehl);
        }

        return moechteBeenden;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * Gib Hilfsinformationen aus.
     * Hier geben wir eine etwas alberne und unklare Beschreibung
     * aus, sowie eine Liste der Befehlswörter.
     */
    private void hilfstextAusgeben()
    {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigelände herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verfügung:");
        parser.zeigeBefehle();
    }

    /**
     * Versuche, in eine Richtung zu gehen. Wenn es einen Ausgang gibt,
     * wechsele in den neuen Raum, ansonsten gib eine Fehlermeldung
     * aus.
     */
    private void wechsleRaum(Befehl befehl)
    {
        if(!befehl.hatZweitesWort()) {
            // Gibt es kein zweites Wort, wissen wir nicht, wohin...
            System.out.println("Wohin möchten Sie gehen?");
            return;
        }

        String richtung = befehl.gibZweitesWort();

        // Wir versuchen, den Raum zu verlassen.


        Raum naechsterRaum = aktuellerRaum.gibAusgang(richtung);


        /*
        if(richtung.equals("north")) {
            naechsterRaum = aktuellerRaum.gibAusgang("north");
        }
        if(richtung.equals("east")) {
            naechsterRaum = aktuellerRaum.gibAusgang("east");
        }
        if(richtung.equals("south")) {
            naechsterRaum = aktuellerRaum.gibAusgang("south");
        }
        if(richtung.equals("west")) {
            naechsterRaum = aktuellerRaum.gibAusgang("west");
        }
*/
        if (naechsterRaum == null) {
            System.out.println("Dort ist keine Tür!");
        }
        else {
            aktuellerRaum = naechsterRaum;
            System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
            System.out.print(aktuellerRaum.gibAusgaengeAlsString());
        }
    }

    private void umsehen(){
        System.out.println(aktuellerRaum.gibLangeBeschreibung());
    }

    private void essen(){
        System.out.println("Sie haben nun gegessen und sind nicht mehr hungrig.");
    }

    /**
     * "quit" wurde eingegeben. Überprüfe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll.
     * @return true  wenn der Befehl das Spiel beendet, false sonst
     */
    private boolean beenden(Befehl befehl)
    {
        if(befehl.hatZweitesWort()) {
            System.out.println("Was soll beendet werden?");
            return false;
        }
        else {
            return true;  // Das Spiel soll beendet werden.
        }
    }
}
