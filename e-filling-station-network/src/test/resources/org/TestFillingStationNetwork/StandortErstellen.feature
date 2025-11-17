Feature: Standorte erstellen

  Scenario: Ladepunkt erstellen


  Scenario: Neuen Standort erstellen
    When der Betreiber einen neuen Standort "Standort 1" erstellt mit ID "0001" an Adresse "Musterstrasse 1, 1010 Wien" und folgenden Ladepunkten
    | LadepunktID | ChargingMode | Status         |
    | LP0001      | AC           | FREE           |
    | LP0002      | DC           | BUSY           |
    | LP0003      | DC           | OUT_OF_ORDER   |
    Then hat der neue Standort "Standort 1" die ID "0001", Adresse "Musterstrasse 1, 1010 Wien" und folgende Ladepunkte
    | LadepunktID | ChargingMode | Status         |
    | LP0001      | AC           | FREE           |
    | LP0002      | DC           | BUSY           |
    | LP0003      | DC           | OUT_OF_ORDER   |
