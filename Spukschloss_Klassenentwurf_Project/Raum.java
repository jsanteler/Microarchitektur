import java.util.HashMap;
import java.util.Set;

/**
 * Diese Klasse modelliert R�ume in der Welt von Zuul.
 * 
 * Diese Klasse ist Teil der Anwendung "Die Welt von Zuul".
 * "Die Welt von Zuul" ist ein sehr einfaches textbasiertes 
 * Adventure-Game.
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * M�gliche Ausg�nge liegen im Norden, Osten, S�den und Westen.
 * F�r jede Richtung h�lt ein Raum eine Referenz auf den 
 * benachbarten Raum.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2016.02.29
 */
public class Raum 
{
  private String beschreibung;
  private HashMap<String, Raum> ausgaenge;

  private HashMap <String, Gegenstand> gegenstandMap;
    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausg�nge. Eine Beschreibung hat die Form 
     * "in einer K�che" oder "auf einem Sportplatz".
     * @param beschreibung  die Beschreibung des Raums
     */
    public Raum(String beschreibung) 
    {
        this.beschreibung = beschreibung;
        ausgaenge = new HashMap<>();
        gegenstandMap = new HashMap<>();

    }


    /**
     * Definiere einen Ausgang aus deinem Raum
     * @param richtung die Richtung, in der der Ausgang liefern soll.
     * @param nachbar der Raum, der �ber diesen Ausgang erreicht wird.
     */

    public void setzeAusgang(String richtung, Raum nachbar){

        ausgaenge.put(richtung,nachbar);
    }

    public String gibAusgaengeAlsString(){

        String ergebnis = "Ausg�nge: ";
        Set<String> keys =  ausgaenge.keySet();

        for (String ausgang: keys) {
            ergebnis += " " + ausgang;
        }return ergebnis;
    }

    public String gibGegenstaendeAlsString(){

        String ergebnis = "Es befindet sich ein Gegenstand in diesem Raum: ";
        Set<String> keys =  gegenstandMap.keySet();

        for (String gegenstand: keys) {
            ergebnis += " " + gegenstand;
        }return ergebnis;
    }
    /**
     * @return  die Beschreibung dieses Raums
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }



    public Raum gibAusgang(String richtung){

        return ausgaenge.get(richtung);
    }

    public String gibLangeBeschreibung(){

        return "Sie sind " + beschreibung + ".\n" +gibAusgaengeAlsString() + ".\n" + gibGegenstaendeAlsString() ;

    }

    public void gegenstandAblegen (Gegenstand gegenstand){
        gegenstandMap.put(gegenstand.getName(), gegenstand);

    }

}



