Feature: Standorte erstellen

  Scenario: Ladepunkt erstellen
    When der Betreiber einen neuen Ladepunkt erstellt mit ID LP-0001, Charging Mode AC und Status FREE
    Then hat der neue Ladepunkt die ID LP-0001, Charging Mode AC und Status FREE
    And ist Ladepunkt available

  Scenario: Ladepunktstatus setzen
    When der Betreiber einen neuen Ladepunkt erstellt mit ID LP-0001, Charging Mode AC und Status FREE
    And der Betreiber den Ladepunkt-Status auf BUSY setzt
    Then ist Ladepunkt nicht available
    When der Betreiber den Ladepunkt-Status auf OUT_OF_ORDER setzt
    Then ist Ladepunkt nicht available
    When der Betreiber den Ladepunkt-Status auf FREE setzt
    Then ist Ladepunkt available

  Scenario: Neuen Standort erstellen
    When der Betreiber einen neuen Standort "Standort 1" erstellt mit ID SID-0001 an Adresse "Musterstrasse 1, 1010 Wien" und folgenden Ladepunkten
    | LadepunktID | ChargingMode | Status         |
    | LP0001      | AC           | FREE           |
    | LP0002      | DC           | BUSY           |
    | LP0003      | DC           | OUT_OF_ORDER   |
    Then hat der neue Standort "Standort 1" die ID SID-0001, Adresse "Musterstrasse 1, 1010 Wien" und folgende Ladepunkte
    | LadepunktID | ChargingMode | Status         |
    | LP0001      | AC           | FREE           |
    | LP0002      | DC           | BUSY           |
    | LP0003      | DC           | OUT_OF_ORDER   |
