public class SammelumrechnungAdapter implements  ISammelumrechnung{
    private IUmrechnen umrechner;

    public SammelumrechnungAdapter(IUmrechnen umrechner) {
        this.umrechner = umrechner;
    }

    @Override
    public double sammelumrechnen(double[] betraege, String variante) {
        double gesamtsumme = 0;
        for (double betrag : betraege) {
            gesamtsumme += umrechner.umrechnen(variante, betrag);
        }
        return gesamtsumme;
    }
}
