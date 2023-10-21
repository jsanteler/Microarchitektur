# Microarchitektur

In diesem Schulthema bearbeiten wir als erstes zwei BLUEJ Kapitel durch.
Zuerst werde ich Kapitel 8 durcharbeiten. Hier geht es um Kassenentwurf. Das zweite Kapitel heißt "Entwurf von Kassen" (Kapitel 15).

## BLUEJ-Buch KLASSENENTWURF

### Übung 8.1:

Projekt Zuul-schlecht öffnen und diese ANwendung erkunden.

Es handelt sich um ein einfaches Spiel, wo wir uns vor dem Haupteingang der Universität befinden und wir verschiedene Ausgänge nutzen können: east south west.

Es stehen die Befehle: go, quit, help zur Verfügung, mit denen man in einen Raum wechseln kann, das Spiel beenden kann oder die Hilfe aufrufen kann und dort kurz die Situation geschliedert wird und die Befehle aufgelistet werden.

Es gibt folgende Räume:

        draussen = new Raum("vor dem Haupteingang der Universität");
        hoersaal = new Raum("in einem Vorlesungssaal");
        cafeteria = new Raum("in der Cafeteria der Uni");
        labor = new Raum("in einem Rechnerraum");
        buero = new Raum("im Verwaltungsbüro der Informatik");

### Übung 8.2:

Einsatzzweck der jeweiligen Klassen:

_Parser_

Dieser Parser liest, was Benutzer eingeben, versucht es als bis zu zwei Wörter lange Anweisungen für ein Adventure-Game zu interpretieren und gibt diese Anweisungen zurück.

_Raum_

Ein "Raum" im Spiel ist ein Ort, der durch Ausgänge in vier Himmelsrichtungen mit anderen Räumen verbunden ist.

_Befehlswörter_

Diese Klasse enthält alle Befehlswörter, die im Spiel erkannt werden sollen.

_Befehle_

Diese Klasse speichert Informationen über Benutzerbefehle, die aus zwei Wörtern bestehen: einem Befehlswort und einem zweiten Wort.

_Spiel_

Ist die Hauptklasse. Ein Spieler kann sich in der Umgebung bewegen. Um zu spielen, erstellt man eine Instanz dieser Klasse und ruft die Methode "spielen" auf. Diese Instanz initialisiert das Spiel und führt die Befehle aus.

### Übung 8.3.:

Eigenes Spiel:

Schatzsuche im Schloss

Spieler erkundet ein verlassenes Schloss wo ein Schatz sich befinden soll. Dort trifft er auf eine Katze die er füttern kann und ein Gespenst der ihn in die Irre führen wird.

### Übung 8.4:

Für das Projekt Zuul-Schlecht die Methode raeumeAnlegen auf unser eigene Spiel anpassen.

### Übung: 8.5:

Die Methode rauminfoAusgeben implementieren.

### Übung 8.6:

### Übung 8.7:

    public String gibAusgaengeAlsString(){

        String ergebnis = "Ausgänge ";
        if (aktuellerRaum.nordausgang != null){
            ergebnis += "north";
        }
        if (aktuellerRaum.suedausgang != null){
            ergebnis += "south";
        }
        if (aktuellerRaum.westausgang != null){
            ergebnis += "west";
        }
        if (aktuellerRaum.ostausgang != null){
            ergebnis += "east";
        }
        return ergebnis;
    }

### Übung 8.8:

Abschnitt aus BlueJ Buch Implementieren.

### Übung 8.9:

Was macht die Methode KeySet() von HashMap?

Gibt eine Menge aller Schlüssel in der HashMap zurück. Man kann auf die Schlüssel zugreifen, die in der HashMap gespeichert sind.

### 8.10:

    public String gibAusgaengeAlsString(){

        String ergebnis = "Ausgänge: ";
        Set<String> keys =  ausgaenge.keySet();

        for (String ausgang: keys) {
            ergebnis += " " + ausgang;
        }return ergebnis;
        }

ausgaenge ist eine Instanz der erstellten HashMap. Die Methode keySet() ruft von dieser Instanz alle Schlüssel auf und diese zurückgegebene Menge von Schlüsseln wird in der Variable keys gespeichert.

Mit der foreach Schleife durchlaufe ich alle Schlüssel in "keys", jeder Schlüssel wird dann den String "ergebnis" angehängt mit einen Leerzeichen.

### Übung 8.11:

Die Methode gibLangeBeschreibung() implementieren.

### Übung 8.12 & 8.13:

Objektdiagram

### Übnung 8.14:

Den Befehl look hinzufügen.

### Übung 8.15:

Den Befehl eat hinzufügen.

### Übung 8.15:

Verbesserte Ausgabe der Befehle implementieren.

### Übung 8.17:

Wenn ich einen weiteren Befehl hinzufüge muss ich immer noch die Methode "verarbeiteBefehl" anpassen bzw verändern.

### Übung 8.18:

gibBefehlliste();

### Übung 8.19:

MVC ist ein Designmuster, das Software in drei Teile unterteilt:

Model (Modell): Daten und Geschäftslogik.
View (Ansicht): Benutzeroberfläche und Anzeige.
Controller (Steuerung): Benutzerinteraktion und Kommunikation.

Es fördert die Trennung von Daten, Darstellung und Steuerung für eine bessere Struktur und Wartbarkeit von Software.

### Übung 8.20 , 8.21 & 8.22:

Hier war die Aufgabe Gegenstände jeden Raum hinzuzufügen.
Ich habe eine eigene Klasse für Gegenstände erzeugt. Mit den Datenfeldern name, beschreibung und gewicht.

In der Raum Klasse habe ich eine HashMap angelegt mit key ist ein String und value ist der Gegenstand.

    public void gegenstandAblegen (Gegenstand gegenstand){
        gegenstandMap.put(gegenstand.getName(), gegenstand);

    }

So füge ich einen Gegenstand einen Raum hinzu.
halle.gegenstandAblegen(schluessel);

    public String gibGegenstaendeAlsString(){

        String ergebnis = "Es befindet sich ein Gegenstand in diesem Raum: ";
        Set<String> keys =  gegenstandMap.keySet();

        for (String gegenstand: keys) {
            ergebnis += " " + gegenstand;
        }return ergebnis;
    }

Mir dieser Methode lasse ich mir die Keys (die Gegenstände) als String ausgeben.

8.23:
Den Befehl back implementieren.
