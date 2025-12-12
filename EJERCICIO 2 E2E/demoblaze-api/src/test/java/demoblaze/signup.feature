Feature: Pruebas de Signup

  Background:
    * url 'https://api.demoblaze.com'

  Escenario1: Crear un nuevo usuario
    Given path 'signup'
    And request { "username": "usuarioNuevo", "password": "Pass123!" }
    When method post
    Then status 200
    And match response == { "message": "#string" }

  Escenariio2: Intentar crear un usuario ya existente
    Given path 'signup'
    And request { "username": "usuarioExistente", "password": "Pass123!" }
    When method post
    Then status 400
    And match response == { "error": "#string" }