# Story B7
Feature: Preise festlegen
  Als Betreiber möchte ich für jeden Standort individuelle Preise festlegen,
  um flexibel auf Marktbedingungen reagieren zu können.

  Scenario: Betreiber legt Preise für einen Standort fest
    Given ein Standort für das Festlegen von Preisen mit der ID "S-01" existiert
    When der Betreiber für diesen Standort den Preis pro kWh 0.5 und den Preis pro Minute 0.2 festlegt
    Then sollte der aktive Tarif des Standorts den Preis pro kWh 0.5 und den Preis pro Minute 0.2 haben
