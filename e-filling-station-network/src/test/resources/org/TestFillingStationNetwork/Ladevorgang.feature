# Story K9 / K10
Feature: Ladevorgang starten und stoppen
  Ein Ladevorgang-Manager soll Ladevorgänge erstellen und verwalten können.
  Beim Starten müssen Modus, Ladepunkt, Kundennummer und Startzeit gesetzt sein.

  Scenario: Ladevorgang erfolgreich starten
    Given ein Ladevorgang-Manager existiert
    When ich einen Ladevorgang starte mit Modus "AC", Ladepunkt "LP01" und Kunde "KND100"
    Then sollte ein Ladevorgang erstellt werden

  Scenario: Ladevorgang enthält korrekte Informationen
    Given ein Ladevorgang-Manager existiert
    When ich einen Ladevorgang starte mit Modus "DC", Ladepunkt "LP09" und Kunde "KND555"
    Then sollte der Ladevorgang den Modus "DC" besitzen
    And sollte der Ladevorgang den Ladepunkt "LP09" enthalten
    And sollte der Ladevorgang dem Kunden "KND555" zugeordnet sein
    And sollte der Startzeitpunkt gesetzt sein

  Scenario: Ladevorgang wird beendet und Endzeit gesetzt
    Given ein Ladevorgang-Manager existiert
    And ich einen Ladevorgang starte mit Modus "AC", Ladepunkt "LP01" und Kunde "KND100"
    When ich den Ladevorgang stoppe
    Then sollte der Endzeitpunkt gesetzt sein
