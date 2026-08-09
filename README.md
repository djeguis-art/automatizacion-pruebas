# \# Automatización de Pruebas

# 

# \## Descripción del proyecto

# 

# Este proyecto fue desarrollado con el propósito de implementar un flujo básico de automatización de pruebas para una aplicación Java, incorporando prácticas utilizadas en ambientes de desarrollo.

# 

# El trabajo considera control de versiones mediante Git, administración de dependencias con Maven, pruebas unitarias con JUnit 5 e integración continua mediante GitHub Actions. Además, se incorporó la generación de un reporte HTML con los resultados de las pruebas, permitiendo que estos sean consultados por el equipo desde cada ejecución del pipeline.

# 

# Para disponer de una funcionalidad simple y verificable se implementó un servicio básico de autenticación de usuarios denominado `LoginService`.

# 

# \---

# 

# \## Objetivo

# 

# El objetivo principal es demostrar cómo un proyecto Java puede incorporar pruebas automatizadas dentro de un proceso de Integración Continua (CI), permitiendo validar los cambios realizados en el código antes de incorporarlos a las ramas principales del proyecto.

# 

# La solución busca mantener un proceso de desarrollo ordenado, trazable y repetible, donde cada cambio pueda ser identificado mediante Git y validado automáticamente mediante Maven, JUnit y GitHub Actions.

# 

# \---

# 

# \## Tecnologías utilizadas

# 

# \- Java 21

# \- Apache Maven 3.9.16

# \- JUnit 5

# \- Git

# \- GitHub

# \- GitHub Actions

# \- Maven Surefire

# \- Maven Surefire Report Plugin

# 

# \---

# 

# \## Estructura del proyecto

# 

# La estructura principal utilizada es la siguiente:

# 

# ```text

# automatizacion-pruebas/

# │

# ├── .github/

# │   └── workflows/

# │       └── ci.yml

# │

# ├── src/

# │   ├── main/

# │   │   └── java/

# │   │       └── cl/

# │   │           └── automatizacion/

# │   │               └── service/

# │   │                   └── LoginService.java

# │   │

# │   └── test/

# │       └── java/

# │           └── cl/

# │               └── automatizacion/

# │                   └── service/

# │                       ├── LoginExitosoTest.java

# │                       └── LoginCredencialesInvalidasTest.java

# │

# ├── .gitignore

# ├── pom.xml

# └── README.md

# ```

# 

# La carpeta `src/main/java` contiene el código principal de la aplicación, mientras que `src/test/java` concentra las pruebas automatizadas. Esta separación permite mantener una estructura clara y acorde con la organización estándar utilizada por Maven.

# 

# \---

# 

# \## Control de versiones con Git

# 

# Para mantener la trazabilidad del proyecto se utilizó Git como sistema de control de versiones.

# 

# Se trabajó con una rama principal `main`, una rama de integración `develop` y distintas ramas de trabajo para incorporar funcionalidades de manera independiente.

# 

# Entre las ramas utilizadas durante el desarrollo se encuentran:

# 

# ```text

# main

# develop

# feature/configuracion-maven

# feature/pruebas-unitarias

# feature/pipeline-ci

# feature/reporte-tests

# ```

# 

# Los cambios fueron registrados mediante commits pequeños y descriptivos. Algunos ejemplos son:

# 

# ```text

# docs: Inicializa documentacion del proyecto

# build: configura proyecto maven y JUnit

# test: agrega pruebas unitarias de autenticacion

# ci: configura pipeline de integracion continua

# ci: agrega reporte HTML de pruebas como artefacto

# fix: corrige indentacion del workflow de reportes

# ```

# 

# Esta estrategia facilita la identificación de los cambios realizados y permite mantener un historial comprensible del desarrollo.

# 

# \---

# 

# \## Integración Continua

# 

# La Integración Continua (CI) permite integrar y validar frecuentemente los cambios realizados sobre el código fuente.

# 

