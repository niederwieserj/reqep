package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

public class StepDefinitionsRechnungenFiltern {

    private RechnungsManager rm;
    private Konto konto;
    private List<Rechnung> result;

    @Given("ein Kunde hat mehrere Rechnungen an verschiedenen Standorten")
    public void kunde_hat_mehrere_rechnungen() {

        rm = new RechnungsManager();
        Kunde k = new Kunde("Julia", "Filter", "filter@test.com", "K300");
        konto = new Konto(k, "K300", "pw");

        Rechnung r1 = new Rechnung("R100", "K300", List.of("LV1"), 20.0);
        r1.addRechnungsposten(new Rechnungsposten("LV1", "Wien", "LP1", 10, 20, 20));

        Rechnung r2 = new Rechnung("R200", "K300", List.of("LV2"), 25.0);
        r2.addRechnungsposten(new Rechnungsposten("LV2", "Graz", "LP2", 12, 30, 25));

        konto.getRechnungen().add(r1);
        konto.getRechnungen().add(r2);
    }

    @When("der Kunde nach Standort {string} filtert")
    public void nach_standort_filtern(String standort) {
        result = rm.filterRechnungen(konto, null, null, standort);
    }

    @Then("sollte er nur die Rechnung {string} sehen")
    public void sollte_er_nur_rechnung_sehen(String rnr) {

        assertThat(result).extracting("rechnungsnummer")
                .containsExactly(rnr);
    }
}
