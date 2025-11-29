package FillingStationNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadepunktManager {
    /**
     * Reference to the Standortmanager class in order to access its data
     */
    private StandortManager standortManagerReference;

    public LadepunktManager(StandortManager standortManagerReference) {
        this.standortManagerReference = standortManagerReference;
    }

    public ArrayList<Ladepunkt> GetLadepunkteByStandort(String standortId) {
        Standort standort = standortManagerReference.GetStandortById(standortId);

        if (standort == null) {
            return null;
        }

        return standortManagerReference.GetStandortById(standortId).GetLadepunkte();
    }

    public ArrayList<Ladepunkt> GetAvailableLadepunkte(String standortId) {
        ArrayList<Ladepunkt> ladepunkte = standortManagerReference.GetStandortById(standortId).GetLadepunkte();
        Stream<Ladepunkt> availableLadepunkte = ladepunkte.stream().filter(ladepunkt -> ladepunkt.IsAvailable());
        return new ArrayList<Ladepunkt> (availableLadepunkte.toList());
    }

    public void SetLadepunktStatus(String ladepunktId, Ladepunkt.ChargingPointStatus status) {
        ArrayList<Standort> standorte = standortManagerReference.GetStandorte();
        Ladepunkt ladepunktRef = null;

        for (Standort standort : standorte) {
            Stream<Ladepunkt> foundLadepunkt = (Stream<Ladepunkt>) standort.GetLadepunkte().stream().filter(
                    ladepunkt -> ladepunkt.getLadepunktId().equals(ladepunktId)
            ).findFirst().orElse(null);

            if (foundLadepunkt != null) {
                ladepunktRef = (Ladepunkt) foundLadepunkt.toList();
                break;
            }
        }

        if (ladepunktRef != null) {
            ladepunktRef.SetStatus(status);
        }
    }
}
