package FillingStationNetwork;

import java.util.UUID;

public class Kunde {
    private String vorname;
    private String nachname;
    private String email;
    private String kundennummer;
    private String[] ladevorgaenge;

    public Kunde(String vorname, String nachname, String email, String kundennummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.kundennummer = kundennummer;
        this.ladevorgaenge = new String[10];
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public String[] getLadevorgaenge() {
        return ladevorgaenge;
    }

    public void addLadevorgang(String ladevorgang) {
        for (int i = 0; i < ladevorgaenge.length; i++) {
            if (ladevorgaenge[i] == null) {
                ladevorgaenge[i] = ladevorgang;
                break;
            }
        }
    }

        public String getVorname () {
            return vorname;
        }

        public String getNachname () {
            return nachname;
        }

        public String getEmail () {
            return email;
        }
    }
