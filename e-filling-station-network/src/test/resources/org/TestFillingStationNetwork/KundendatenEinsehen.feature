Feature: Kundendaten einsehen (Betreiber)

  Scenario: Betreiber sieht Kundendaten
    Given der Betreiber möchte die Kundendaten des Kunden mit der Kundennummer "K1234" einsehen
    When der Betreiber ruft die Kundendaten ab
    Then sollte der Betreiber den Namen "Max Muster", die E-Mail "max@muster.com" und die Kundennummer "K1234" sehen
