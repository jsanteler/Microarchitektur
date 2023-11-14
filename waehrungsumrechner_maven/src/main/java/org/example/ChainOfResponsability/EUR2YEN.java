package org.example.ChainOfResponsability;

import org.example.WR.WR;

public class EUR2YEN extends WR {
    @Override
    public double getFaktor() {
        return 1.2;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (variante.equals("EUR2YEN")) {
            return true;
        } else {
            return false;
        }
    }

}
