package org.example.Observer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;

public class LogObserver implements Observer {
    private String logFilePath;
    private static final String LOG_FILE_NAME = "logdatei.txt";
    public LogObserver() {
        // Setzen des Pfads der Log-Datei
        this.logFilePath = LOG_FILE_NAME;
        try {
            // Erstellen eines File-Objekts für die Log-Datei
            File logFile = new File(logFilePath);
            // Überprüfen, ob die Datei existiert, und erstellen sie, falls sie nicht existiert
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Erstellen der Log-Datei: " + logFilePath, e);
        }
    }
    @Override
    public void update(String message) {
        //Zeitstempel
        String logEntry = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + " - " + message + System.lineSeparator();
        //erstes try fängt Fehler, die beim Schreiben passieren können
        try {
            //zweites try sorgt dafür, dass die Datei immer richtig geschlossen wird, auch wenn ein Fehler auftritt.

            try (FileWriter writer = new FileWriter(this.logFilePath, true)) { // 'true' fügt ans Dateiende hinzu
                writer.write(logEntry);
                System.out.println("Nachricht erfolgreich in Log-Datei geschrieben: " + message);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Log-Datei: " + e.getMessage());
        }
    }
}