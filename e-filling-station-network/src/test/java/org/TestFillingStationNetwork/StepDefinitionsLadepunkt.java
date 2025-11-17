package org.TestFillingStationNetwork;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.*;

import FillingStationNetwork.*;
import FillingStationNetwork.Ladepunkt.*;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitionsLadepunkt {
    @When("der Betreiber einen neuen Ladepunkt erstellt mit ID {string}, Charging Mode {string} und Status {string}")
    public void WennBetreiberLadepunktErstellt(String ladepunktId, String chargingMode, String status) {
        
    }
}
