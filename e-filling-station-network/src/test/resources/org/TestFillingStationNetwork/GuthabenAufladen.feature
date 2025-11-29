# Story K6
Feature: Guthaben aufladen
  Das Konto eines Kunden soll aufgeladen werden können.
  Positive Aufladebeträge sollen das Guthaben erhöhen und eine Bewegung erzeugen.
  Negative Beträge sollen ignoriert werden.

  Scenario: Erfolgreiches Aufladen des Kontos
    Given ein Kunde mit Konto und einem Anfangsguthaben von 50.0 Euro existiert
    When ich das Konto um 20.0 Euro auflade
    Then sollte das Guthaben um den Aufladebetrag erhöht werden
    And sollte ein neuer Bewegungsdateneintrag für die Aufladung existieren

  Scenario: Aufladen mit negativem Betrag wird abgelehnt
    Given ein Kunde mit Konto und einem Anfangsguthaben von 30.0 Euro existiert
    When ich versuche das Konto um einen negativen Betrag von -10.0 Euro aufzuladen
    Then sollte das Guthaben unverändert bleiben
    And sollte kein neuer Bewegungsdateneintrag erstellt werden

  Scenario: Aufladen mit Nullbetrag
    Given ein Kunde mit Konto und einem Anfangsguthaben von 100.0 Euro existiert
    When ich versuche das Konto um einen negativen Betrag von 0.0 Euro aufzuladen
    Then sollte das Guthaben unverändert bleiben
    And sollte kein neuer Bewegungsdateneintrag erstellt werden
