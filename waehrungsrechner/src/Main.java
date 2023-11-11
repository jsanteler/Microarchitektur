public class Main {
    public static void main(String[] args) {


        WR eur2yen = new EUR2YEN();
        WR eur2usd = new EUR2USD();

        eur2yen.rechnerHinzufuegen(eur2usd);

        double betragInYen = eur2yen.umrechnen("EUR2YEN", 100); // 100 EUR zu YEN
        double betragInUsd = eur2yen.umrechnen("EUR2USD", 100); // 100 EUR zu USD
        System.out.println("100 EUR in YEN: " + betragInYen);
        System.out.println("100 EUR in USD: " + betragInUsd);

        eur2yen.rechnerEntfernen("EUR2USD");


        try {
            double betragNachEntfernung = eur2yen.umrechnen("EUR2USD", 100);
            System.out.println("100 EUR in USD nach Entfernung: " + betragNachEntfernung);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechner für EUR2USD wurde entfernt.");
        }


    }
}