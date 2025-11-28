Feature: Admin einloggen

  Scenario: Admin loggt sich erfolgreich ein
    Given der Admin hat den Benutzernamen "admin" und das Passwort "admin123"
    When der Admin versucht sich mit den folgenden Anmeldedaten einzuloggen:
      | Benutzername | Passwort   |
      | admin        | admin123   |
    Then sollte der Login erfolgreich sein

  Scenario: Admin login schlägt fehl
    Given der Admin hat den Benutzernamen "admin" und das Passwort "admin123"
    When der Admin versucht sich mit den folgenden Anmeldedaten einzuloggen:
      | Benutzername | Passwort   |
      | admin        | falschespw |
    Then sollte der Login fehlschlagen
