package FillingStationNetwork;

import java.util.ArrayList;

public class Standort {

    private String StandortId;
    private String Name;
    private String Adresse;
    private ArrayList<Ladepunkt> Ladepunkte;
    private String Beschreibung;
    private TarifVersion activeTarifVersion;

    public Standort(
            String StandortId,
            String Name,
            String Adresse,
            ArrayList<Ladepunkt> Ladepunkte,
            String Beschreibung
    ) {
        this.StandortId = StandortId;
        this.Name = Name;
        this.Adresse = Adresse;
        this.Ladepunkte = Ladepunkte;
        this.Beschreibung = Beschreibung;
        this.activeTarifVersion = null; // noch kein Tarif gesetzt
    }

    public String getStandortId() {
        return StandortId;
    }

    public String getName() {
        return Name;
    }

    public String getAdresse() {
        return Adresse;
    }

    public ArrayList<Ladepunkt> GetLadepunkte() {
        return Ladepunkte;
    }

    public String getBeschreibung() {
        return Beschreibung;
    }

    /** B7 – Aktive Tarifversion zurückgeben */
    public TarifVersion GetActiveTarifVersion() {
        return activeTarifVersion;
    }

    /** B7 – Tarifversion für diesen Standort setzen */
    public void SetActiveTarifVersion(TarifVersion tarifVersion) {
        this.activeTarifVersion = tarifVersion;
    }
}
