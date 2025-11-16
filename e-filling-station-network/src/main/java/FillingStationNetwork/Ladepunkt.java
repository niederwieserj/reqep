package FillingStationNetwork;

import jdk.jshell.spi.ExecutionControl;

public class Ladepunkt {
    private String ladepunktId;
    private ChargingMode chargingMode;
    private ChargingPointStatus status;

    public boolean IsAvailable () {
        return status == ChargingPointStatus.FREE;
    }

    public void StartChargingSession (Object Kunde) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not implemented yet");
    }

    public void SetStatus(ChargingPointStatus status) {
        this.status = status;
    }

    public enum ChargingMode {
        AC,
        DC
    }

    public enum ChargingPointStatus {
        FREE,
        BUSY,
        OUT_OF_ORDER
    }
}
