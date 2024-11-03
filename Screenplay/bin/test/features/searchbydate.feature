Feature: Búsqueda de vuelos por fecha

  Scenario: Buscar vuelos entre dos fechas válidas
    Given una fecha de inicio "2024-12-01" y una fecha de fin "2024-12-31"
    When se realiza la búsqueda de vuelos entre las fechas especificadas
    Then se muestra una lista de vuelos disponibles en el rango de fechas

  Scenario: Buscar vuelos cuando no hay vuelos en el rango de fechas
    Given una fecha de inicio "2023-01-01" y una fecha de fin "2023-01-02"
    When se realiza la búsqueda de vuelos entre las fechas especificadas
    Then no se muestran vuelos disponibles
