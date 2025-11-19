package FillingStationNetwork;

import jdk.jshell.spi.ExecutionControl;

/**
 * Ladepunkt
 */
public class Ladepunkt {
    /** Unique ID of the Ladepunkt */
    private String ladepunktId;
    /** Supported charging mode of this Ladepunkt */
    private ChargingMode chargingMode;
    /** Current status of the Ladepunkt */
    private ChargingPointStatus status;

    /**
     * Konstruktor
     * @param ladepunktId Unique ID of the Ladepunkt
     * @param chargingMode Supported charging mode of this Ladepunkt
     * @param status Current status of the Ladepunkt
     */
    public Ladepunkt(String ladepunktId, ChargingMode chargingMode, ChargingPointStatus status) {
        this.ladepunktId = ladepunktId;
        this.chargingMode = chargingMode;
        this.status = status;
    }

    /**
     * Check if Ladepunkt is available
     * @return True if available; False otherwise
     */
    public boolean IsAvailable () {
        return status == ChargingPointStatus.FREE;
    }

    /**
     * Start charging session
     * @param Kunde Customer who wants to charge
     * @throws ExecutionControl.NotImplementedException Not implemented yet
     */
    public void StartChargingSession (Object Kunde) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented yet");
    }

    /**
     * Set Status of Ladepunkt
     * @param status Status to set
     */
    public void SetStatus(ChargingPointStatus status) {
        this.status = status;
    }

    public String getLadepunktId() {
        return ladepunktId;
    }

    public ChargingMode getChargingMode() {
        return chargingMode;
    }

    public ChargingPointStatus getStatus() {
        return status;
    }

    /**
     * Available charging modes
     */
    public enum ChargingMode {
        /** Alternating Current */
        AC,
        /** Direct Current */
        DC
    }

    /**
     * Available charging point status
     */
    public enum ChargingPointStatus {
        /** Ladepunkt is free */
        FREE,
        /** Ladepunkt is busy */
        BUSY,
        /** Ladepunkt is out of order */
        OUT_OF_ORDER
    }
}
