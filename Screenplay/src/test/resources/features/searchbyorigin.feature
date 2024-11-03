Feature: Busqueda de vuelos por ciudad de origen

  Scenario: Buscar vuelos desde una ciudad de origen existente
    Given el usuario se conecta al servicio e ingresa la ciudad de origen "Bogota"
    When se realiza la busqueda de vuelos desde la ciudad especificada
    Then se muestra una lista de vuelos que salen desde "Bogota"

  Scenario: Buscar vuelos desde una ciudad de origen sin vuelos
    Given el usuario se conecta al servicio e ingresa la ciudad de origen "CiudadInexistente"
    When se realiza la busqueda de vuelos desde la ciudad especificada
    Then no se muestran vuelos disponibles desde "CiudadInexistente"
