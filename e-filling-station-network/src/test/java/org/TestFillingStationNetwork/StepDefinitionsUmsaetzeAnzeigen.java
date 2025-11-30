package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

public class StepDefinitionsUmsaetzeAnzeigen {

    private RechnungsManager rm;
    private Konto konto;
    private double umsatz;

    @Given("es existieren Rechnungen für den Standort {string}")
    public void es_existieren_rechnungen_fuer_den_standort(String standortName) {

        rm = new RechnungsManager();

        // Dummy-Kunde + Konto
        Kunde k = new Kunde("Bruno", "Betreiber", "betreiber@test.com", "K500");
        konto = new Konto(k, "K500", "pw");

        // Erste Rechnung mit einem Posten an diesem Standort
        Rechnung r1 = new Rechnung("R1000", "K500", List.of("LV-1"), 50.0);
        r1.addRechnungsposten(
                new Rechnungsposten("LV-1", standortName, "LP-1", 10.0, 30, 50.0)
        );

        // Zweite Rechnung mit einem Posten an gleichem Standort
        Rechnung r2 = new Rechnung("R2000", "K500", List.of("LV-2"), 30.0);
        r2.addRechnungsposten(
                new Rechnungsposten("LV-2", standortName, "LP-2", 8.0, 20, 30.0)
        );

        konto.getRechnungen().add(r1);
        konto.getRechnungen().add(r2);
    }

    @When("der Betreiber den Umsatz für den Standort {string} für heute abfragt")
    public void der_betreiber_den_umsatz_fuer_den_standort_fuer_heute_abfragt(String standortName) {

        LocalDate heute = LocalDate.now();
        LocalDate von = heute.minusDays(1);
        LocalDate bis = heute.plusDays(1);

        umsatz = rm.berechneUmsatzFuerStandort(konto, von, bis, standortName);
    }

    @Then("sollte der Umsatz {double} Euro betragen")
    public void sollte_der_umsatz_euro_betragen(double erwarteterUmsatz) {
        assertThat(umsatz).isEqualTo(erwarteterUmsatz);
    }
}
