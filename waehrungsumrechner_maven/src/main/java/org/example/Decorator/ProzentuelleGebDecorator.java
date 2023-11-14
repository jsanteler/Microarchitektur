package org.example.Decorator;


import org.example.Exception.InvalidVarianteException;
import org.example.WR.WR;

public class ProzentuelleGebDecorator extends WRDecorator{

    private final double prozentGebuehr;


    public ProzentuelleGebDecorator(WR decoratedWR, double prozentGebuehr) {
        super(decoratedWR);
        this.prozentGebuehr = prozentGebuehr;
    }

    @Override
    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        double result = super.umrechnen(variante, betrag);
        return result - (result * prozentGebuehr / 100.0);
    }
}
