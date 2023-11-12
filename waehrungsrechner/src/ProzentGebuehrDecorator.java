public class ProzentGebuehrDecorator extends WRDecorator{

    private double gebuehrenProzentsatz;
    public ProzentGebuehrDecorator(WR umschlossenerRechner, double gebuehrenProzentsatz) {
        super(umschlossenerRechner);
        this.gebuehrenProzentsatz = gebuehrenProzentsatz;
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        double basisBetrag = super.umrechnen(variante, betrag);
        return basisBetrag * (1 + gebuehrenProzentsatz / 100);
    }
}
