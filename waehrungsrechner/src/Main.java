public class Main {
    public static void main(String[] args) {



        // Erstellen eines EUR2USD-Währungsrechners mit einem Wechselkurs
        EUR2USD eur2usd = new EUR2USD.Builder()
                .wechselkurs(1.12)
                .build();

        // Optional: Hinzufügen eines weiteren Rechners in die Chain of Responsibility
        EUR2USD eur2usdMitNaechstem = new EUR2USD.Builder()
                .wechselkurs(1.15)
                .naechster(new EUR2YEN()) // Angenommen, EUR2YEN ist ein weiterer Währungsrechner
                .build();

  
    }

}