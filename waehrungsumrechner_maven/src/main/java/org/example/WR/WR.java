package org.example.WR;

import org.example.Exception.InvalidVarianteException;
import org.example.Interfaces.IUmrechnen;
import org.example.Observer.Observer;
import org.example.Observer.Subject;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public abstract class WR implements IUmrechnen, Subject {

    private WR next;

    //Observer in Liste aufnehmen und werden benachrihtigt und schreiben in Logobserver rein
    private List<Observer> observers = new ArrayList<>();

    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        if (this.zustaendig(variante))
        {
            double ergebnis = betrag * getFaktor();
            String message = createMessage(betrag, variante, ergebnis);
            messageObserver(message);
            return ergebnis;
        }
        else if (next != null)
        {
            return next.umrechnen(variante, betrag);
        }
        throw new InvalidVarianteException();
    }



    public void addChain(WR next) {
        if (next == this){
            throw new IllegalArgumentException("Das selbe Kettenmitglied kann nicht mehrmals an die Kette hinzugefügt werden");

        }
        if (this.next == null)
        {
            this.next = next;
        }
        else
        {
            this.next.addChain(next);
            //Abklären
        }
    }

    //Nur am vorletzten

    public void removenext(){
        if (this.next == null){
            System.out.println("Kein Element vorhanden");
        }else{
            this.next = null;
        }
    }


    @Override
    public abstract double getFaktor();

    @Override
    public abstract boolean zustaendig(String variante);

    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    @Override
    public void messageObserver(String message){
        for (Observer observer:observers) {
            observer.update(message);
        }
    }

    private String createMessage(double originalMenge, String waehrung, double umrechnungswaehrung){
        String zeitstempel = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return String.format("Umrechnung wurde durchgeführt: %s %.2f € %s zu %.2f $  ",zeitstempel, originalMenge, waehrung, umrechnungswaehrung);
    }

}