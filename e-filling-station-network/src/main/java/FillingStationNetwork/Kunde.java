package FillingStationNetwork;

public class Kunde {
    private String vorname;
    private String nachname;
    private String email;

    public Kunde(String vorname, String nachname, String email) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
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
