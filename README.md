# JITRAX - CUSL 2016/17

## ¿Qué es JITRAX?

JITRAX (Java Interpretation Tool for Relational Algebra Expressions) es un intérprete de Álgebra Relacional 
escrito en Java pensado para mejorar el proceso de aprendizaje por parte de aquellos estudiantes que 
se inician en el estudio de las bases de datos relacionales. 

JITRAX no implementa ningún motor de consultas en Álgebra Relacional. Para visualizar el resultado de una
consulta, se utiliza una técnica mucho más ingeniosa: traducir las expresiones escritas en Álgebra Relacional
a expresiones equivalentes en SQL y ejecutar estas últimas sobre un Sistema Gestor de PostgreSQL. ¿No es 
genial? ;-)

Esta herramienta ha sido desarrollada como parte de un Trabajo de Fin de Grado en la Universidad de La Laguna por Teguayco Gutiérrez González, bajo la dirección de Jesús M. Jorge Santiso.

![alt tag](https://user-images.githubusercontent.com/20015750/26836066-c33a7154-4ad1-11e7-8429-74f3ae709ad7.png)

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
* Soporte para vistas (asignación de un alias a una consulta que permite su posterior reutilización).
* Optimización de consultas: JITRAX es capaz de detectar cascadas de proyecciones y selecciones (véase los ficheros 'examples/R1R2R3R4/projection_cascade.ra' y 'examples/R1R2R3R4/selection_cascade.ra') y proponer traducciones que sean más eficientes y legibles.
* Mecanismo de sincronización con PostgreSQL: la discrepancia que pueda existir entre el contenido de la base de datos alojada en el Sistema Gestor de PostgreSQL y el de la base de datos con la que el usuario trabaja en el entorno puede derivar en un problema. Es por ello que JITRAX implementa un mecanismo de sincronización que pretende que la base de datos que hay en PostgreSQL sea exactamente igual que la que hay especificada en la aplicación. En la guía de usuario que está pediente de elaboración se comentará con más detalle cómo funciona esta característica.
* Modificación de los esquemas de bases de datos sobre los que operar desde el propio entorno gráfico.

## Ejecución

Antes de disfrutar de las bondades de JITRAX, instala [PostgreSQL](https://www.postgresql.org/download/). 

Con PostgreSQL instalado, tocaría ahora construir el fichero ejecutable mediante el uso de **Apache Ant** (Apache License 2.0). Para ello, sitúate desde un terminal en el directorio raíz del proyecto y ejecuta lo siguiente:

```sh
ant build-jar
```

Ya estás listo para ejecutar JITRAX:

```sh
ant run
```

## 'Quick start'

¿Ya has ejecutado JITRAX? Para comenzar a trastear con la herramienta, dirígete a 'File > Open' y selecciona aquel fichero que contenga la especificación de la base de datos con la que quieras empezar a trabajar (en el directorio 'examples' dispones de algunos ejemplos). 

NOTA: antes de poder seleccionar el fichero de la base de datos, necesitas establecer conexión con el SG de PostgreSQL que has descargado anteriormente. Por defecto, el puerto en el que se ejecuta PostgreSQL en tu máquina es el 5432 (aunque esto podría no ser así siempre). Además, el nombre de usuario y contraseña que JITRAX propone por defecto es 'postgres', dado que es la cuenta que PostgreSQL crea inicialmente de forma automática.

## Documentación

Muy pronto se elaborará una pequeña guía de usuario y documentación de utilidad para desarrolladores.

## Trabajo futuro

Este proyecto acaba de nacer y aún le queda mucho camino por recorrer. Como líneas futuras de trabajo,
se destacan los siguientes aspectos:

* Lanzamiento de una versión multidioma.
* Soporte para el lenguaje teórico del Cálculo Relacional.
* Implementación del Álgebra Relacional como DML.
* Optimizador de consultas para el Álgebra Relacional.
* Aumentar la lista de operadores soportados del Álgebra Relacional.
* Incrementar la lista de Sistemas Gestores con los que poder trabajar.

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

* [Hibernate ORM](http://hibernate.org/orm/): herramienta que incorpora un formateador de código SQL que utiliza JITRAX.

## Mejor Proyecto Educativo CUSL 2016/2017

En la undécima edición del Concurso Universitario de Software Libre celebrada en Sevilla (España) [Concurso Universitario de Software Libre](https://www.concursosoftwarelibre.org/1617/) JITRAX ha conseguido el premio al Mejor Proyecto Educativo, el cual le confiere a este trabajo un reconocimiento destacable como herramienta que favorece el aprendizaje del Álgebra Relacional.

## Licencia

Este proyecto se encuentra bajo una licencia GPLv3.
