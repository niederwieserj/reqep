Feature: Kundenrechnungen einsehen
  Der Betreiber möchte alle Rechnungen eines Kunden sehen können.

  Scenario: Betreiber sieht alle Rechnungen eines Kunden
    Given der Betreiber möchte alle Rechnungen des Kunden mit der Kundennummer "K123"
    When der Betreiber ruft alle Rechnungen ab
    Then sollte der Betreiber die Rechnungen "R1" und "R2" sehen
