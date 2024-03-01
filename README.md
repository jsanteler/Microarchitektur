# Währungsrechner mit verschiedenen Entwurfsmustern

Die im Laufe der folgenden Aufgaben zu erstellende Software bildet einen einfachen Währungsrechner nach, der unter Anwendung verschiedener Entwurfsmuster implementiert werden muss. 
### CHAIN OF RESPONSIBILITY

Erstellen Sie eine Verantwortlichkeitskette mit mindestens zwei Währungsrechnern (z.B. EUR2YEN, EURO2Dollar). Neben dem Standardverhalten einer Zuständigkeitskette soll es möglich sein, neue Währungsrechner in die Kette aufzunehmen bzw. bestehende aus der Kette zu löschen (jeweils am Ende der Kette). Die Mutterklasse der Chain ist die abstrakte WR-Klasse. Diese implementiert die Ketten-Weiterleitung in der Methode umrechnen(). Die Zuständigkeit sowie der Umrechnungsfaktor für die Umrechnung wird in den Unterklassen geklärt (Template Method).

### TEMPLATE METHOD

Implementieren Sie die Template-Methode umrechnen() in der abstrakten Klasse WR. Delegieren Sie ausschließlich die für die jeweiligen Umrechner spezifischen Methoden (zustaendig(), faktor()) zur Implementierung an die konkreten Währungsrechner-Unterklassen von WR (Hook-Methoden der Unterklassen).

### DECORATOR

Implementieren Sie ein System von Decorators, das Währungsrechner des Typen IUmrechnen dekorieren kann. Folgende Decorators sind z.B. sinnvoll und möglich:

Belegung eines Umrechnungsvorganges mit Gebühren (z.B. 0,5 % des Umrechnungsbetrages)
Belegung eines Umrechnungsvorganges für Umrechnungen von Euro nach Währung X (nicht in die andere Richtung) mit fixen Gebühren von 5 Euro.
Hinweis: Leiten Sie dazu zunächst einen abstrakten Decorator von WR ab und implementieren Sie alle abstrakten Methoden sowie umrechnen() als transparente Weiterleitungen an den dekorierten Nächsten. Implementieren Sie dann in zwei weiteren Subklassen dieser abstraktoren Decorator-Klasse die umrechnen Methode neu, sodass die gewünschte Verhaltensänderung des Systems resultiert.

### BUILDER

Implementieren Sie das Builder-Pattern (https://dzone.com/articles/design-patterns-the-builder-pattern) für einen konkreten Währungsrechner nach Wahl. Der Builder soll es ermöglichen, den Umrechnungsfaktor eines Währungsrechners sowie das nächste Kettenglied in der Chain of Responsitility zu setzen.

### ADAPTER

Externe Anwendungen benötigen eine Implementierung der Schnittstelle ISammelumrechnung (siehe oben), um Sammelumrechnungen durchführen zu können. Stellen Sie einen Adapter bereit, der Sammelumrechnungen in der geforderten Form (siehe Methodensignatur) zur Verfügung stellt und dazu die Funktionalität eines IUmrechnen (kann dekoriert sein, kein ein konkreter Währungsrechner sein, kann eine Kette sein) verwendet.

### OBSERVER

An einem Währungsrechner sollen sich mehrere Observer registrieren können, die bei einer Umrechnung benachrichtig werden sollen. Jedes Mal, wenn eine Umrechnung stattfindet, sollen alle Observer benachrichtigt werden. Alle Informationen der Umrechnungen (Ausgangsbetrag, Ausgangswährung, Zielwährung, Zielbetrag) sollen mit der Benachrichtigung versendet werden. Beispielhaft sollen zwei Observer implementiert werden:

Atom-Feed-Observer: Erzeugt einen Atom-Feed mit allen Umrechnungsinformationen und Zeitstempel (verwende dazu: https://mvnrepository.com/artifact/rome/rome )
Log-Observer: Erzeugt eine Log-Text-Datei mit allen Umrechnungsinformationen und Zeitstempel.
