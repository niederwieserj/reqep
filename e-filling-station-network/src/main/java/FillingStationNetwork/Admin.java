package FillingStationNetwork;

public class Admin {
    private String benutzername;
    private String passwort;

    // Admin-Konstruktor
    public Admin(String benutzername, String passwort) {
        this.benutzername = benutzername;
        this.passwort = passwort;
    }

    // Login-Methode, um zu prüfen, ob der Benutzername und das Passwort korrekt sind
    public boolean login(String benutzername, String passwort) {
        return this.benutzername.equals(benutzername) && this.passwort.equals(passwort);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return passwort;
    }
}
