Feature: Búsqueda de vuelos por nombre de la aerolínea

  Scenario: Buscar vuelos por nombre de una aerolínea existente
    Given el nombre de la aerolínea "JetFly"
    When se realiza la búsqueda de vuelos por nombre de aerolínea
    Then se muestra una lista de vuelos de "JetFly"

  Scenario: Buscar vuelos por nombre de una aerolínea que no tiene vuelos
    Given el nombre de la aerolínea "JetFly"
    When se realiza la búsqueda de vuelos por nombre de aerolínea
    Then no se muestran vuelos de "AirlineZ"
