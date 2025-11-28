package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitionsGuthabenEinsehen {

    private KundeManager kundeManager;
    private String kundennummer;

    @Given("der Betreiber möchte das Guthaben des Kunden mit der Kundennummer {string} einsehen")
    public void derBetreiberMöchteDasGuthabenEinsehen(String kundennummer) {
        this.kundennummer = kundennummer;

        // Map und Konto mit der Kundennummer "K1234" anlegen
        Map<String, Konto> konten = new HashMap<>();
        Kunde kunde = new Kunde("Max", "Muster", "max@muster.com", "K1234");
        Konto konto = new Konto(kunde, kundennummer, "passwort");
        konto.setGuthaben(150.0);  // Guthaben setzen
        konten.put(kundennummer, konto);

        // KundeManager initialisieren
        kundeManager = new KundeManager(konten);
    }

    @When("der Betreiber ruft das Guthaben des Kunden ab")
    public void derBetreiberRuftDasGuthabenAb() {
        // Guthaben des Kunden abrufen
        kundeManager.zeigeGuthaben(kundennummer);
    }

    @Then("sollte der Betreiber das Guthaben {string} sehen")
    public void sollteDerBetreiberDasGuthabenSehen(String guthaben) {
        Konto konto = kundeManager.getByKundennummer(kundennummer);
        // Verifikation des Guthabens
        assertThat(konto.getGuthaben()).isEqualTo(Double.parseDouble(guthaben));
    }
}
