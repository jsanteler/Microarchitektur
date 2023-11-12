public class EUR2USD extends WR{

    private double wechselkurs;
    private static final double WECHSELKURS_EUR_USD = 1.12;


    private EUR2USD(double wechselkurs, WR naechster) {
        this.wechselkurs = wechselkurs;
        this.naechster = naechster;
    }

    @Override
    public double getFaktor() {
        return this.wechselkurs;
    }

    @Override
    public String getKennung() {
        return "EUR2USD";
    }

    @Override
    public boolean zustaendig(String variante) {
        return variante.equals("EUR2USD");
    }

    public static class Builder {
        private double wechselkurs;
        private WR naechster;

        public Builder wechselkurs(double wechselkurs) {
            this.wechselkurs = wechselkurs;
            return this;
        }

        public Builder naechster(WR naechster) {
            this.naechster = naechster;
            return this;
        }

        public EUR2USD build() {
            return new EUR2USD(wechselkurs, naechster);
        }
    }
}
