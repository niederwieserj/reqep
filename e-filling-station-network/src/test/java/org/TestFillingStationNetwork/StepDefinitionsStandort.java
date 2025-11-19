package org.TestFillingStationNetwork;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

import FillingStationNetwork.*;
import FillingStationNetwork.Ladepunkt.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitionsStandort {
    private Standort standort;

    @When("der Betreiber einen neuen Standort {string} erstellt mit ID {word} an Adresse {string} und folgenden Ladepunkten und folgender Beschreibung {string}")
    public void WennBetreiberStandortErstellt(String name, String id, String adresse,String beschreibung, DataTable ladePunkteTable) {
        // Convert datatable to list of list of strings and remove
        List<List<String>> ladepunkteInput = ladePunkteTable.asLists();

        // List of Ladepunkte to use in constructor
        ArrayList<Ladepunkt> ladepunkte = new ArrayList<>();

        for (int i = 1; i < ladepunkteInput.size(); i++) {
            // Parse String to Enum
            ChargingMode chargingMode = ChargingMode.valueOf(ladepunkteInput.get(i).get(1));
            ChargingPointStatus chargingPointStatus = ChargingPointStatus.valueOf(ladepunkteInput.get(i).get(2));

            ladepunkte.add(new Ladepunkt(ladepunkteInput.get(i).get(0), chargingMode, chargingPointStatus));
        }

        standort = new Standort(id, name, adresse, ladepunkte, beschreibung);
    }

    @Then("hat der neue Standort {string} die ID {word}, Adresse {string} und folgende Ladepunkte und folgender Beschreibung {string}")
    public void HatNeuerStandortRichtigeWerte(String name, String id, String adresse, String beschreibung, DataTable ladePunkteTable) {
        List<List<String>> ladepunkteInput = ladePunkteTable.asLists();
        ArrayList<Ladepunkt> ladepunkte = new ArrayList<>();

        for (int i = 1; i < ladepunkteInput.size(); i++) {
            // Parse String to Enum
            ChargingMode chargingMode = ChargingMode.valueOf(ladepunkteInput.get(i).get(1));
            ChargingPointStatus chargingPointStatus = ChargingPointStatus.valueOf(ladepunkteInput.get(i).get(2));

            ladepunkte.add(new Ladepunkt(ladepunkteInput.get(i).get(0), chargingMode, chargingPointStatus));
        }

        // Assert that all values are stored correctly
        assertThat(name).isEqualTo(standort.getName());
        assertThat(id).isEqualTo(standort.getStandortId());
        assertThat(adresse).isEqualTo(standort.getAdresse());
        assertThat(beschreibung).isEqualTo(standort.getBeschreibung());
        assertThat(ladepunkte.size()).isEqualTo(standort.GetLadepunkte().size());

        for (int i = 0; i < ladepunkte.size(); i++) {
            assertThat(ladepunkte.get(i).getLadepunktId()).isEqualTo(standort.GetLadepunkte().get(i).getLadepunktId());
            assertThat(ladepunkte.get(i).getChargingMode()).isEqualTo(standort.GetLadepunkte().get(i).getChargingMode());
            assertThat(ladepunkte.get(i).getStatus()).isEqualTo(standort.GetLadepunkte().get(i).getStatus());
        }
    }
}
