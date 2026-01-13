# Story B10
Feature: Guthaben und Bewegungsdaten einsehen (Betreiber)

  Scenario: Betreiber sieht Guthaben und Bewegungsdaten eines Kunden
    Given der Betreiber möchte die Guthaben- und Bewegungsdaten des Kunden mit der Kundennummer "K1234" einsehen
    When der Betreiber ruft die Guthaben- und Bewegungsdaten des Kunden ab
    Then sollte der Betreiber den Namen "Max Muster", die E-Mail "max@muster.com", die Kundennummer "K1234", das Guthaben "100.0" und die Bewegungsdaten sehen
