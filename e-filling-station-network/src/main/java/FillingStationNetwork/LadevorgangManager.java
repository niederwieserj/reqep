package FillingStationNetwork;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LadevorgangManager {
    Ladevorgang ladevorgang;

    public void StartLadeVorgang(Ladepunkt.ChargingMode chargingMode, String ladepunktId, String kundenId) {
        ladevorgang = new Ladevorgang("LV0001", chargingMode, ladepunktId, kundenId);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        ladevorgang.setStart(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

    public void StopLadeVorgang() {

    }

    public Ladevorgang getLadevorgang() {
        return ladevorgang;
    }
}
