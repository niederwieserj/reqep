package org.TestFillingStationNetwork;

import FillingStationNetwork.Konto;
import FillingStationNetwork.Kunde;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitionGuthabenAufladen {

    private Konto konto;
    private double initialBalance;
    private double rechargeAmount;
    private double resultBalance;

    @Given("ein Kunde mit Konto und einem Anfangsguthaben von {double} Euro existiert")
    public void ein_konto_mit_anfangsguthaben_existiert(double guthaben) {
        Kunde kunde = new Kunde("Max", "Mustermann", "mail@max.at", "K123"); // adjust if needed
        konto = new Konto(kunde, "K123", "pw123");
        konto.setGuthaben(guthaben);
        initialBalance = guthaben;
    }

    @When("ich das Konto um {double} Euro auflade")
    public void ich_lade_das_konto_auf(double amount) {
        rechargeAmount = amount;

        // Simulate the top-up
        double newBalance = konto.getGuthaben() + amount;
        konto.addTopUp(amount);

        resultBalance = konto.getGuthaben();
    }

    @Then("sollte das Guthaben um den Aufladebetrag erhöht werden")
    public void guthaben_sollte_erhoeht_werden() {
        assertThat(resultBalance).isEqualTo(initialBalance + rechargeAmount);
    }

    @Then("sollte ein neuer Bewegungsdateneintrag für die Aufladung existieren")
    public void ein_bewegungsdaten_eintrag_sollte_existieren() {
        String[] bewegungen = konto.getBewegungsdaten();

        boolean found = false;
        for (String eintrag : bewegungen) {
            if (eintrag != null && eintrag.contains("Aufladung: +" + rechargeAmount)) {
                found = true;
                break;
            }
        }

        assertThat(found).isTrue();
    }

    @When("ich versuche das Konto um einen negativen Betrag von {double} Euro aufzuladen")
    public void ich_versuche_negativen_betrag_aufzuladen(double amount) {
        rechargeAmount = amount;

        konto.addTopUp(amount);

        // Negative amount should not change balance
        resultBalance = konto.getGuthaben();
    }

    @Then("sollte das Guthaben unverändert bleiben")
    public void guthaben_sollte_unveraendert_bleiben() {
        assertThat(resultBalance).isEqualTo(initialBalance);
    }

    @Then("sollte kein neuer Bewegungsdateneintrag erstellt werden")
    public void kein_bewegungsdaten_eintrag_sollte_entstehen() {
        String[] bewegungen = konto.getBewegungsdaten();

        boolean containsNegativeEntry = false;
        for (String eintrag : bewegungen) {
            if (eintrag != null && eintrag.contains("Aufladung")) {
                containsNegativeEntry = true;
            }
        }

        assertThat(containsNegativeEntry).isFalse();
    }
}
