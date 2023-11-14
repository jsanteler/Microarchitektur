package org.example;

import org.example.Adapter.UmrechnungsAdapter;
import org.example.ChainOfResponsability.EUR2USD;
import org.example.ChainOfResponsability.EUR2YEN;
import org.example.Decorator.FixeGebuehrDecorator;
import org.example.Decorator.ProzentuelleGebDecorator;
import org.example.Exception.InvalidVarianteException;
import org.example.Interfaces.IUmrechnen;
import org.example.Observer.AtomFeedObserver;
import org.example.Observer.LogObserver;
import org.example.WR.WR;

public class Main {
    public static void main(String[] args) {

        WR yen = new EUR2YEN();

        WR dollar = new EUR2USD.Builder().mitFaktor(1.2)
                .mitNaechsteKettenMitglied(yen).
                build();

        try {
            System.out.println(dollar.umrechnen("EURO2DOLLAR", 100));
            System.out.println(yen.umrechnen("EUR2YEN", 50));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        WR euro2dollarRechner = new EUR2USD.Builder()
                .mitFaktor(1.2)
                .mitNaechsteKettenMitglied(yen)
                .build();


        WR euro2dollarProzent = new ProzentuelleGebDecorator(euro2dollarRechner, 0.5);
        WR euro2dollarFixGeb = new FixeGebuehrDecorator(euro2dollarRechner);

        try {
            System.out.println("100€ in Dollar mit Prozentgebühren" + euro2dollarProzent.umrechnen("EURO2DOLLAR", 100));
            System.out.println("100€ in Dollar mit Fixegebühren" + euro2dollarFixGeb.umrechnen("EURO2DOLLAR", 100));
        } catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }

        //Adapter
        IUmrechnen euro2dollar = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();
        UmrechnungsAdapter umrechnungsAdapter = new UmrechnungsAdapter(euro2dollar);

        double[] betraege = {150.50, 120.30, 90.10};
        try {
            System.out.println(umrechnungsAdapter.sammelumrechnen(betraege, "EURO2DOLLAR"));
        }catch (InvalidVarianteException e){
            throw new RuntimeException(e);
        }

        IUmrechnen dollar2 = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();

        AtomFeedObserver afo = new AtomFeedObserver();
        LogObserver log = new LogObserver();


        if (dollar2 instanceof WR){
            ((WR)dollar2).addObserver(log);
            ((WR)dollar2).addObserver(afo);
        }

        try {
            dollar2.umrechnen("EURO2DOLLAR", 100);
        } catch (InvalidVarianteException e){
            e.printStackTrace();
        }
    }
}