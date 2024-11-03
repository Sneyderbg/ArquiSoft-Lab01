Feature: Busqueda de vuelos por nombre de aerolinea

  Scenario: Buscar vuelos de una aerolinea especifica
    Given el usuario se conecta al servicio e ingresa el nombre de la aerolinea JetFly
    When se realiza la busqueda de vuelos por nombre de aerolinea
    Then se muestra una lista de vuelos de JetFly
