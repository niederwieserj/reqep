Feature: Guthaben einsehen (Betreiber)

  Scenario: Betreiber sieht das Guthaben eines Kunden
    Given der Betreiber möchte das Guthaben des Kunden mit der Kundennummer "K1234" einsehen
    When der Betreiber ruft das Guthaben des Kunden ab
    Then sollte der Betreiber das Guthaben "150.0" sehen
