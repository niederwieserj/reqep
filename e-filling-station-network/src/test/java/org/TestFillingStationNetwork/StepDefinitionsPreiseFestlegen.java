package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import FillingStationNetwork.Ladepunkt.*;
import io.cucumber.java.en.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitionsPreiseFestlegen {

    private Standort standort;

    @Given("ein Standort für das Festlegen von Preisen mit der ID {string} existiert")
    public void ein_standort_fuer_das_festlegen_von_preisen_existiert(String standortId) {

        ArrayList<Ladepunkt> ladepunkte = new ArrayList<>();
        // einfacher Test-Standort ohne echte Ladepunkte
        standort = new Standort(
                standortId,
                "Test-Standort",
                "Musterstrasse 1, 1010 Wien",
                ladepunkte,
                "Standort für Preis-Tests"
        );
    }

    @When("der Betreiber für diesen Standort den Preis pro kWh {double} und den Preis pro Minute {double} festlegt")
    public void der_betreiber_legt_preise_fest(double preisProKwh, double preisProMinute) {

        TarifVersion tarif = new TarifVersion(preisProKwh, preisProMinute);
        standort.SetActiveTarifVersion(tarif);
    }

    @Then("sollte der aktive Tarif des Standorts den Preis pro kWh {double} und den Preis pro Minute {double} haben")
    public void der_aktive_tarif_hat_die_gesetzten_preise(double erwarteterPreisProKwh,
                                                          double erwarteterPreisProMinute) {

        TarifVersion tarif = standort.GetActiveTarifVersion();

        assertThat(tarif).isNotNull();
        assertThat(tarif.getPreisProKwh()).isEqualTo(erwarteterPreisProKwh);
        assertThat(tarif.getPreisProMinute()).isEqualTo(erwarteterPreisProMinute);
    }
}
