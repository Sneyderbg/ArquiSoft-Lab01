#language: en

Feature: Búsqueda de vuelos por nombre de la aerolínea


  Scenario: Buscar vuelos por nombre de una aerolínea existente
    Given I am connect to capacities of the service
    When se realiza la búsqueda de vuelos por nombre de aerolínea
    Then se muestra una lista de vuelos de "JetFly"
