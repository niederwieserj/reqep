package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class StepDefinitionsGeldaufladungenEinsehen {

    private KundeManager km;
    private Konto konto;
    private List<Aufladung> result;

    @Given("ein Kunde hat Aufladungen durchgeführt")
    public void kunde_hat_aufladungen() {

        Map<String, Konto> konten = new HashMap<>();
        Kunde k = new Kunde("Max", "Auflader", "max@load.at", "K777");

        konto = new Konto(k, "K777", "pw");
        konto.addAufladung(50);
        konto.addAufladung(20);

        konten.put("K777", konto);
        km = new KundeManager(konten);
    }

    @When("der Kunde seine Aufladungen abruft")
    public void kunde_ruft_aufladungen_ab() {
        result = km.getAufladungen("K777");
    }

    @Then("sollte er die Beträge {double} und {double} sehen")
    public void sollte_er_betraege_sehen(double b1, double b2) {
        assertThat(result).extracting("betrag")
                .containsExactlyInAnyOrder(b1, b2);
    }
}
