Feature: Rechnungsdetails einsehen
  Ein Kunde möchte Details zu einer Rechnung einsehen.

  Scenario: Kunde öffnet eine Rechnung und sieht Details
    Given ein Kunde hat eine Rechnung mit Details
    When der Kunde die Rechnungsdetails zur Rechnungsnummer "R500" abruft
    Then sollte er den Standort "Wien Mitte", Ladepunkt "LP-11" und Preis 60.0 sehen
