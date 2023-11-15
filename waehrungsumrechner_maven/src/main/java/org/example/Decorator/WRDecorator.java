package org.example.Decorator;


import org.example.Exception.InvalidVarianteException;
import org.example.WR.WR;

public abstract class WRDecorator extends WR {

    protected WR decoratedWR;

    public WRDecorator(WR decoratedWR) {

        this.decoratedWR = decoratedWR;
    }

    @Override
    public double umrechnen(String variante, double betrag) throws InvalidVarianteException {
        return decoratedWR.umrechnen(variante, betrag);
    }

    @Override
    public double getFaktor() {
        return decoratedWR.getFaktor();
    }

    @Override
    public boolean zustaendig(String variante) {
        return decoratedWR.zustaendig(variante);
    }


}