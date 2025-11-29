Feature: Ladepunkte eines Standorts abrufen
  Um Informationen über die Ladestationen eines Standorts zu erhalten,
  soll der Ladepunkt-Manager alle Ladepunkte eines Standorts zurückgeben.

  Scenario: Standort hat Ladepunkte
    Given ein Ladepunkt-Manager mit Ladepunkten existiert
    When ich die Ladepunkte des Standorts mit der ID "ST1" abfrage
    Then sollten die zurückgegebenen Ladepunkte nicht null sein

  Scenario: Standort hat keine Ladepunkte
    Given ein Ladepunkt-Manager ohne Ladepunkten existiert
    When ich die Ladepunkte des Standorts mit der ID "ST1" abfrage
    Then sollten die zurückgegebenen Ladepunkte nicht null sein

  Scenario: Standort existiert nicht
    Given ein Ladepunkt-Manager mit Ladepunkten existiert
    When ich die Ladepunkte des Standorts mit der ID "UNKNOWN" abfrage
    Then sollten die zurückgegebenen Ladepunkte null sein

  Scenario: Standort hat genau einen verfügbaren Ladepunkt
    Given ein Ladepunkt-Manager mit Ladepunkten existiert
    When ich die verfügbaren Ladepunkte abfrage für Standort "ST1"
    Then gibt es 1 verfügbare Ladepunkte
    And beinhalten die verfügbaren Ladepunkte die ID "LP1"

  Scenario: Standort hat keine verfügbaren Ladepunkte
    Given ein Ladepunkt-Manager ohne Ladepunkten existiert
    When ich die verfügbaren Ladepunkte abfrage für Standort "ST1"
    Then gibt es 0 verfügbare Ladepunkte

  Scenario: Ein verfügbarer Ladepunkt wird nicht falsch eingeschlossen
    Given ein Ladepunkt-Manager mit Ladepunkten existiert
    When ich die verfügbaren Ladepunkte abfrage für Standort "ST1"
    Then beinhalten die verfügbaren Ladepunkte nicht die ID "UNKNOWN"
