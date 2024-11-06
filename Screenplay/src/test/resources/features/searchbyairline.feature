# language: es

Característica: Busqueda de vuelos por nombre de aerolinea

  Escenario: Buscar vuelos de una aerolinea especifica
    Dado la usuaria se conecta al servicio
    E ingresa el nombre de la aerolinea "JetFly"
    Cuando se realiza la busqueda de vuelos por nombre de aerolinea
    Entonces se muestra una lista de vuelos de "JetFly"
