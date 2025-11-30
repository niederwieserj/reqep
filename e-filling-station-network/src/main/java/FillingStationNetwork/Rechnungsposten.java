package FillingStationNetwork;

public class Rechnungsposten {
    private String ladevorgangId;
    private String standortName;
    private String ladepunktId;
    private double kWh;
    private int dauerMinuten;
    private double preis;

    public Rechnungsposten(String ladevorgangId, String standortName,
                           String ladepunktId, double kWh, int dauerMinuten, double preis) {
        this.ladevorgangId = ladevorgangId;
        this.standortName = standortName;
        this.ladepunktId = ladepunktId;
        this.kWh = kWh;
        this.dauerMinuten = dauerMinuten;
        this.preis = preis;
    }

    public String getLadevorgangId() { return ladevorgangId; }
    public String getStandortName() { return standortName; }
    public String getLadepunktId() { return ladepunktId; }
    public double getKWh() { return kWh; }
    public int getDauerMinuten() { return dauerMinuten; }
    public double getPreis() { return preis; }
}