package org.TestFillingStationNetwork;

import FillingStationNetwork.*;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitionsKundendatenEinsehen {

    private KundeManager kundeManager;
    private Konto konto;
    private String kundennummer;

    @Given("der Betreiber möchte die Kundendaten des Kunden mit der Kundennummer {string} einsehen")
    public void derBetreiberMöchteDieKundendatenEinsehen(String kundennummer) {
        this.kundennummer = kundennummer;

        // Map und Konto mit der Kundennummer "K1234" anlegen
        Map<String, Konto> konten = new HashMap<>();
        // Jetzt den Konstruktor mit 4 Parametern verwenden
        Kunde kunde = new Kunde("Max", "Muster", "max@muster.com", "K1234");  // Manuelle Kundennummer
        Konto konto = new Konto(kunde, kundennummer, "passwort");
        konten.put(kundennummer, konto);

        // KundeManager mit dem richtigen Konstruktor initialisieren
        kundeManager = new KundeManager(konten);
    }

    @When("der Betreiber ruft die Kundendaten ab")
    public void derBetreiberRuftDieKundendatenAb() {
        // Der Test ruft die Methode auf, um die Kundendaten abzurufen
        // In einem echten Testfall würdest du die Daten hier verifizieren, aber wir speichern sie für den Vergleich
        System.out.println("Kundendaten:");
        kundeManager.zeigeKundendaten(kundennummer);
    }

    @Then("sollte der Betreiber den Namen {string}, die E-Mail {string} und die Kundennummer {string} sehen")
    public void sollteDerBetreiberDieKundendatenSehen(String vorname, String email, String kundennummer) {
        // Abrufen des Kontos, um die Daten zu überprüfen
        Konto konto = kundeManager.getByKundennummer(kundennummer);
        Kunde kunde = konto.getKunde();

        // Verifikationen, dass die Kundendaten korrekt sind
        // Ändere hier den Namen zu Vorname + Nachname
        String fullName = kunde.getVorname() + " " + kunde.getNachname();

        assertThat(fullName).isEqualTo(vorname);  // Jetzt wird der vollständige Name verglichen
        assertThat(kunde.getEmail()).isEqualTo(email);
        assertThat(kunde.getKundennummer()).isEqualTo(kundennummer);
    }
}
