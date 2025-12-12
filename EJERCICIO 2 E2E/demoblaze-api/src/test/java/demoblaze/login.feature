Feature: Pruebas de Login

  Background:
    * url 'https://api.demoblaze.com'

  Escenario1: Usuario y password correcto
    Given path 'login'
    And request { "username": "usuarioExistente", "password": "Pass123!" }
    When method post
    Then status 200
    And match response == { "message": "#string" }

  Escenario2: Usuario y password incorrecto
    Given path 'login'
    And request { "username": "usuarioExistente", "password": "PassIncorrecta" }
    When method post
    Then status 401
    And match response == { "error": "#string" }
