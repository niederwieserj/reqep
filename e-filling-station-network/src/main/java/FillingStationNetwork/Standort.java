package FillingStationNetwork;

import java.util.ArrayList;

/**
 * Standort mit mehreren Ladepunkten
 */
public class Standort {
    private String StandortId;
    private String Name;
    private String Adresse;
    private ArrayList<Ladepunkt> Ladepunkte;

    /**
     * Konstruktor
     * @param StandortId
     * @param Name
     * @param Adresse
     * @param Ladepunkte
     */
    public Standort(String StandortId, String Name, String Adresse,  ArrayList<Ladepunkt> Ladepunkte) {
        this.StandortId = StandortId;
        this.Name = Name;
        this.Adresse = Adresse;
        this.Ladepunkte = new ArrayList<Ladepunkt>();
    }

    /**
     * Aktiven Tarif abrufen
     * @return Aktiven Tarif
     */
    Object GetActiveTarifVersion() {
        return null;
    }

    /**
     * Ladepunkte auflisten
     * @return Liste der Ladepunkte
     */
    ArrayList<Ladepunkt> GetLadepunkte() {
        return Ladepunkte;
    }
}
