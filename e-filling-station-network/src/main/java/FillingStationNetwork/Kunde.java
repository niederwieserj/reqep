package FillingStationNetwork;

import java.util.UUID;

public class Kunde {
    private String vorname;
    private String nachname;
    private String email;
    private String kundennummer;

    public Kunde(String vorname, String nachname, String email, String kundennummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.kundennummer = kundennummer;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }
}
