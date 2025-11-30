Feature: Geldaufladungen einsehen
  Ein Kunde möchte sehen, wie viel Geld er aufgeladen hat.

  Scenario: Kunde ruft seine Aufladungen ab
    Given ein Kunde hat Aufladungen durchgeführt
    When der Kunde seine Aufladungen abruft
    Then sollte er die Beträge 50.0 und 20.0 sehen
