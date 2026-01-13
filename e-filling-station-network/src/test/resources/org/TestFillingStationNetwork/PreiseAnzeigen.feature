# Story K3
Feature: K3 Preise anzeigen
  Als Kunde möchte ich die Preise der Standorte sehen,
  um den günstigsten Ladepreis zu finden.

  Scenario: Kunde sieht alle Preise der Standorte mit aktivem Tarif
    Given es existieren folgende Standorte mit Tarifen:
      | standortId | name         | preisProKwh | preisProMinute |
      | S1         | Wien Mitte   | 0.45        | 0.10           |
      | S2         | Hauptbahnhof | 0.39        | 0.12           |
    When der Kunde die Preisübersicht aller Standorte abruft
    Then sollte die Preisübersicht 2 Einträge enthalten
    And sollte der günstigste Preis pro kWh 0.39 sein
