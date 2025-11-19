package org.TestFillingStationNetwork;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

import FillingStationNetwork.*;
import FillingStationNetwork.Ladepunkt.*;

public class StepDefinitionsLadepunkt {
    private Ladepunkt ladepunkt;

    @When("der Betreiber einen neuen Ladepunkt erstellt mit ID {word}, Charging Mode {word} und Status {word}")
    public void WennBetreiberLadepunktErstellt(String ladepunktId, String chargingMode, String status) {
        ladepunkt = new Ladepunkt(ladepunktId, ChargingMode.valueOf(chargingMode), ChargingPointStatus.valueOf(status));
    }

    @When("der Betreiber den Ladepunkt-Status auf {word} setzt")
    public void WennBetreiberStatusSetzt(String ladepunktStatus) {
        ladepunkt.SetStatus(ChargingPointStatus.valueOf(ladepunktStatus));
    }

    @Then("hat der neue Ladepunkt die ID {word}, Charging Mode {word} und Status {word}")
    public void HatNeuerLadepunktRichtigeWerte(String ladepunktId, String chargingMode, String status) {
        assertThat(ladepunkt.getLadepunktId()).isEqualTo(ladepunktId);
        assertThat(ladepunkt.getChargingMode()).isEqualTo(ChargingMode.valueOf(chargingMode));
        assertThat(ladepunkt.getStatus()).isEqualTo(ChargingPointStatus.valueOf(status));
    }

    @Then("ist Ladepunkt available")
    public void IstLadepunktAvailable() {
        assertThat(ladepunkt.IsAvailable()).isTrue();
    }

    @Then("ist Ladepunkt nicht available")
    public void IstLadepunktNichtAvailable() {
        assertThat(ladepunkt.IsAvailable()).isFalse();
    }
}
