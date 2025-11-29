package FillingStationNetwork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Rechnung {
    private String rechnungsnummer;
    private LocalDate erstelldatum;
    private double betrag;
    private List<String> ladevorgaenge;
    private String status; // z.B. "Bezahlt", "Offen"
    private String kundennummer; // Hier wird die Kundennummer gespeichert
    private List<Rechnungsposten> posten = new ArrayList<>();

    public Rechnung(String rechnungsnummer, String kundennummer, List<String> ladevorgaenge, double betrag) {
        this.rechnungsnummer = rechnungsnummer;
        this.kundennummer = kundennummer;  // Kundennummer speichern
        this.erstelldatum = LocalDate.now();
        this.ladevorgaenge = ladevorgaenge;
        this.betrag = betrag;
        this.status = "Offen";  // Initialstatus "Offen"
    }

    public String getRechnungsnummer() {
        return rechnungsnummer;
    }

    public LocalDate getErstelldatum() {
        return erstelldatum;
    }

    public double getBetrag() {
        return betrag;
    }

    public List<String> getLadevorgaenge() {
        return ladevorgaenge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKundennummer() {
        return kundennummer;  // Hier geben wir die Kundennummer zurück
    }

    public void addRechnungsposten(Rechnungsposten rp) {
        posten.add(rp);
    }

    public List<Rechnungsposten> getPosten() {
        return posten;
    }

}
