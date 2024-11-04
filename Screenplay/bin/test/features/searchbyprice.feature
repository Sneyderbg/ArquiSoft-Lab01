Funcionalidad: Búsqueda de vuelos por precio

  Escenario: Buscar vuelos entre dos precios válidos
    Dado el usuario se conecta al servicio e ingresa un precio inicial "100" y un precio final "500"
    Cuando se realiza la búsqueda de vuelos entre los precios especificados
    Entonces se muestra una lista de vuelos disponibles dentro del rango de precios

  Escenario: Buscar vuelos cuando no hay vuelos en el rango de precios
    Dado el usuario se conecta al servicio e ingresa un precio inicial "2000" y un precio final "3000"
    Cuando se realiza la búsqueda de vuelos entre los precios especificados
    Entonces no se muestran vuelos disponibles dentro del rango de precios
