package org.example.Interfaces;

import org.example.Exception.InvalidVarianteException;

public interface IUmrechnen {

    double umrechnen(String variante, double betrag) throws InvalidVarianteException;

    double getFaktor();

    boolean zustaendig(String variante);

}
