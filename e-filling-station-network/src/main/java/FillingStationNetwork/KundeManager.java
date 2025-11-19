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

        String kundennummer = "K" + String.format("%04d", nummerCounter++);
        Konto konto = new Konto(kunde, kundennummer, passwort);
        konten.put(kundennummer, konto);
        return konto;
    }

    public Konto getByKundennummer(String id) {
        return konten.get(id);
    }
}