# En este proyecto se configuró GitHub Actions para ejecutar automáticamente el proceso de compilación y las pruebas cuando se realizan cambios sobre las ramas principales de desarrollo.

# 

# El flujo implementado es:

# 

# ```text

# Push o Pull Request

# &#x20;       ↓

# GitHub Actions

# &#x20;       ↓

# Descarga del código fuente

# &#x20;       ↓

# Configuración de Java 21

# &#x20;       ↓

# Maven

# &#x20;       ↓

# Compilación

# &#x20;       ↓

# Ejecución de pruebas JUnit

# &#x20;       ↓

# Generación del reporte HTML

# &#x20;       ↓

# Publicación del reporte como Artifact

# &#x20;       ↓

# Resultado SUCCESS o FAILURE

# ```

# 

# De esta manera, un cambio que provoque un error en las pruebas puede ser detectado antes de integrarse definitivamente al proyecto.

# 

# \---

# 

# \## Configuración de Maven

# 

# Maven se utiliza para administrar las dependencias y automatizar la construcción del proyecto.

# 

# La configuración principal se encuentra en:

# 

# ```text

# pom.xml

# ```

# 

# Dentro de este archivo se definieron Java 21 y las dependencias necesarias para ejecutar las pruebas con JUnit 5.

# 

# También se configuraron los plugins Maven Surefire y Maven Surefire Report Plugin, utilizados respectivamente para ejecutar las pruebas y generar el reporte HTML con sus resultados.

# 

# Para comprobar la instalación de Maven se puede utilizar:

# 

# ```bash

# mvn -version

# ```

# 

# \---

# 

# \## Pruebas unitarias

# 

# Para demostrar la automatización se implementó un servicio simple de autenticación denominado:

# 

# ```text

# LoginService.java

# ```

# 

# El servicio permite validar un usuario y contraseña definidos para fines académicos.

# 

# Sobre esta funcionalidad se implementaron dos pruebas unitarias independientes:

# 

# \### LoginExitosoTest

# 

# Valida que el sistema permita el acceso cuando se ingresan credenciales válidas.

# 

# ```text

# Usuario válido + contraseña válida

# &#x20;             ↓

# &#x20;      Acceso permitido

# ```

# 

# \### LoginCredencialesInvalidasTest

# 

# Valida que el sistema rechace el acceso cuando la contraseña ingresada es incorrecta.

# 

# ```text

# Usuario válido + contraseña incorrecta

# &#x20;                ↓

# &#x20;         Acceso rechazado

# ```

# 

# \---

# 

# \## Atomicidad de las pruebas

# 

# Las pruebas fueron diseñadas para verificar un único comportamiento cada una.

# 

# `LoginExitosoTest` comprueba exclusivamente el acceso correcto, mientras que `LoginCredencialesInvalidasTest` valida el rechazo de credenciales incorrectas.

# 

# Esta separación facilita la identificación de errores y evita dependencias innecesarias entre los casos de prueba. Además, permite ejecutar cada test de manera aislada y repetible.

# 

# \---

# 

# \## Ejecución local de las pruebas

# 

# Para ejecutar las pruebas desde la raíz del proyecto se utiliza:

# 

# ```bash

# mvn clean test

# ```

# 

# La ejecución actual obtiene el siguiente resultado:

# 

# ```text

# Tests run: 2

# Failures: 0

# Errors: 0

# Skipped: 0

# 

# BUILD SUCCESS

# ```

# 

# Esto confirma que ambas pruebas unitarias finalizaron correctamente.

# 

# \---

# 

# \## Generación del reporte HTML

# 

# Para ejecutar las pruebas y generar posteriormente el reporte navegable se utiliza:

# 

# ```bash

# mvn clean test surefire-report:report-only

# ```

# 

# El reporte generado se encuentra en:

# 

# ```text

# target/reports/surefire.html

# ```

# 

# El informe permite consultar información como:

# 

# ```text

# Tests:        2

# Errors:       0

# Failures:     0

