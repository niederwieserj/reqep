package org.TestFillingStationNetwork;

import FillingStationNetwork.Standort;
import FillingStationNetwork.StandortManager;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitionsStandortManager {
    private StandortManager standortManager;
    private Standort lastRetrievedStandort;

    @Given("ein Standort-Manager existiert")
    public void ein_standort_manager_existiert() {
        standortManager = new StandortManager();
    }

    @When("ich einen Standort mit der ID {string} hinzufüge")
    public void ich_einen_standort_mit_der_id_hinzufuege(String id) {
        Standort s = new Standort(id, "", "", null, "");
        standortManager.AddStandort(s);
    }

    @When("ich den Standort mit der ID {string} abfrage")
    public void ich_den_standort_mit_id_abfrage(String id) {
        lastRetrievedStandort = standortManager.GetStandortById(id);
    }

    @Then("sollte der zurückgegebene Standort nicht null sein")
    public void sollte_der_zurueckgegebene_standort_nicht_null_sein() {
        assertThat(lastRetrievedStandort).isNotNull();
    }

    @Then("sollte der zurückgegebene Standort null sein")
    public void sollte_der_zurueckgegebene_standort_null_sein() {
        assertThat(lastRetrievedStandort).isNull();
    }

    @Then("sollte die Standort-ID {string} sein")
    public void sollte_die_standort_id_sein(String id) {
        assertThat(id).isEqualTo(lastRetrievedStandort.getStandortId());
    }

    @Then("sollte die Anzahl der Standorte {int} sein")
    public void sollte_die_anzahl_der_standorte_sein(int expectedCount) {
        assertThat(expectedCount).isEqualTo(standortManager.GetStandorte().size());
    }
}
