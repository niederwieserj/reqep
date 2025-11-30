package FillingStationNetwork;

import java.time.LocalDateTime;

public class Aufladung {
    private LocalDateTime zeitpunkt;
    private double betrag;

    public Aufladung(double betrag) {
        this.zeitpunkt = LocalDateTime.now();
        this.betrag = betrag;
    }

    public LocalDateTime getZeitpunkt() {
        return zeitpunkt;
    }

    public double getBetrag() {
        return betrag;
    }
}