# Skipped:      0

# Success Rate: 100 %

# ```

# 

# Además, permite acceder al detalle de cada clase y caso de prueba ejecutado.

# 

# \---

# 

# \## Pipeline de GitHub Actions

# 

# La configuración del pipeline se encuentra en:

# 

# ```text

# .github/workflows/ci.yml

# ```

# 

# El workflow se ejecuta ante eventos `push` y `pull\_request` dirigidos a las ramas `main` y `develop`.

# 

# Durante su ejecución se realizan las siguientes acciones:

# 

# ```text

# Descargar código fuente

# Configurar Java 21

# Ejecutar Maven

# Ejecutar pruebas JUnit

# Generar reporte HTML

# Publicar reporte como Artifact

# ```

# 

# Si alguna prueba falla, GitHub Actions identifica la ejecución como fallida, permitiendo detectar el problema antes de integrar los cambios.

# 

# \---

# 

# \## Reporte accesible para el equipo

# 

# Luego de cada ejecución exitosa del pipeline, GitHub Actions publica el reporte generado bajo el nombre:

# 

# ```text

# reporte-pruebas-junit

# ```

# 

# El archivo queda disponible en la sección `Artifacts` de la ejecución correspondiente.

# 

# Esto permite que los integrantes del proyecto puedan acceder a los resultados de las pruebas sin necesidad de ejecutar Maven localmente en sus computadores.

# 

# \---

# 

# \## Archivo .gitignore

# 

# El proyecto utiliza un archivo `.gitignore` para evitar que archivos generados automáticamente sean incorporados al repositorio.

# 

# Entre ellos se encuentra:

# 

# ```text

# target/

# ```

# 

# Esta carpeta es creada por Maven durante los procesos de compilación, ejecución de pruebas y generación de reportes, por lo que no corresponde mantenerla dentro del control de versiones.

# 

# También se excluyen archivos temporales y configuraciones propias de distintos entornos de desarrollo.

# 

# \---

# 

# \## Flujo de trabajo utilizado

# 

# Durante el desarrollo se utilizó un flujo basado en ramas:

# 

# ```text

# develop

# &#x20;  │

# &#x20;  ├── feature/configuracion-maven

# &#x20;  │

# &#x20;  ├── feature/pruebas-unitarias

# &#x20;  │

# &#x20;  ├── feature/pipeline-ci

# &#x20;  │

# &#x20;  └── feature/reporte-tests

# ```

# 

# Una vez finalizado y validado un cambio, este se incorpora a `develop`.

# 

# Para los cambios relacionados con el pipeline se utilizaron Pull Requests, permitiendo que GitHub Actions ejecutara automáticamente las pruebas antes de realizar el merge.

# 

# \---

# 

# \## Resultados obtenidos

# 

# La implementación realizada permitió obtener un flujo funcional de automatización en el que los cambios del proyecto quedan registrados mediante Git y posteriormente son validados por un pipeline de Integración Continua.

# 

# Las pruebas unitarias se ejecutan tanto de manera local como en GitHub Actions y actualmente presentan un 100 % de éxito.

# 

# Además, la publicación del reporte HTML como Artifact permite mantener los resultados disponibles para el equipo, mejorando la visibilidad y trazabilidad del proceso de pruebas.

# 

# \---

# 

# \## Conclusión

# 

# La implementación de este flujo permitió integrar distintas herramientas que normalmente se utilizan de forma complementaria en un proceso de desarrollo de software.

# 

# Git aporta trazabilidad sobre los cambios realizados, Maven permite administrar las dependencias y automatizar la construcción del proyecto, mientras que JUnit facilita la validación automática del comportamiento del código.

# 

# Finalmente, GitHub Actions permite llevar estas pruebas a un proceso de Integración Continua, de manera que cada cambio pueda ser validado de forma automática. Esto disminuye la dependencia de verificaciones manuales y entrega información temprana sobre posibles errores antes de integrar nuevas modificaciones al proyecto.

