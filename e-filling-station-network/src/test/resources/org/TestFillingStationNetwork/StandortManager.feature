# Story K1
Feature: Verwaltung von Standorten
  Der Standort-Manager soll Standorte hinzufügen, abrufen und verwalten können.

  Scenario: Ein einzelner Standort wird hinzugefügt und erfolgreich abgerufen
    Given ein Standort-Manager existiert
    When ich einen Standort mit der ID "S1" hinzufüge
    And ich den Standort mit der ID "S1" abfrage
    Then sollte der zurückgegebene Standort nicht null sein
    And sollte die Standort-ID "S1" sein
    And sollte die Anzahl der Standorte 1 sein

  Scenario: Zwei Standorte werden hinzugefügt und einer davon wird abgerufen
    Given ein Standort-Manager existiert
    When ich einen Standort mit der ID "S1" hinzufüge
    And ich einen Standort mit der ID "S2" hinzufüge
    And ich den Standort mit der ID "S2" abfrage
    Then sollte der zurückgegebene Standort nicht null sein
    And sollte die Standort-ID "S2" sein
    And sollte die Anzahl der Standorte 2 sein

  Scenario: Abruf eines nicht vorhandenen Standortes
    Given ein Standort-Manager existiert
    When ich einen Standort mit der ID "S1" hinzufüge
    And ich den Standort mit der ID "S999" abfrage
    Then sollte der zurückgegebene Standort null sein

  Scenario: Mehrere Standorte hinzufügen
    Given ein Standort-Manager existiert
    When ich einen Standort mit der ID "A1" hinzufüge
    And ich einen Standort mit der ID "B2" hinzufüge
    And ich einen Standort mit der ID "C3" hinzufüge
    Then sollte die Anzahl der Standorte 3 sein
