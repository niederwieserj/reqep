package FillingStationNetwork;

import java.util.HashMap;
import java.util.Map;

public class KundeManager {

    private Map<String, Konto> konten = new HashMap<>();
    private int nummerCounter = 1;

    public KundeManager() {
        this.konten = new HashMap<>();
    }

    // Konstruktor mit Map
    public KundeManager(Map<String, Konto> konten) {
        this.konten = konten;
    }

    public void zeigeKundendaten(String kundennummer) {
        Konto konto = konten.get(kundennummer);
        if (konto != null) {
            Kunde kunde = konto.getKunde();  // Kunde aus dem Konto abrufen
            System.out.println("Kundennummer: " + kunde.getKundennummer());
            System.out.println("Name: " + kunde.getVorname() + " " + kunde.getNachname());
            System.out.println("Email: " + kunde.getEmail());
        } else {
            System.out.println("Kunde nicht gefunden.");
        }
    }

    public void zeigeLadevorgaenge(String kundennummer) {
        Konto konto = konten.get(kundennummer);
        if (konto != null) {
            String[] ladevorgaenge = konto.getLadevorgaenge();  // Ladevorgänge aus dem Konto abrufen
            System.out.println("Ladevorgänge für Kundennummer " + kundennummer + ":");
            for (String ladevorgang : ladevorgaenge) {
                if (ladevorgang != null) {
                    System.out.println(ladevorgang);
                }
            }
        } else {
            System.out.println("Kunde nicht gefunden.");
        }
    }

    public boolean existsByEmail(String email) {
        return konten.values().stream()
                .anyMatch(k -> k.getKunde().getEmail().equals(email));
    }

    public Konto createKonto(Kunde kunde, String passwort) {
        if (existsByEmail(kunde.getEmail())) {
            return null;
        }

        String kundennummer = kunde.getKundennummer();  // Kundennummer wird direkt aus dem Kunde-Objekt verwendet

        Konto konto = new Konto(kunde, kundennummer, passwort);  // Konto mit der Kundennummer aus dem 'Kunde' Objekt erstellen
        konten.put(kundennummer, konto);  // Die Kundennummer als Schlüssel im 'konten' Map speichern
        return konto;
    }


    public Konto getByKundennummer(String id) {
        return konten.get(id);
    }
}
