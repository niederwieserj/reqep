package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitionsRechnungenErstellen {

    private KundeManager kundeManager;
    private String kundennummer;
    private Rechnung erzeugteRechnung;

    @Given("der Betreiber möchte eine Rechnung für den Kunden mit der Kundennummer {string} erstellen")
    public void derBetreiberMöchteEineRechnungErstellen(String kundennummer) {
        this.kundennummer = kundennummer;
        Map<String, Konto> konten = new HashMap<>();
        Kunde kunde = new Kunde("Max", "Muster", "max@muster.com", "K1234");
        Konto konto = new Konto(kunde, kundennummer, "passwort");
        konto.addLadevorgang("Ladevorgang 1");
        konto.addLadevorgang("Ladevorgang 2");
        konten.put(kundennummer, konto);

        // KundeManager initialisieren
        kundeManager = new KundeManager(konten);
    }

    @When("der Betreiber erstellt eine Rechnung")
    public void derBetreiberErstelltEineRechnung() {
        // Rechnung für den Kunden erstellen
        erzeugteRechnung = kundeManager.erstelleRechnung(kundennummer);
    }

    @Then("sollte der Betreiber eine Rechnung mit der Kundennummer {string} und dem Betrag {string} sehen")
    public void sollteDerBetreiberEineRechnungSehen(String kundennummer, String betrag) {
        assertThat(erzeugteRechnung).isNotNull();
        assertThat(erzeugteRechnung.getKundennummer()).isEqualTo(kundennummer);
        assertThat(erzeugteRechnung.getBetrag()).isEqualTo(Double.parseDouble(betrag));
    }
}
