package org.TestFillingStationNetwork;

import FillingStationNetwork.Ladepunkt;
import FillingStationNetwork.Standort;
import FillingStationNetwork.StandortManager;
import FillingStationNetwork.TarifVersion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitionsPreiseAnzeigen {

    private StandortManager standortManager;
    private ArrayList<Standort> result;

    @Given("es existieren folgende Standorte mit Tarifen:")
    public void es_existieren_folgende_standorte_mit_tarifen(DataTable dataTable) {

        standortManager = new StandortManager();

        List<List<String>> rows = dataTable.asLists(String.class);
        // Zeile 0 = Header, daher ab 1
        for (int i = 1; i < rows.size(); i++) {
            List<String> row = rows.get(i);

            String standortId = row.get(0);
            String name = row.get(1);
            double preisProKwh = Double.parseDouble(row.get(2));
            double preisProMinute = Double.parseDouble(row.get(3));

            ArrayList<Ladepunkt> ladepunkte = new ArrayList<>();
            Standort standort = new Standort(
                    standortId,
                    name,
                    "Adresse egal",
                    ladepunkte,
                    "Beschreibung"
            );

            TarifVersion tarif = new TarifVersion(preisProKwh, preisProMinute);
            standort.SetActiveTarifVersion(tarif);

            standortManager.AddStandort(standort);
        }
    }

    @When("der Kunde die Preisübersicht aller Standorte abruft")
    public void der_kunde_die_preisuebersicht_aller_standorte_abruft() {
        result = standortManager.GetStandorteMitAktivemTarif();
    }

    @Then("sollte die Preisübersicht {int} Einträge enthalten")
    public void sollte_die_preisuebersicht_eintraege_enthalten(Integer expectedCount) {
        assertThat(result.size()).isEqualTo(expectedCount);
    }

    @Then("sollte der günstigste Preis pro kWh {double} sein")
    public void sollte_der_guenstigste_preis_pro_kwh_sein(double expectedLowest) {
        double min = result.stream()
                .map(s -> s.GetActiveTarifVersion().getPreisProKwh())
                .min(Double::compareTo)
                .orElse(Double.MAX_VALUE);

        assertThat(min).isEqualTo(expectedLowest);
    }
}
