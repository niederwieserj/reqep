# Story K15
Feature: Rechnungen filtern
  Ein Kunde möchte seine Rechnungen nach Standort filtern können.

  Scenario: Kunde filtert seine Rechnungen nach Standort
    Given ein Kunde hat mehrere Rechnungen an verschiedenen Standorten
    When der Kunde nach Standort "Wien" filtert
    Then sollte er nur die Rechnung "R100" sehen
