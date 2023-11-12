public class WRDecorator extends WR{

    protected WR umschlossenerRechner;

    public WRDecorator(WR umschlossenerRechner){
        this.umschlossenerRechner = umschlossenerRechner;
    }

    @Override
    public String getKennung() {
        return umschlossenerRechner.getKennung();
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        return umschlossenerRechner.umrechnen(variante, betrag);
    }

    @Override
    public boolean zustaendig(String variante) {
        return umschlossenerRechner.zustaendig(variante);
    }

    @Override
    public double getFaktor() {
        return umschlossenerRechner.getFaktor();
    }
}
