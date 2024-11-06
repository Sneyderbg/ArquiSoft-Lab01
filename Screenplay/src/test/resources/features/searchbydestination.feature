# language: es

Característica: Busqueda de vuelos por ciudad de destino

  Escenario: Buscar vuelos hacia una ciudad de destino existente
    Dado el cliente se conecta al servicio
    E ingresa la ciudad de destino "Miami"
    Cuando se realiza la busqueda de vuelos hacia la ciudad especificada
    Entonces se muestra una lista de vuelos que llegan a "Miami"

  Escenario: Buscar vuelos hacia una ciudad de destino sin vuelos
    Dado el cliente se conecta al servicio
    E ingresa la ciudad de destino "CiudadInexistente"
    Cuando se realiza la busqueda de vuelos hacia la ciudad especificada
    Entonces no se muestran vuelos disponibles hacia "CiudadInexistente"
