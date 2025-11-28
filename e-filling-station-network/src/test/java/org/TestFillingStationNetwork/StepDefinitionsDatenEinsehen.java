package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class StepDefinitionsDatenEinsehen {

    private KundeManager kundeManager;
    private Konto konto;
    private String kundennummer;

    @Given("der Betreiber möchte die Guthaben- und Bewegungsdaten des Kunden mit der Kundennummer {string} einsehen")
    public void derBetreiberMöchteDieKundendatenEinsehen(String kundennummer) {
        this.kundennummer = kundennummer;

        // Map und Konto mit der Kundennummer "K1234" anlegen
        Map<String, Konto> konten = new HashMap<>();
        Kunde kunde = new Kunde("Max", "Muster", "max@muster.com", "K1234");
        Konto konto = new Konto(kunde, kundennummer, "passwort");
        konto.setGuthaben(100.0); // Guthaben auf 100 setzen
        konto.addBewegung("Zahlung: 50 Euro"); // Beispiel für eine Transaktion
        konto.addBewegung("Zahlung: 20 Euro");
        konten.put(kundennummer, konto);

        // KundeManager initialisieren
        kundeManager = new KundeManager(konten);
    }

    @When("der Betreiber ruft die Guthaben- und Bewegungsdaten des Kunden ab")
    public void derBetreiberRuftDieKundendatenAb() {
        // Guthaben und Bewegungsdaten des Kunden abrufen
        kundeManager.zeigeKundendaten(kundennummer);
    }

    @Then("sollte der Betreiber den Namen {string}, die E-Mail {string}, die Kundennummer {string}, das Guthaben {string} und die Bewegungsdaten sehen")
    public void sollteDerBetreiberDieKundendatenSehen(String vorname, String email, String kundennummer, String guthaben) {
        Konto konto = kundeManager.getByKundennummer(kundennummer);
        Kunde kunde = konto.getKunde();

        // Verifikationen, dass die Kundendaten korrekt sind
        String fullName = kunde.getVorname() + " " + kunde.getNachname();
        assertThat(fullName).isEqualTo(vorname);
        assertThat(kunde.getEmail()).isEqualTo(email);
        assertThat(kunde.getKundennummer()).isEqualTo(kundennummer);
        assertThat(konto.getGuthaben()).isEqualTo(Double.parseDouble(guthaben)); // Guthaben überprüfen
    }
}
