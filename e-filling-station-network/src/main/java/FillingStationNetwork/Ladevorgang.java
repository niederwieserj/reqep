package FillingStationNetwork;

import java.util.Date;

public class Ladevorgang {
    private String ladeVorgangId;
    private Date start;
    private Date end;
    private double geladeneKwh;
    private int dauerMinuten;
    private double preisProKwh;
    private double preisProMinute;
    private Ladepunkt.ChargingMode chargingMode;
    private String ladepunktId;
    private String kundenId;

    public Ladevorgang(String ladeVorgangId, Ladepunkt.ChargingMode chargingMode, String ladepunktId, String kundenId) {
        this.ladeVorgangId = ladeVorgangId;
        this.chargingMode = chargingMode;
        this.ladepunktId = ladepunktId;
        this.kundenId = kundenId;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public double CalculatePrice() {
        return 0.0;
    }

    public void CloseSession() {

    }

    public String getLadeVorgangId() {
        return ladeVorgangId;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public double getGeladeneKwh() {
        return geladeneKwh;
    }

    public int getDauerMinuten() {
        return dauerMinuten;
    }

    public double getPreisProKwh() {
        return preisProKwh;
    }

    public double getPreisProMinute() {
        return preisProMinute;
    }

    public Ladepunkt.ChargingMode getChargingMode() {
        return chargingMode;
    }

    public String getLadepunktId() {
        return ladepunktId;
    }

    public String getKundenId() {
        return kundenId;
    }
}
