
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

En la carpeta de la tarea se abre la terminal y se ejecutan los siguientes comandos: 

```
javac -cp '.:PilasyColas.jar' Main.java    

java -cp '.:PilasyColas.jar' Main {alto, ancho}

```

Dado que el programa usa la entrada estandar de la terminal, y que el método principal
en Java considera las palabras _String[] args_, es necesario poner el valor de alto
y ancho del programa entre llaves. Ejemplo {10,10}. 

<br>

## Resultado previsto en terminal.

Tomando, por ejemplo, un laberinto de 6x10, uno de los resultado es el siguiente: 
    
```

```

Hay que tomar en consideración que se generan los laberintos de forma aleatoria, por lo 
que siempre que se ejecute el programa, el resultado será diferente. 

<br>

## Documentación

Para generar la documentación se ocupa el siguiente comando en la carpeta de la tarea: 

```
javadoc -d docs src/*.java   

```
Y esta se podrá abrir en el navegador desde el archivo _allclasses-index.html_

<br>

## Notas


<br>

> _My bugs know what you coded in the dark..._