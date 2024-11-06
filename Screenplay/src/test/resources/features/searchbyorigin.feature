# language: es

Característica: Busqueda de vuelos por ciudad de origen

  Escenario: Buscar vuelos desde una ciudad de origen existente
    Dado los clientes se conectan al servicio
    E ingresa la ciudad de origen "Bogota"
    Cuando se realiza la busqueda de vuelos desde la ciudad especificada
    Entonces se muestra una lista de vuelos que salen desde "Bogota"

  Escenario: Buscar vuelos desde una ciudad de origen sin vuelos
    Dado los clientes se conectan al servicio
    E ingresa la ciudad de origen "CiudadInexistente"
    Cuando se realiza la busqueda de vuelos desde la ciudad especificada
    Entonces no se muestran vuelos disponibles desde "CiudadInexistente"
