Feature: Crear ordenes en la tienda PetStore

@createOrder
  Scenario Outline: Crear una orden
    Given tengo el URL del API de la tienda PetStore
    When creo una orden con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>" y status "<status>"
    Then el código de respuesta es <codigoStatus>
    And el cuerpo de la respuesta contiene el id y status no nulos

    Examples:
      | id  | petId | quantity | shipDate               | status   | codigoStatus |
      | 1   | 1     | 10       | 2025-10-04T21:42:56Z   | placed   | 200          |