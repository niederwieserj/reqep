Feature: Ladevorgänge einsehen (Betreiber)

  Scenario: Betreiber sieht Ladevorgänge eines Kunden
    Given der Betreiber möchte die Ladevorgänge des Kunden mit der Kundennummer "K1234" einsehen
    When der Betreiber ruft die Ladevorgänge des Kunden ab
    Then sollte der Betreiber die Ladevorgänge "Ladevorgang 1", "Ladevorgang 2" sehen
