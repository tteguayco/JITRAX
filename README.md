# JITRAX

## ¿Qué es JITRAX?

JITRAX (Java Interpretation Tool for Relational Algebra Expressions) es un intérprete de Álgebra Relacional 
escrito en Java pensado para mejorar el proceso de aprendizaje por parte de aquellos estudiantes que 
se inician en el estudio de las bases de datos relacionales. 

JITRAX no implementa ningún motor de consultas en Álgebra Relacional. Para visualizar el resultado de una
consulta, se utiliza una técnica mucho más ingeniosa: traducir las expresiones escritas en Álgebra Relacional
a expresiones equivalentes en SQL y ejecutar estas últimas sobre un Sistema Gestor de PostgreSQL. ¿No es 
genial? ;-)

## Características



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

Para descargar el prototipo del proyecto, haz click [aquí](). Una vez lo hayas descargado, sitúate con 
desde una terminal en el mismo directorio que el fichero .JAR y ejecuta lo siguiente:

```sh
	java -jar jitrax_prototype.jar
```

## Documentación



## Trabajo futuro

## Colaboración



## Bibliotecas externas

JITRAX hace uso de cuatro bibliotecas externas, todas ellas con licencias de código libre que permiten 
su reutilización:

* 

## Participante CUSL 2016/2017



## Licencia

This project is under a GPLv3 license.
