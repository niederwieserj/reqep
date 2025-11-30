package FillingStationNetwork;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RechnungsManager {

    public List<Rechnung> getRechnungenFuerKunde(Konto konto){
        return konto.getRechnungen();
    }

    public Rechnung getRechnungDetails(Konto konto, String rechnungsnummer){
        return konto.getRechnungen().stream()
                .filter(r -> r.getRechnungsnummer().equals(rechnungsnummer))
                .findFirst()
                .orElse(null);
    }

    public List<Rechnung> filterRechnungen(
            Konto konto,
            LocalDate von,
            LocalDate bis,
            String standortName
    ){
        List<Rechnung> result = new ArrayList<>();

        for (Rechnung r : konto.getRechnungen()) {

            boolean okDatum =
                    (von == null || !r.getErstelldatum().isBefore(von))
                            && (bis == null || !r.getErstelldatum().isAfter(bis));

            boolean okStandort =
                    (standortName == null)
                            || r.getPosten().stream()
                            .anyMatch(p -> p.getStandortName().equals(standortName));

            if (okDatum && okStandort) {
                result.add(r);
            }
        }

        return result;
    }

    public double berechneUmsatzFuerStandort(
            Konto konto,
            LocalDate von,
            LocalDate bis,
            String standortName
    ) {
        double umsatz = 0.0;

        for (Rechnung r : konto.getRechnungen()) {

            boolean okDatum =
                    (von == null || !r.getErstelldatum().isBefore(von))
                            && (bis == null || !r.getErstelldatum().isAfter(bis));

            if (!okDatum) {
                continue;
            }

            for (Rechnungsposten p : r.getPosten()) {

                boolean okStandort =
                        (standortName == null)
                                || p.getStandortName().equals(standortName);

                if (okStandort) {
                    umsatz += p.getPreis();
                }
            }
        }

        return umsatz;
    }

}