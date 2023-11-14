package org.example.Adapter;


import org.example.Exception.InvalidVarianteException;
import org.example.Interfaces.ISammelumrechnung;
import org.example.Interfaces.IUmrechnen;



public class UmrechnungsAdapter implements ISammelumrechnung {

    private  final IUmrechnen umrechnenAktion;

    public UmrechnungsAdapter(IUmrechnen umrechnen) {
        this.umrechnenAktion = umrechnen;
    }

    @Override
    public double sammelumrechnen(double[] betraege, String variante) throws InvalidVarianteException {
        double summe = 0;
        for (double betrag:betraege) {
            summe = summe + umrechnenAktion.umrechnen(variante, betrag);
        }
        return summe;
    }
}
