# JITRAX - CUSL 2016/17

## ¿Qué es JITRAX?

JITRAX (Java Interpretation Tool for Relational Algebra Expressions) es un intérprete de Álgebra Relacional 
escrito en Java pensado para mejorar el proceso de aprendizaje por parte de aquellos estudiantes que 
se inician en el estudio de las bases de datos relacionales. 

JITRAX no implementa ningún motor de consultas en Álgebra Relacional. Para visualizar el resultado de una
consulta, se utiliza una técnica mucho más ingeniosa: traducir las expresiones escritas en Álgebra Relacional
a expresiones equivalentes en SQL y ejecutar estas últimas sobre un Sistema Gestor de PostgreSQL. ¿No es 
genial? ;-)

## Características

* Definición de bases de datos con las que trabajar en el entorno mediante un DSL sencillo.
* Manejo de múltiples bases de datos y consultas en simultáneo.
* Detección de errores sintácticos en expresiones escritas en Álgebra Relacional.
* Detección de errores semánticos en expresiones SQL ejecutadas sobre PostgreSQL (referencias a tablas
inexistentes, comparaciones de atributos con dominios no equivalentes, etc).
* Visualización del árbol de análisis sintáctico de las expresiones de Álgebra Relacional y tabla de 
resultados de la consulta ejecutada.
* Posibilidad de formatear el código SQL traducido.
* Consola de retroalimentación para el usuario.
* Sistema de importación/exportación de consultas mediante ficheros.
* Soporte para los siguientes operadores del Álgebra Relacional: proyección, selección, unión,
diferencia, intersección, producto cartesiano, yunción, yunción natural y división.

## Prototipo

Actualmente se encuentra disponible un prototipo de la aplicación en formato JAR. Esta versión ya cuenta con
un alto grado de funcionaldad; no obstante, aún se espera poder incorporar las siguientes características
pendientes:

* Creación de bases de datos desde el propio entorno gráfico (de momento sólo es posible especificarlas
mediante fichero).
* Mecanismo de sincronización con la base de datos en PostgreSQL: ¿qué ocurre si el usuario especifica una 
base de datos en la aplicación que ya existe en el SG pero los contenidos de ambas difieren? Tendría que 
entrar en escena un mecanismo que haga que los contenidos de ambas bases de datos (el que se encuentra 
especificada en la aplicación y la del Sistema Gestor) sean compatibles. Además, podría darse el caso en el que el usuario quiera traerse una base de datos ya existente en el SG con la que quiera trabajar.
* Formato multidioma: se ha decidido que el idioma de la primera versión de JITRAX sea el inglés, pero en el
futuro se espera incorporar soporte para más idiomas. 
* Menús de 'Edit' y 'View': aún se encuentran sin ninguna funcionalidad en este prototipo.

## Instalación

Antes de disfrutar de las bondades de JITRAX, instala [PostgreSQL](https://www.postgresql.org/download/). 

Para descargar el prototipo del proyecto, haz click [aquí](). Una vez lo hayas descargado, sitúate 
desde una terminal en el mismo directorio que el fichero .JAR y ejecuta lo siguiente:

```sh
java -jar jitrax_prototype.jar
```

## 'Quick start'



## Documentación

Muy pronto se elaborará una pequeña guía de usuario y documentación de utilidad para desarrolladores.

## Trabajo futuro



## Bibliotecas externas

JITRAX hace uso de cuatro bibliotecas externas, todas ellas con licencias de código libre que permiten 
su reutilización en este proyecto atendiendo a las bases del CUSL:

* [ANTLRv4](http://www.antlr.org/about.html): poderosa herramienta para el reconocimiento de lenguajes
desarrollada por Terence Parr, profesor de la Universidad de San Francisco.

* [RSyntaxTextArea](http://bobbylight.github.io/RSyntaxTextArea/): editor de código que permite añadir
resaltado sintáctico para nuevos lenguajes (en este caso, se ha añadido para Álgebra Relacional).

* [JDBC PostgreSQL Driver](https://jdbc.postgresql.org/about/license.html): biblioteca que permite realizar
la conexión con el Sistema Gestor de PostgreSQL que utilizará la aplicación para ejecutar las traducciones
a SQL.

* [Hibernate ORM](http://hibernate.org/orm/): analizador del lenguaje SQL que incluye infinidad de funciones, pero JITRAX sólo la utiliza para añadir la opción de formateo de código SQL en el editor del entorno gráfico.

## Participante CUSL 2016/2017

A día de hoy, JITRAX participa en el [Concurso Universitario de Software Libre](https://www.concursosoftwarelibre.org/1617/) en su undécima edición. Además, lo hace en la categoría de 
ocio/educación. 

## Licencia

Este proyecto se encuentra bajo una licencia GPLv3.
