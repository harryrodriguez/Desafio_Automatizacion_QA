@allTest
Feature: Desafio Practico QA Automatizador PreviRed

  Background:
    Given open browser and go to website

    @test1
    Scenario Outline: Desafío_Automatización_QA
      When add "<product_1>" to cart
      When add "<product_2>" to cart
      And click on cart button
      And click on checkout button
      And insert "email" to "login"
      And insert "password" to "login"
      And click on Login button
      And validate "<error_login_message>"
      And Click on continue button to register an Account
      And insert "first_name" to "register"
      And insert "last_name" to "register"
      And insert "email" to "register"
      And insert "phone" to "register"
      And insert "password" to "register"
      And insert "password_confirm" to "register"
      And insert "address" to "register"
      And insert "city" to "register"
      And insert "post_code" to "register"
      And insert "country" to "register"
      And insert "region" to "register"
      And Validate check for delivery and billing is selected
      And check privacy policy
      And click in continue button to delivery details
      And Validate existing address
      And click in continue button to delivery method
      And validate flat rate equals "Flat Shipping Rate - $5.00"
      And click on continue button to Payment Method
      And check terms and conditions
      And click on continue button to confirm order
      And click on Confirm Order button
      Then validate "<order_success>"
      And click on history link
      And validate status "Pending"
      Examples:
        | product_1    | product_2 | error_login_message | order_success |
        | Ipod Classic |  Imac     |         error       |   success     |


      @test2
      Scenario Outline: Punto Extra
        When search for "<product>"
        And select "radio"
        And select "checkbox1"
        And select "checkbox2"
        And insert "text"
        And select "select"
        And insert "textArea"
        And upload the "file"
        And insert "date"
        And insert "time"
        And insert "dateTime"
        And insert "qty"
        And click to add to cart button
        And click on cart button
        And click on checkout button
        And insert "email" to "login"
        And insert "password" to "login"
        And click on Login button
        And click in continue button to delivery details
        And click in continue button to delivery method
        And click on continue button to Payment Method
        And check terms and conditions
        And click on continue button to confirm order
        Then validate "<order_success>"
        Examples:
          | product        | order_success |
          |Apple Cinema 30 |    success    |





