## Tarea 2: Laberinto

<br>

| Alumno                      | No. de Cuenta |
| --------------------------- | ------------- |
| Paredes Zamudio Luis Daniel | 318159926     |
| Luis Norberto López García  | 423092075     |

<br>

## Dependencias

- Java 17

<br>

## Comandos tarea se Ejecución

En la carpeta _"/src"_ de la tarea se abre la terminal y se ejecutan los siguientes comandos:

```
javac -cp ".:lib/PilasYColas.jar" -d bin src/*.java

java -cp ".:lib/PilasYColas.jar:bin/" Main {alto,ancho}
```

Dado que el programa usa la entrada estandar de la terminal, y que el método principal
en Java considera las palabras _String[] args_, es necesario poner el valor de alto
y ancho del programa entre llaves. Ejemplo {10,10}.

<br>

## Resultado previsto en terminal.

Tomando, por ejemplo, un laberinto de 6x10, uno de los resultado es el siguiente:

```
 _ _ _ _ _ _ _ _ _ _
|I _ _  |   |  _    |
| |   |_ _|_ _|  _|_|
| |_|  _ _  | |_ _  |
| |  _|   | |   |  _|
|_ _|  _|_ _| | |_  |
|_  | |_    | |_ _| |
|  _|_ _ _|  _|   | |
|_ _ _  |  _|  _| | |
| |  _ _|_ _|_  |_  |
|_ _ _ _ _ _ _ _|_ F|

 Las coordenadas para la salida más rapida del laberinto son:
{(0,0), (0,1), (0,2), (0,3), (1,3), (1,4), (0,4), (0,5), (1,5), (1,6), (0,6), (0,7), (0,8), (1,8), (1,7), (2,7), (2,8), (2,9), (3,9), (3,8), (4,8), (4,9), (5,9), (6,9), (7,9), (8,9), (9,9)}
 _ _ _ _ _ _ _ _ _ _
|x x x x x x x x x   |
|      x x x x x x   |
|              x x x |
|                x x |
|                x x |
|                  x |
|                  x |
|                  x |
|                  x |
| _ _ _ _ _ _ _ _ _x |
```

Hay que tomar en consideración que se generan los laberintos de forma aleatoria, por lo
que siempre que se ejecute el programa, el resultado será diferente.

<br>

## Documentación

Para generar la documentación se ocupa el siguiente comando en la carpeta de la tarea:

```
javadoc -cp ".:lib/PilasYColas.jar" -d docs src/*.java
```

Y esta se podrá abrir en el navegador desde el archivo _allclasses-index.html_

<br>

## Notas

<br>

> _My bugs know what you coded in the dark..._
