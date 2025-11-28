package org.TestFillingStationNetwork;

import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;
import FillingStationNetwork.*;

public class StepDefinitionsAdmin {

    private Admin admin;
    private boolean loginErfolgreich;

    @Given("der Admin hat den Benutzernamen {string} und das Passwort {string}")
    public void derAdminHatDenBenutzernamenUndDasPasswort(String benutzername, String passwort) {
        // Admin mit den angegebenen Login-Daten erstellen
        admin = new Admin(benutzername, passwort);
    }

    @When("der Admin versucht sich mit den folgenden Anmeldedaten einzuloggen:")
    public void derAdminVersuchtSichMitDenFolgendenAnmeldedatenEinzuloggen(io.cucumber.datatable.DataTable table) {
        // Extrahiert den Benutzernamen und das Passwort aus der DataTable
        String benutzername = table.asMaps(String.class, String.class).get(0).get("Benutzername");
        String passwort = table.asMaps(String.class, String.class).get(0).get("Passwort");

        // Speichert das Ergebnis des Logins
        loginErfolgreich = admin.login(benutzername, passwort);  // Login wird ausgeführt und Ergebnis gespeichert
    }

    @Then("sollte der Login erfolgreich sein")
    public void sollteDerLoginErfolgreichSein() {
        // Überprüft, dass der Login erfolgreich war
        assertThat(loginErfolgreich).isTrue();
    }

    @Then("sollte der Login fehlschlagen")
    public void sollteDerLoginFehlschlagen() {
        // Überprüft, dass der Login fehlgeschlagen ist
        assertThat(loginErfolgreich).isFalse();
    }
}
