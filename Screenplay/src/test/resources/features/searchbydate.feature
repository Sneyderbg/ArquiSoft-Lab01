# language: es

Característica: Busqueda de vuelos por fecha

  Escenario: Buscar vuelos entre dos fechas válidas
    Dado el usuario se conecta al servicio
    E ingresa una fecha de inicio "2023-01-01" y una fecha de fin "2024-01-02"
    Cuando se realiza la busqueda de vuelos entre las fechas especificadas
    Entonces se muestra una lista de vuelos disponibles en el rango de fechas

  Escenario: Buscar vuelos cuando no hay vuelos en el rango de fechas
    Dado el usuario se conecta al servicio
    E ingresa una fecha de inicio "2023-01-01" y una fecha de fin "2023-01-02"
    Cuando se realiza la busqueda de vuelos entre las fechas especificadas
    Entonces no se muestran vuelos disponibles
