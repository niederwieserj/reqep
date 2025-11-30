# Story K11
Feature: Ladevorgang beenden
  Als Kunde möchte ich den Ladevorgang vorzeitig beenden,
  um einen anderen freien Ladepunkt nutzen zu können.

  Scenario: Kunde beendet den Ladevorgang vorzeitig
    Given ein Ladevorgang-Manager existiert
    When ich einen Ladevorgang starte mit Modus "AC", Ladepunkt "LP01" und Kunde "KND100"
    And ich den Ladevorgang stoppe
    Then sollte der Endzeitpunkt gesetzt sein

  Scenario: Kunde kann nach dem Beenden einen anderen Ladepunkt nutzen
    Given ein Ladevorgang-Manager existiert
    When ich einen Ladevorgang starte mit Modus "AC", Ladepunkt "LP01" und Kunde "KND100"
    And ich den Ladevorgang stoppe
    And ich einen Ladevorgang starte mit Modus "DC", Ladepunkt "LP02" und Kunde "KND100"
    Then sollte der Ladevorgang den Ladepunkt "LP02" enthalten
