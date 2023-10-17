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
