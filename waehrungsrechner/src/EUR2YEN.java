public class EUR2YEN extends WR {

    private static final double WECHSELKURS_EUR_YEN = 130.50;
    @Override
    public double getFaktor() {
        return WECHSELKURS_EUR_YEN;
    }

    @Override
    public String getKennung() {
        return "EUR2YEN";
    }

    @Override
    public boolean zustaendig(String variante) {
        return variante.equals("EUR2YEN");
    }
}
