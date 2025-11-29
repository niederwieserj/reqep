package FillingStationNetwork;

import java.util.ArrayList;
import java.util.List;

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
}
