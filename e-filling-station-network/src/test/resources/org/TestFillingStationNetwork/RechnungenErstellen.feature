Feature: Rechnungen erstellen (Betreiber)

  Scenario: Betreiber erstellt eine Rechnung für einen Kunden
    Given der Betreiber möchte eine Rechnung für den Kunden mit der Kundennummer "K1234" erstellen
    When der Betreiber erstellt eine Rechnung
    Then sollte der Betreiber eine Rechnung mit der Kundennummer "K1234" und dem Betrag "40.0" sehen
