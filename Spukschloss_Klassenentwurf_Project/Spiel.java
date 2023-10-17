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
 *  der Anwendung: Sie legt alle R�ume und einen Parser an und
 *  startet das Spiel. Sie wertet auch die Befehle aus, die der
 *  Parser liefert, und sorgt f�r ihre Ausf�hrung.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2016.02.29
 */

public class Spiel 
{
    private Parser parser;
    private Raum aktuellerRaum;
        
    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel() 
    {
        raeumeAnlegen();
        parser = new Parser();
    }

    /**
     * Erzeuge alle R�ume und verbinde ihre Ausg�nge miteinander.
     */
    private void raeumeAnlegen()
    {
        Raum draussen, halle, keller, saal, kammer;
      
        // die R�ume erzeugen
        draussen = new Raum("vor dem Haupteingang des verlasssenen Schlosses");
        halle = new Raum("in der Eingangshalle des Schlosses");
        keller = new Raum("im Keller");
        saal = new Raum("im Speisesaal");
        kammer = new Raum("in der Folterkammer");
        
        // die Ausg�nge initialisieren
        draussen.setzeAusgaenge(null, halle, saal, keller);
        halle.setzeAusgaenge(null, null, null, draussen);
        keller.setzeAusgaenge(null, draussen, kammer, null);
        saal.setzeAusgaenge(draussen, halle, null, null);
        kammer.setzeAusgaenge(null, null, null, keller);

        aktuellerRaum = draussen;  // das Spiel startet draussen
    }

    /**
     * Die Hauptmethode zum Spielen. L�uft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen() 
    {            
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und f�hren sie aus, bis das Spiel beendet wird.
                
        boolean beendet = false;
        while (! beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        System.out.println("Danke f�r dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begr��ungstext f�r den Spieler ausgeben.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        System.out.println("Tippen Sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
        System.out.print("Ausg�nge: ");
        if(aktuellerRaum.nordausgang != null) {
            System.out.print("north ");
        }
        if(aktuellerRaum.ostausgang != null) {
            System.out.print("east ");
        }
        if(aktuellerRaum.suedausgang != null) {
            System.out.print("south ");
        }
        if(aktuellerRaum.westausgang != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private void rauminfoAusgeben(){

        System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
        System.out.println("Ausg�nge: ");

        if(aktuellerRaum.nordausgang != null){
            System.out.println("north");
        }
        if(aktuellerRaum.ostausgang != null) {
            System.out.println("east");
        }
        if(aktuellerRaum.westausgang != null) {
            System.out.println("west");
        }
        if(aktuellerRaum.suedausgang != null) {
            System.out.println("west");
        }
    }



    /**
     * Verarbeite einen gegebenen Befehl (f�hre ihn aus).
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
        else if (befehlswort.equals("quit")) {
            moechteBeenden = beenden(befehl);
        }
        
        return moechteBeenden;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * Gib Hilfsinformationen aus.
     * Hier geben wir eine etwas alberne und unklare Beschreibung
     * aus, sowie eine Liste der Befehlsw�rter.
     */
    private void hilfstextAusgeben() 
    {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigel�nde herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verf�gung:");
        System.out.println("   go quit help");
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
            System.out.println("Wohin m�chten Sie gehen?");
            return;
        }

        String richtung = befehl.gibZweitesWort();

        // Wir versuchen, den Raum zu verlassen.
        Raum naechsterRaum = null;
        if(richtung.equals("north")) {
            naechsterRaum = aktuellerRaum.nordausgang;
        }
        if(richtung.equals("east")) {
            naechsterRaum = aktuellerRaum.ostausgang;
        }
        if(richtung.equals("south")) {
            naechsterRaum = aktuellerRaum.suedausgang;
        }
        if(richtung.equals("west")) {
            naechsterRaum = aktuellerRaum.westausgang;
        }

        if (naechsterRaum == null) {
            System.out.println("Dort ist keine T�r!");
        }
        else {
            aktuellerRaum = naechsterRaum;
            System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
            System.out.print("Ausg�nge: ");
            if(aktuellerRaum.nordausgang != null) {
                System.out.print("north ");
            }
            if(aktuellerRaum.ostausgang != null) {
                System.out.print("east ");
            }
            if(aktuellerRaum.suedausgang != null) {
                System.out.print("south ");
            }
            if(aktuellerRaum.westausgang != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    /**
     * "quit" wurde eingegeben. �berpr�fe den Rest des Befehls,
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
