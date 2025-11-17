package FillingStationNetwork;

import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;

/**
 * Standort mit mehreren Ladepunkten
 */
public class Standort {
    /** Unique ID of the Standort */
    private String StandortId;
    /** Name of the Standort */
    private String Name;
    /** Address of the Standort */
    private String Adresse;
    /** Ladepunkte of this Standort */
    private ArrayList<Ladepunkt> Ladepunkte;

    /**
     * Konstruktor
     * @param StandortId Unique ID of the Standort
     * @param Name Name of the Standort
     * @param Adresse Address of the Standort
     * @param Ladepunkte Ladepunkte of this Standort
     */
    public Standort(String StandortId, String Name, String Adresse,  ArrayList<Ladepunkt> Ladepunkte) {
        this.StandortId = StandortId;
        this.Name = Name;
        this.Adresse = Adresse;
        this.Ladepunkte = Ladepunkte;
    }

    /**
     * Aktiven Tarif abrufen
     * @return Aktiven Tarif
     * @throws ExecutionControl.NotImplementedException Not implemented yet
     */
    Object GetActiveTarifVersion() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented yet");
    }

    /**
     * Ladepunkte auflisten
     * @return Liste der Ladepunkte
     */
    public ArrayList<Ladepunkt> GetLadepunkte() {
        return Ladepunkte;
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
}
