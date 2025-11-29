package FillingStationNetwork;

import java.util.ArrayList;
import java.util.List;

public class Konto {
    private Kunde kunde;
    private String kundennummer;
    private String passwort;
    private double guthaben; // Neues Feld für Guthaben
    private String[] bewegungsdaten; // Neues Feld für Bewegungsdaten
    private String[] ladevorgaenge;
    private List<Rechnung> rechnungen;

    public Konto(Kunde kunde, String kundennummer, String passwort) {
        this.kunde = kunde;
        this.kundennummer = kundennummer;
        this.passwort = passwort;
        this.guthaben = 0.0; // Anfangsguthaben auf 0 setzen
        this.bewegungsdaten = new String[10]; // Maximale Anzahl von Transaktionen, die wir speichern möchten
        this.ladevorgaenge = new String[10];  // Maximale Anzahl von Ladevorgängen, die wir speichern möchten
        this.rechnungen = new ArrayList<>();
    }

    public Kunde getKunde() {
        return kunde;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(double guthaben) {
        this.guthaben = guthaben;
    }

    public String[] getBewegungsdaten() {
        return bewegungsdaten;
    }

    public void addBewegung(String transaktion) {
        // Füge eine neue Transaktion in das Bewegungsdaten-Array ein
        for (int i = 0; i < bewegungsdaten.length; i++) {
            if (bewegungsdaten[i] == null) {
                bewegungsdaten[i] = transaktion;
                break;
            }
        }
    }

    public void addTopUp(double amount) {
        if (amount > 0) {
            guthaben += amount;
            addBewegung("Aufladung: +" + amount + " EUR");
        }
    }

    public String[] getLadevorgaenge() {
        return ladevorgaenge;
    }

    public void addLadevorgang(String ladevorgang) {
        // Ladevorgang hinzufügen
        for (int i = 0; i < ladevorgaenge.length; i++) {
            if (ladevorgaenge[i] == null) {
                ladevorgaenge[i] = ladevorgang;
                break;
            }
        }
    }

    public List<Rechnung> getRechnungen() {
        return rechnungen;
    }

    public Rechnung erstelleRechnung() {
        double betrag = 0.0;
        List<String> abgeschlosseneLadevorgaenge = new ArrayList<>();
        for (String ladevorgang : ladevorgaenge) {
            if (ladevorgang != null) {
                abgeschlosseneLadevorgaenge.add(ladevorgang);
                betrag += 20.0; // Beispielpreis pro Ladevorgang
            }
        }

        if (!abgeschlosseneLadevorgaenge.isEmpty()) {
            String rechnungsnummer = "R" + System.currentTimeMillis();
            Rechnung rechnung = new Rechnung(rechnungsnummer, kundennummer, abgeschlosseneLadevorgaenge, betrag);
            rechnungen.add(rechnung);
            return rechnung;
        }
        return null;  // Keine Ladevorgänge, keine Rechnung
    }


}
