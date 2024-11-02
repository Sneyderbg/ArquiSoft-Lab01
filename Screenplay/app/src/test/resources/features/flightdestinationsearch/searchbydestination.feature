Feature: Búsqueda de vuelos por ciudad de destino

  Scenario: Buscar vuelos hacia una ciudad de destino existente
    Given la ciudad de destino "Medellín"
    When se realiza la búsqueda de vuelos hacia la ciudad especificada
    Then se muestra una lista de vuelos que llegan a "Medellín"

  Scenario: Buscar vuelos hacia una ciudad de destino sin vuelos
    Given la ciudad de destino "CiudadInexistente"
    When se realiza la búsqueda de vuelos hacia la ciudad especificada
    Then no se muestran vuelos disponibles hacia "CiudadInexistente"
