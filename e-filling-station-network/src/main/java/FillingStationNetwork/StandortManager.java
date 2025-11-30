package FillingStationNetwork;

import java.util.ArrayList;

public class StandortManager {
    private ArrayList<Standort> standorte = new ArrayList<Standort>();

    public void AddStandort(Standort standort) {
        standorte.add(standort);
    }

    public Standort GetStandortById(String id) {
        return standorte.stream().filter(
                standort -> standort.getStandortId().equals(id)
        ).findFirst().orElse(null);
    }

    public ArrayList<Standort> GetStandorte() {
        return standorte;
    }

    public ArrayList<Standort> GetStandorteMitAktivemTarif() {
        ArrayList<Standort> result = new ArrayList<>();

        for (Standort s : standorte) {
            if (s.GetActiveTarifVersion() != null) {
                result.add(s);
            }
        }

        return result;
    }
}
