# Reto técnico Lulo bank API
Reto para realizar una regresión automatica de la API https://dummyapi.io/.
Proyecto dónde se utilizó el patrón de diseño Screenplay con cucumber y gradle como gestor de dependencias.

## Herramientas necesarias para la ejecución del proyecto

* Java 1.8 o mayor
* Gradle 6.9.3 o mayor

## Pasos para ejecutar el proyecto

* Clonar el repositorio
* Ejecutar en la terminal (raíz del proyecto) "gradle clean test"
* Para realizar ejecuciones paralelas "./gradlew clean test -PmaxParallelForks=2 --tests *GetUserRunner --tests *DeleteUserRunner  aggregate -i"