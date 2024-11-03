Feature: Búsqueda de vuelos por ciudad de origen

  Scenario: Buscar vuelos desde una ciudad de origen existente
    Given la ciudad de origen "Bogotá"
    When se realiza la búsqueda de vuelos desde la ciudad especificada
    Then se muestra una lista de vuelos que salen desde "Bogotá"

  Scenario: Buscar vuelos desde una ciudad de origen sin vuelos
    Given la ciudad de origen "CiudadInexistente"
    When se realiza la búsqueda de vuelos desde la ciudad especificada
    Then no se muestran vuelos disponibles desde "CiudadInexistente"
