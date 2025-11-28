package FillingStationNetwork;

public class Konto {
    private Kunde kunde;
    private String kundennummer;
    private String passwort;
    private double guthaben; // Neues Feld für Guthaben
    private String[] bewegungsdaten; // Neues Feld für Bewegungsdaten
    private String[] ladevorgaenge;

    public Konto(Kunde kunde, String kundennummer, String passwort) {
        this.kunde = kunde;
        this.kundennummer = kundennummer;
        this.passwort = passwort;
        this.guthaben = 0.0; // Anfangsguthaben auf 0 setzen
        this.bewegungsdaten = new String[10]; // Maximale Anzahl von Transaktionen, die wir speichern möchten
        this.ladevorgaenge = new String[10];  // Maximale Anzahl von Ladevorgängen, die wir speichern möchten
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

}
