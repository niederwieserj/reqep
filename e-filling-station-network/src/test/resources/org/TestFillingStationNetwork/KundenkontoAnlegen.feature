Feature: K4 Kundenkonto anlegen
  Als Kunde möchte ich ein Kundenkonto anlegen, um alle nötigen Informationen zu hinterlegen.

  Scenario: Neues Konto erfolgreich anlegen
    Given es existiert kein Kunde mit der E-Mail "a@test.com"
    When der Kunde ein Konto mit folgenden Daten anlegt:
      | Vorname | Nachname | E-Mail      | Passwort |
      | Max     | Muster   | a@test.com  | geheim123 |
    Then wird ein neues Kundenkonto erstellt
    And die Kundennummer des neuen Kunden sollte nicht leer sein

  Scenario: Konto kann nicht angelegt werden, weil E-Mail existiert
    Given es existiert bereits ein Kunde mit der E-Mail "a@test.com"
    When der Kunde ein Konto mit folgenden Daten anlegt:
      | Vorname | Nachname | E-Mail     | Passwort |
      | Max     | Muster   | a@test.com | geheim123 |
    Then wird kein neues Kundenkonto erstellt
