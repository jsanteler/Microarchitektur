package org.example.Interfaces;

import org.example.Exception.InvalidVarianteException;

public interface ISammelumrechnung {

    public double sammelumrechnen (double[] betraege, String variante) throws InvalidVarianteException;


}
