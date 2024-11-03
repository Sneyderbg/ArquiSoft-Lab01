Feature: Búsqueda de vuelos por precio

  Scenario: Buscar vuelos entre dos precios válidos
    Given un precio inicial "100" y un precio final "500"
    When se realiza la búsqueda de vuelos entre los precios especificados
    Then se muestra una lista de vuelos disponibles dentro del rango de precios

  Scenario: Buscar vuelos cuando no hay vuelos en el rango de precios
    Given un precio inicial "2000" y un precio final "3000"
    When se realiza la búsqueda de vuelos entre los precios especificados
    Then no se muestran vuelos disponibles
