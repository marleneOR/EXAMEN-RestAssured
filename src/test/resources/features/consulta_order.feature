Feature: Consulta de ordenes en la tienda PetStore
  @consultarOrden
  Scenario Outline: Consulta de orden por id
    Given estoy en la pagina de PetStore
    When hago consulta de la orden por id <idOrden>
    Then el codigo de respuesta del orden es <statusCode>
    Examples:
      | idOrden   | statusCode |
      | 1         |  200       |
      | 2         |  200       |
      | 2588555   |  404       |