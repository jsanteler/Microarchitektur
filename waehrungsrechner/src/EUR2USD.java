public class EUR2USD extends WR{

    private static final double WECHSELKURS_EUR_USD = 1.12;

    @Override
    public double getFaktor() {
        return WECHSELKURS_EUR_USD;
    }

    @Override
    public String getKennung() {
        return "EUR2USD";
    }

    @Override
    public boolean zustaendig(String variante) {
        return variante.equals("EUR2USD");
    }
}
