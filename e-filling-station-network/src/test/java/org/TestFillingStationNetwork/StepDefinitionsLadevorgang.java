package org.TestFillingStationNetwork;

import FillingStationNetwork.LadevorgangManager;
import FillingStationNetwork.Ladevorgang;
import FillingStationNetwork.Ladepunkt;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitionsLadevorgang {

    private LadevorgangManager manager;
    private Ladevorgang result;

    @Given("ein Ladevorgang-Manager existiert")
    public void ein_ladevorgang_manager_existiert() {
        manager = new LadevorgangManager();
    }

    @When("ich einen Ladevorgang starte mit Modus {string}, Ladepunkt {string} und Kunde {string}")
    public void ich_starte_einen_ladevorgang(String mode, String ladepunktId, String kundenId) {

        Ladepunkt.ChargingMode chargingMode = Ladepunkt.ChargingMode.valueOf(mode);

        manager.StartLadeVorgang(chargingMode, ladepunktId, kundenId);
        result = manager.getLadevorgang();
    }

    @Then("sollte ein Ladevorgang erstellt werden")
    public void sollte_ein_ladevorgang_erstellt_werden() {
        assertThat(result).isNotNull();
    }

    @Then("sollte der Ladevorgang den Modus {string} besitzen")
    public void sollte_der_ladevorgang_den_modus_besitzen(String mode) {
        assertThat(result.getChargingMode().name()).isEqualTo(mode);
    }

    @Then("sollte der Ladevorgang den Ladepunkt {string} enthalten")
    public void sollte_der_ladevorgang_den_ladepunkt_enthalten(String ladepunktId) {
        assertThat(result.getLadepunktId()).isEqualTo(ladepunktId);
    }

    @Then("sollte der Ladevorgang dem Kunden {string} zugeordnet sein")
    public void sollte_der_ladevorgang_dem_kunden_zugeordnet_sein(String kundenId) {
        assertThat(result.getKundenId()).isEqualTo(kundenId);
    }

    @Then("sollte der Startzeitpunkt gesetzt sein")
    public void sollte_der_startzeitpunkt_gesetzt_sein() {
        assertThat(result.getStart()).isNotNull();
    }
}
