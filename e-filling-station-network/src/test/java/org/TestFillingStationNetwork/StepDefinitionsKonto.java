package org.TestFillingStationNetwork;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import static org.assertj.core.api.Assertions.*;

import FillingStationNetwork.*;
import java.util.Map;

public class StepDefinitionsKonto {

    private KundeManager kundeManager;
    private Konto erzeugtesKonto;

    @Given("es existiert kein Kunde mit der E-Mail {string}")
    public void KeinKundeMitEmail(String email) {
        kundeManager = new KundeManager();
        assertThat(kundeManager.existsByEmail(email)).isFalse();
    }

    @Given("es existiert bereits ein Kunde mit der E-Mail {string}")
    public void KundeExistiertMitEmail(String email) {
        kundeManager = new KundeManager();

        Kunde kunde = new Kunde("Test", "User", email);
        kundeManager.createKonto(kunde, "pw");

        assertThat(kundeManager.existsByEmail(email)).isTrue();
    }

    @When("der Kunde ein Konto mit folgenden Daten anlegt:")
    public void KundeLegtKontoAn(DataTable dataTable) {
        Map<String, String> row = dataTable.asMaps().get(0);

        Kunde kunde = new Kunde(
                row.get("Vorname"),
                row.get("Nachname"),
                row.get("E-Mail")
        );

        erzeugtesKonto = kundeManager.createKonto(kunde, row.get("Passwort"));
    }
    @Then("die Kundennummer des neuen Kunden sollte nicht leer sein")
    public void dieKundennummerDesNeuenKundenSollteNichtLeerSein() {
        assertThat(erzeugtesKonto.getKunde().getKundennummer()).isNotNull();
        assertThat(erzeugtesKonto.getKunde().getKundennummer()).isNotEmpty();
    }

    @Then("wird ein neues Kundenkonto erstellt")
    public void KontoWirdErstellt() {
        assertThat(erzeugtesKonto).isNotNull();
    }

    @Then("wird kein neues Kundenkonto erstellt")
    public void KontoWirdNichtErstellt() {
        assertThat(erzeugtesKonto).isNull();
    }
}
