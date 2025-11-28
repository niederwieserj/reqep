package FillingStationNetwork;

import java.time.LocalDate;

public class Konto {
    private Kunde kunde;
    private String kundennummer;
    private String passwort;
    private LocalDate erstelltAm;

    public Konto(Kunde kunde, String kundennummer, String passwort) {
        this.kunde = kunde;
        this.kundennummer = kundennummer;
        this.passwort = passwort;
        this.erstelltAm = LocalDate.now();
    }

    public Kunde getKunde() {
        return kunde;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public String getPasswort() {
        return passwort;
    }

    public LocalDate getErstelltAm() {
        return erstelltAm;
    }
}
