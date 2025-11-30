package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class StepDefinitionsRechnungenEinsehen {

    private Kunde kunde;
    private Konto konto;
    private RechnungsManager rechnungManager;
    private List<Rechnung> result;

    @Given("ein Kunde mit Rechnungen existiert")
    public void ein_kunde_mit_rechnungen_existiert() {

        kunde = new Kunde("Lisa", "Meier", "lisa@test.at", "K900");
        konto = new Konto(kunde, "K900", "pass");

        Rechnung r1 = new Rechnung("R10", "K900", List.of("LV-A"), 25.5);
        Rechnung r2 = new Rechnung("R20", "K900", List.of("LV-B"), 40.0);

        konto.getRechnungen().add(r1);
        konto.getRechnungen().add(r2);

        rechnungManager = new RechnungsManager();
    }

    @When("der Kunde seine Rechnungen abruft")
    public void der_kunde_ruft_rechnungen_ab() {
        result = rechnungManager.getRechnungenFuerKunde(konto);
    }

    @Then("sollte der Kunde die Rechnungen {string} und {string} sehen")
    public void sollte_der_kunde_die_rechnungen_sehen(String r1, String r2) {
        assertThat(result).extracting("rechnungsnummer")
                .containsExactlyInAnyOrder(r1, r2);
    }
}
