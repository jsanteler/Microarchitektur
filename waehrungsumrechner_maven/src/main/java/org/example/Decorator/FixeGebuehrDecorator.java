package org.example.Decorator;


import org.example.Exception.InvalidVarianteException;
import org.example.WR.WR;

public class FixeGebuehrDecorator extends WRDecorator {

    private final double fixeGebuehr;

    public FixeGebuehrDecorator(WR decoratedWR) {
        super(decoratedWR);
        this.fixeGebuehr = 5;
    }

    @Override
    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        double result = super.umrechnen(variante, betrag);
        if (variante.startsWith("EURO2")){
            return result - fixeGebuehr;
        }
        return result;
    }
}