# Story B15
Feature: B15 Umsätze anzeigen
  Als Betreiber möchte ich Umsätze anzeigen können,
  um zu wissen, wie viel Einnahmen ein Standort innerhalb eines bestimmten Zeitraums generiert hat.

  Scenario: Betreiber sieht den Umsatz eines Standorts für heute
    Given es existieren Rechnungen für den Standort "Wien Mitte"
    When der Betreiber den Umsatz für den Standort "Wien Mitte" für heute abfragt
    Then sollte der Umsatz 80.0 Euro betragen
