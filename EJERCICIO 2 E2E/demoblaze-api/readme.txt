 Prueba de APIs Demoblaze con Karate

 Tecnologias
- Java JDK 11
- Maven 3.8+
- Karate 1.3.1

 Estructura del proyecto
demoblaze-api/
	pom.xml
	src/test/java/demoblaze/
		signup.feature
		login.feature
	readme.txt
	conclusiones.txt

--- Ejecución ---
1. Clonar el repositorio.
2. Ejecutar los tests con Maven:
   mvn test
3. Los reportes se generan en:
   target/karate-reports/karate-summary.html
