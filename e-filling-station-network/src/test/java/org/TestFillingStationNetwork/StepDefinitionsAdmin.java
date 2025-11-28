package org.TestFillingStationNetwork;

import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.*;

import FillingStationNetwork.*;

public class StepDefinitionsAdmin {

    private Admin admin;

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

        // Prüft, ob der Login erfolgreich ist
        boolean loginErfolgreich = admin.login(benutzername, passwort);

        // Überprüft, ob der Login erfolgreich oder fehlgeschlagen ist
        if (loginErfolgreich) {
            System.out.println("Login erfolgreich");
        } else {
            System.out.println("Login fehlgeschlagen");
        }
    }

    @Then("sollte der Login erfolgreich sein")
    public void sollteDerLoginErfolgreichSein() {
        // Überprüft, dass der Login erfolgreich war
        assertThat(admin.login("admin", "admin123")).isTrue();
    }

    @Then("sollte der Login fehlschlagen")
    public void sollteDerLoginFehlschlagen() {
        // Überprüft, dass der Login fehlgeschlagen ist
        assertThat(admin.login("admin", "falschespw")).isFalse();
    }
}
