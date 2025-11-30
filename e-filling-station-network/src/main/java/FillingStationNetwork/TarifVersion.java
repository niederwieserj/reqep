package FillingStationNetwork;

public class TarifVersion {

    private final double preisProKwh;
    private final double preisProMinute;

    public TarifVersion(double preisProKwh, double preisProMinute) {
        this.preisProKwh = preisProKwh;
        this.preisProMinute = preisProMinute;
    }

    public double getPreisProKwh() {
        return preisProKwh;
    }

    public double getPreisProMinute() {
        return preisProMinute;
    }
}
