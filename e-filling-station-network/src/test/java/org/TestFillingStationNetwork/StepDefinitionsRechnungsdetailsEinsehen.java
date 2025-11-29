package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class StepDefinitionsRechnungsdetailsEinsehen {

    private Konto konto;
    private RechnungsManager rechnungManager;
    private Rechnung result;

    @Given("ein Kunde hat eine Rechnung mit Details")
    public void ein_kunde_hat_eine_rechnung() {

        Kunde k = new Kunde("Tom", "Tester", "tom@test.com", "K111");
        konto = new Konto(k, "K111", "password");

        Rechnung r = new Rechnung("R500", "K111", List.of("LV9"), 60.0);
        r.addRechnungsposten(new Rechnungsposten("LV9", "Wien Mitte",
                "LP-11", 12.5, 30, 60.0));

        konto.getRechnungen().add(r);

        rechnungManager = new RechnungsManager();
    }

    @When("der Kunde die Rechnungsdetails zur Rechnungsnummer {string} abruft")
    public void details_abrufen(String rnr) {
        result = rechnungManager.getRechnungDetails(konto, rnr);
    }

    @Then("sollte er den Standort {string}, Ladepunkt {string} und Preis {double} sehen")
    public void sollte_er_details_sehen(String standort, String lp, double preis) {

        assertThat(result).isNotNull();
        Rechnungsposten p = result.getPosten().get(0);

        assertThat(p.getStandortName()).isEqualTo(standort);
        assertThat(p.getLadepunktId()).isEqualTo(lp);
        assertThat(p.getPreis()).isEqualTo(preis);
    }
}
