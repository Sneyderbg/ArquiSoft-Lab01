Feature: Busqueda de vuelos por precio

  Scenario: Buscar vuelos entre dos precios validos
    Given el usuario se conecta al servicio e ingresa un precio inicial "100" y un precio final "500"
    When se realiza la busqueda de vuelos entre los precios especificados
    Then se muestra una lista de vuelos disponibles dentro del rango de precios

  Scenario: Buscar vuelos cuando no hay vuelos en el rango de precios
    Given el usuario se conecta al servicio e ingresa un precio inicial "2000" y un precio final "3000"
    When se realiza la busqueda de vuelos entre los precios especificados
    Then no se muestran vuelos disponibles dentro del rango de precios
