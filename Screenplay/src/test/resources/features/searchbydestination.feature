# language: es

Característica: Búsqueda de vuelos por ciudad de destino

  Escenario: Buscar vuelos hacia una ciudad de destino existente
    Dado el usuario se conecta al servicio e ingresa la ciudad de destino "Miami"
    Cuando se realiza la búsqueda de vuelos hacia la ciudad especificada
    Entonces se muestra una lista de vuelos que llegan a "Miami"

  Escenario: Buscar vuelos hacia una ciudad de destino sin vuelos
    Dado el usuario se conecta al servicio e ingresa la ciudad de destino "CiudadInexistente"
    Cuando se realiza la búsqueda de vuelos hacia la ciudad especificada
    Entonces no se muestran vuelos disponibles hacia "CiudadInexistente"
