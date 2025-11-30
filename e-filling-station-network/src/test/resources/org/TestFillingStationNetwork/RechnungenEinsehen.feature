Feature: Kunde sieht eigene Rechnungen
  Ein Kunde möchte seine in der Vergangenheit erstellten Rechnungen einsehen.

  Scenario: Kunde ruft seine Rechnungen ab
    Given ein Kunde mit Rechnungen existiert
    When der Kunde seine Rechnungen abruft
    Then sollte der Kunde die Rechnungen "R10" und "R20" sehen
