package FillingStationNetwork;

import java.util.HashMap;
import java.util.Map;

public class KundeManager {

    private Map<String, Konto> konten = new HashMap<>();
    private int nummerCounter = 1;

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
