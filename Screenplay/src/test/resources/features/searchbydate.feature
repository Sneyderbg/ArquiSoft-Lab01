Feature: Busqueda de vuelos por fecha

  Scenario: Buscar vuelos entre dos fechas validas
    Given una fecha de inicio 2023-01-01 y una fecha de fin 2024-01-02
    When se realiza la busqueda de vuelos entre las fechas especificadas
    Then se muestra una lista de vuelos disponibles en el rango de fechas


