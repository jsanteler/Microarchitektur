public class FixeGebuehrEuroDecorator extends WRDecorator{
    private static final double FIXE_GEBUEHR = 5.0;

    public FixeGebuehrEuroDecorator(WR umschlossenerRechner) {
        super(umschlossenerRechner);
    }

    @Override
    public double umrechnen(String variante, double betrag) {
        double basisBetrag = super.umrechnen(variante, betrag);
        if (variante.startsWith("EUR")) { // Annahme, dass die Variante mit "EUR" beginnt
            return basisBetrag + FIXE_GEBUEHR;
        }
        return basisBetrag;
    }
}
