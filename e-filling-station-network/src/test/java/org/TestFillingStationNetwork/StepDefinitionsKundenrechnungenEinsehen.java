package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class StepDefinitionsKundenrechnungenEinsehen {

    private Konto konto;
    private KundeManager kundeManager;
    private RechnungsManager rechnungsManager;
    private String kundennummer;
    private List<Rechnung> result;

    @Given("der Betreiber möchte alle Rechnungen des Kunden mit der Kundennummer string}")
    public void der_betreiber_möchte_alle_rechnungen_des_kunden_mit_der_kundennummer(String kundennummer) {

        // Dummy-Kunde erstellen
        Kunde k = new Kunde(
                "Max",
                "Mustermann",
                "max@test.com",
                kundennummer
        );

        // Konto zu diesem Kunden
        konto = new Konto(k, kundennummer, "pw");

        // RechnungsManager initialisieren
        rechnungsManager = new RechnungsManager();

        // KundeManager initialisieren
        kundeManager = new KundeManager();

        // Konto im KundeManager registrieren
        kundeManager.addKunde(k, konto);
    }


    @Given("der Betreiber möchte alle Rechnungen des Kunden mit der Kundennummer {string}")
    public void betreiber_moechte_rechnungen_einsehen(String kundennummer) {

        this.kundennummer = kundennummer;
        rechnungsManager = new RechnungsManager();

        Map<String, Konto> konten = new HashMap<>();
        Kunde k = new Kunde("Max", "Muster", "mail@test.com", kundennummer);
        Konto konto = new Konto(k, kundennummer, "pw");

        // Beispielrechnungen
        Rechnung r1 = new Rechnung("R1", kundennummer, List.of("LV1"), 20.0);
        Rechnung r2 = new Rechnung("R2", kundennummer, List.of("LV2"), 30.0);

        konto.getRechnungen().add(r1);
        konto.getRechnungen().add(r2);

        konten.put(kundennummer, konto);
        kundeManager = new KundeManager(konten);
    }

    @When("der Betreiber ruft alle Rechnungen ab")
    public void betreiber_ruft_alle_rechnungen_ab() {
        Konto konto = kundeManager.getByKundennummer(kundennummer);
        result = rechnungsManager.getRechnungenFuerKunde(konto);
    }

    @Then("sollte der Betreiber die Rechnungen {string} und {string} sehen")
    public void sollte_der_betreiber_die_rechnungen_sehen(String r1, String r2) {
        assertThat(result).isNotNull();
        assertThat(result)
                .extracting("rechnungsnummer")
                .containsExactlyInAnyOrder(r1, r2);
    }
}
