package org.TestFillingStationNetwork;

import FillingStationNetwork.Ladepunkt;
import FillingStationNetwork.Ladepunkt.*;
import FillingStationNetwork.LadepunktManager;
import FillingStationNetwork.Standort;
import FillingStationNetwork.StandortManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitionsLadepunktManager {
    private LadepunktManager ladepunktManager;
    private ArrayList<Ladepunkt> lastRetrievedLadepunkte;
    private ArrayList<Ladepunkt> available;

    @Given("ein Ladepunkt-Manager mit Ladepunkten existiert")
    public void ein_standort_manager_existiert() {
        ArrayList<Ladepunkt> ladepunkte = new ArrayList<Ladepunkt>();
        ladepunkte.add(new Ladepunkt("LP1", ChargingMode.AC, ChargingPointStatus.FREE));

        Standort standort = new Standort("ST1", "Name1", "Address1", ladepunkte, "Description1");

        StandortManager standortManager = new StandortManager();
        standortManager.AddStandort(standort);

        ladepunktManager = new LadepunktManager(standortManager);
    }

    @Given("ein Ladepunkt-Manager ohne Ladepunkten existiert")
    public void ein_standort_manager_leer_existiert() {
        ArrayList<Ladepunkt> ladepunkte = new ArrayList<Ladepunkt>();

        Standort standort = new Standort("ST1", "Name1", "Address1", ladepunkte, "Description1");

        StandortManager standortManager = new StandortManager();
        standortManager.AddStandort(standort);

        ladepunktManager = new LadepunktManager(standortManager);
    }

    @When("ich die Ladepunkte des Standorts mit der ID {string} abfrage")
    public void ich_lp_mit_id_abfrage(String id) {
        lastRetrievedLadepunkte = ladepunktManager.GetLadepunkteByStandort(id);
    }

    @Then("sollten die zurückgegebenen Ladepunkte nicht null sein")
    public void sollte_der_zurueckgegebene_lp_nicht_null_sein() {
        assertThat(lastRetrievedLadepunkte).isNotNull();
    }

    @Then("sollten die zurückgegebenen Ladepunkte null sein")
    public void sollte_der_zurueckgegebene_lp_null_sein() {
        assertThat(lastRetrievedLadepunkte).isNull();
    }

    @When("ich die verfügbaren Ladepunkte abfrage für Standort {string}")
    public void i_request_available_ladepunkte(String standortId) {
        available = ladepunktManager.GetAvailableLadepunkte(standortId);
    }

    @Then("gibt es {int} verfügbare Ladepunkte")
    public void i_should_get_available_ladepunkte(int expectedCount) {
        assertThat(available).isNotNull();
        assertThat(expectedCount).isEqualTo(available.size());
    }

    @Then("beinhalten die verfügbaren Ladepunkte die ID {string}")
    public void available_ladepunkte_should_include(String ladepunktId) {
        boolean found = available.stream()
                .anyMatch(lp -> lp.getLadepunktId().equals(ladepunktId));

        assertThat(found).isTrue();
    }

    @Then("beinhalten die verfügbaren Ladepunkte nicht die ID {string}")
    public void available_ladepunkte_should_not_include(String ladepunktId) {
        boolean found = available.stream()
                .anyMatch(lp -> lp.getLadepunktId().equals(ladepunktId));

        assertThat(found).isFalse();
    }
}
