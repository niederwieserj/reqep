package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitionsLadevorgaengeEinsehen {

    private KundeManager kundeManager;
    private String kundennummer;

    @Given("der Betreiber möchte die Ladevorgänge des Kunden mit der Kundennummer {string} einsehen")
    public void derBetreiberMöchteDieLadevorgaengeEinsehen(String kundennummer) {
        this.kundennummer = kundennummer;

        // Map und Konto mit der Kundennummer "K1234" anlegen
        Map<String, Konto> konten = new HashMap<>();
        Kunde kunde = new Kunde("Max", "Muster", "max@muster.com", "K1234");
        Konto konto = new Konto(kunde, kundennummer, "passwort");
        konto.addLadevorgang("Ladevorgang 1");
        konto.addLadevorgang("Ladevorgang 2");
        konten.put(kundennummer, konto);

        // KundeManager initialisieren
        kundeManager = new KundeManager(konten);
    }

    @When("der Betreiber ruft die Ladevorgänge des Kunden ab")
    public void derBetreiberRuftDieLadevorgaengeAb() {
        // Ladevorgänge des Kunden abrufen
        kundeManager.zeigeLadevorgaenge(kundennummer);
    }

    @Then("sollte der Betreiber die Ladevorgänge {string}, {string} sehen")
    public void sollteDerBetreiberDieLadevorgaengeSehen(String ladevorgang1, String ladevorgang2) {
        Konto konto = kundeManager.getByKundennummer(kundennummer);
        String[] ladevorgaenge = konto.getLadevorgaenge();

        // Verifikationen, dass die Ladevorgänge korrekt sind
        assertThat(ladevorgaenge[0]).isEqualTo(ladevorgang1);
        assertThat(ladevorgaenge[1]).isEqualTo(ladevorgang2);
    }
}
