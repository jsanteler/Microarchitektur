# SOLID UND SONSTIGE DESIGNPRINZIPIEN

## Solid

S - Single Responsibility
Eine bestimmte Klasse sollte immer nur fürr eine Sache verantwortlich sein.

O - Open Principle
Code sollte erweiterbar sein aber geschlossen für Modifikationen

L - Liskov Substitution
eine Unterklasse hat eine Oberklasse und man soll Objekte der Unterklasse überall dort verwenden können, wo Objekte der Oberklasse erwartet werden ohne dass es zu unerwarteten Problemen kommt.

Beispiel Liskov:
Klasse Vogel und eine Methode fliegen().
Unterklasse Pinguin die von Vogel erbt. -> Liskov Substitution wurde verletzt da Pinguine nicht fliegen können.

I - Interface Segregation
Keine Klasse sollte gezwungen werden, SChnittstellen zu implementieren, die sie nicht verwendet.
Besser viele Spezifische Schnittstellen zu haben als eine einzige allgemeine.

D - Dependency Inversion
Hochrangige Module sollten nicht von niedriggrangigen Modulen abhängen, sondern beide sollten von Abstraktion abhängen.

Beispiel für Dependency: allgemeine Schnittstelle: Batterie-Interface. Mit verschiedenen Batterien (AA , AAA)
Bei der Verwendung der Taschenlampe ist sie nicht direkt abhängig von einem spezifischen Batterietyp. Dadurch wird die Taschenlampe flexibler und einfacher zu warten.

## DRY Prinzip:

"Dont Repeat Yourself"
Wiederholungen von Informationen oder Code zu vermeiden.

## YAGNI Prinzip:

"You arent gonna need it"
Nur Funktionen implementieren, die aktuell benötigt werden.
Ziel: Komplexität zu reduzieren indem unnötiger code vermieden wird.

## KISS Prinzip:

"Keep it short, Stupid"
Beton die Wichtigkeit und Einfachkeit in der Konzeption und Umsetzung.
Einfache Designs sind oft effizienter, leichter zu verstehen, zu warten und zu erweitern.
