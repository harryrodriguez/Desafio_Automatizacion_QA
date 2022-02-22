
Feature: Probar funcionalidades del sitio opencartabstracta.us

@test
    Scenario Outline: Scenario Outline name: Agregar productos al carrito de compras

        Given navego al sitio web
        When ingreso el <product> en la barra de busqueda
        And agrego producto al carrito
        Then valido que el producto haya sido agregado al carro de compras

        Examples:
            | product      |
            | Ipod Classic |
            | Imac         |

@test
    Scenario: Realizar compra de productos desde el carrito de compras

        Given ingreso al carrito de compras
        When hago click en boton checkout
        And realizo creacion de cuenta y envio de compra
        And ingreso al historial de ordenes
        Then valido los datos de la orden de compra

@test
    Scenario: Punto extra

        Given ingreso el producto extra a la barra de busqueda
        When agrego el producto extra al carrito
        Then valido que el producto extra se encuentre en el carrito


