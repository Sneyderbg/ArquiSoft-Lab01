#language: en

Feature: Busqueda de vuelos por nombre de la aerolinea

  Scenario: Buscar vuelos por nombre de una aerolinea existente
    Given el nombre de la aerolinea JetFly
    When se realiza la busqueda de vuelos por nombre de aerolinea
    Then se muestra una lista de vuelos de JetFly
