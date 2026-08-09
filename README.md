
# Automatización de Pruebas

## Descripción

Proyecto Java desarrollado para aplicar automatización de pruebas e Integración Continua.

Se utilizó Maven para administrar el proyecto, JUnit 5 para las pruebas unitarias, Git para el control de versiones y GitHub Actions para ejecutar automáticamente las pruebas.

Como funcionalidad de ejemplo se implementó un servicio básico de autenticación llamado `LoginService`.

## Tecnologías

- Java 21
- Maven 3.9.16
- JUnit 5
- Git y GitHub
- GitHub Actions
- Maven Surefire

## Estructura


automatizacion-pruebas/
│
├── .github/workflows/
│   └── ci.yml
│
├── src/main/java/
│   └── cl/automatizacion/service/
│       └── LoginService.java
│
├── src/test/java/
│   └── cl/automatizacion/service/
│       ├── LoginExitosoTest.java
│       └── LoginCredencialesInvalidasTest.java
│
├── .gitignore
├── pom.xml
└── README.md


El código principal se encuentra en `src/main/java` y las pruebas automatizadas en `src/test/java`.

## Pruebas unitarias

Se implementaron dos pruebas independientes:

- `LoginExitosoTest`: valida el acceso con credenciales correctas.
- `LoginCredencialesInvalidasTest`: valida el rechazo de credenciales incorrectas.

Cada prueba verifica un solo comportamiento para mantener la atomicidad de los tests.

Para ejecutar las pruebas:

bash
mvn clean test


Resultado obtenido:


Tests run: 2
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS


## Control de versiones

El proyecto utiliza Git y una estructura de ramas basada en:

main
develop
feature/configuracion-maven
feature/pruebas-unitarias
feature/pipeline-ci
feature/reporte-tests


Los cambios fueron registrados mediante commits descriptivos y posteriormente integrados a `develop`.

## Integración Continua

El pipeline está configurado en:


.github/workflows/ci.yml


GitHub Actions ejecuta automáticamente las pruebas ante un `push` o `pull request` hacia `main` o `develop`.

El proceso realiza:


Descarga del código
        ↓
Configuración de Java 21
        ↓
Ejecución de Maven
        ↓
Pruebas JUnit
        ↓
Generación del reporte
        ↓
Publicación del Artifact


## Reporte de pruebas

Para generar el reporte HTML localmente:


mvn clean test surefire-report:report-only

El reporte se genera en:


target/reports/surefire.html


Actualmente presenta:

Tests: 2
Errors: 0
Failures: 0
Success Rate: 100 %


GitHub Actions también publica el reporte como un Artifact llamado:

reporte-pruebas-junit


Esto permite consultar los resultados directamente desde el pipeline.

## Conclusión

Con este proyecto se implementó un flujo básico de automatización de pruebas utilizando Java, Maven, JUnit y GitHub Actions.

Las pruebas pueden ejecutarse localmente y también de forma automática mediante Integración Continua, permitiendo detectar errores antes de incorporar nuevos cambios al proyecto.