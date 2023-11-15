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
import org.example.Observer.Observer;
import org.example.WR.WR;

public class Main {
    public static void main(String[] args) {


        //Chain of Responsability

        WR eur2YEN = new EUR2YEN();
        WR euro2dollar = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(eur2YEN).build();

        try {
            System.out.println(euro2dollar.umrechnen("EUR2YEN", 10));
            System.out.println(euro2dollar.umrechnen("EURO2DOLLAR", 10));
        } catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }

        //Decorator

        WR euro2usdProzent = new ProzentuelleGebDecorator(euro2dollar, 0.10);
        WR euro2usdFix = new FixeGebuehrDecorator(euro2dollar);

        try {
            System.out.println(euro2usdProzent.umrechnen("EURO2DOLLAR", 10));
            // 10*1,2 = 12/0.10 * 100 = 0.012   12- 0.012 = 11.988
            System.out.println(euro2usdFix.umrechnen("EURO2DOLLAR",10));}
        catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }

        //Builder

        WR euro2dollar2 = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(eur2YEN).build();


        //Adapter
        IUmrechnen euro2dollar3 = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(eur2YEN).build();

        UmrechnungsAdapter umrechnungsAdapter = new UmrechnungsAdapter(euro2dollar3);
        double [] betrage = {10,20,30,90};

        try {
            System.out.println(umrechnungsAdapter.sammelumrechnen(betrage, "EURO2DOLLAR"));
        } catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }

        //Observer

        Observer atom = new AtomFeedObserver();
        Observer log = new LogObserver();


        if (euro2dollar3 instanceof WR){
            ((WR)euro2dollar3).addObserver(log);
            ((WR)euro2dollar3).addObserver(atom);
        }
        try {
            euro2dollar3.umrechnen("EURO2DOLLAR",20);
        } catch (InvalidVarianteException e) {
            throw new RuntimeException(e);
        }


//        WR yen = new EUR2YEN();
//
//        WR dollar = new EUR2USD.Builder().mitFaktor(1.2)
//                .mitNaechsteKettenMitglied(yen).
//                build();
//
//        try {
//            System.out.println(dollar.umrechnen("EURO2DOLLAR", 100));
//            System.out.println(yen.umrechnen("EUR2YEN", 50));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        WR euro2dollarRechner = new EUR2USD.Builder()
//                .mitFaktor(1.2)
//                .mitNaechsteKettenMitglied(yen)
//                .build();
//
//
//        WR euro2dollarProzent = new ProzentuelleGebDecorator(euro2dollarRechner, 0.5);
//        WR euro2dollarFixGeb = new FixeGebuehrDecorator(euro2dollarRechner);
//
//        try {
//            System.out.println("100€ in Dollar mit Prozentgebühren" + euro2dollarProzent.umrechnen("EURO2DOLLAR", 100));
//            System.out.println("100€ in Dollar mit Fixegebühren" + euro2dollarFixGeb.umrechnen("EURO2DOLLAR", 100));
//        } catch (InvalidVarianteException e) {
//            throw new RuntimeException(e);
//        }
//
//        //Adapter
//        IUmrechnen euro2dollar = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();
//        UmrechnungsAdapter umrechnungsAdapter = new UmrechnungsAdapter(euro2dollar);
//
//        double[] betraege = {150.50, 120.30, 90.10};
//        try {
//            System.out.println(umrechnungsAdapter.sammelumrechnen(betraege, "EURO2DOLLAR"));
//        }catch (InvalidVarianteException e){
//            throw new RuntimeException(e);
//        }
//
//        IUmrechnen dollar2 = new EUR2USD.Builder().mitFaktor(1.2).mitNaechsteKettenMitglied(yen).build();
//
//        AtomFeedObserver afo = new AtomFeedObserver();
//        LogObserver log = new LogObserver();
//
//
//        if (dollar2 instanceof WR){
//            ((WR)dollar2).addObserver(log);
//            ((WR)dollar2).addObserver(afo);
//        }
//
//        try {
//            dollar2.umrechnen("EURO2DOLLAR", 100);
//        } catch (InvalidVarianteException e){
//            e.printStackTrace();
//        }
//    }
    }
}