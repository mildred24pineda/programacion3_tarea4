# 🎵 Spotify Simulator - Queue Data Structure

Simulación tipo Spotify utilizando una estructura de datos Cola (FIFO) desarrollada desde cero en Java.

## 📋 Tabla de Contenidos
- [Requisitos](#-requisitos)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Cómo Compilar](#-cómo-compilar)
- [Cómo Ejecutar](#-cómo-ejecutar)
- [Diseño y Decisiones Técnicas](#-diseño-y-decisiones-técnicas)
- [Sistema de Prioridad](#-sistema-de-prioridad)
- [Simulación de Duración](#-simulación-de-duración)

## 🛠 Requisitos
- Java 8 o superior
- Maven 3.6 o superior

## 📁 Estructura del Proyecto
umg.edu.gt.data-structure.queue/
├── queue/ # Librería de cola (Parte A)
│ ├── src/main/java/
│ │ └── umg/edu/gt/data_structure/queue/manual/
│ │ ├── Node.java # Nodo genérico
│ │ └── Queue.java # Cola genérica FIFO
│ └── pom.xml
├── queueHandler/ # Simulador Spotify (Parte B, C, D)
│ ├── src/main/java/
│ │ └── umg/edu/gt/programacion3/
│ │ ├── Main.java
│ │ ├── model/
│ │ │ └── Song.java
│ │ └── simulator/
│ │ └── SpotifySimulator.java
│ └── pom.xml
├── evidencias/ # Capturas de pantalla
└── README.md


## 🔨 Cómo Compilar

### 1. Compilar la librería de cola:
cd queue
mvn clean install

Nota:Esto instala la librería en el repositorio local de Maven.

### 2. Compilar el queueHandler:
cd queueHandler
mvn clean package

Nota: Esto compila el proyecto y empaqueta el JAR ejecutable.

## 🚀 Cómo Ejecutar
Desde la carpeta queueHandler:
Desde Eclipse:
Click derecho en Main.java
Run As → Java Application

## 🎨 Diseño y Decisiones Técnicas
### Estructura de Datos Manual
Node<T>: Clase genérica que representa un nodo enlazado
Queue<T>: Cola FIFO implementada con nodos enlazados
Complejidad O(1): Tanto enqueue() como dequeue() son operaciones constantes
### Arquitectura Maven
Proyecto modular: Separación en librería (queue) y consumidor (queueHandler)
Dependencias locales: La librería se instala en el repositorio local de Maven
Encapsulamiento: Los nodos internos no son expuestos al cliente

## 🔥 Sistema de Prioridad
### Implementación:
Se utilizaron dos colas internas:
highPriorityQueue: Para canciones con prioridad 1 (alta)
normalPriorityQueue: Para canciones con prioridad 2 (normal)
### Funcionamiento:
Al agregar una canción, se clasifica según su prioridad
Al reproducir, primero se vacía la cola de alta prioridad
Luego se procesa la cola normal
Dentro de cada cola se respeta el orden FIFO

## Codigo relevante

public void addSong(Song song) {
    if (song.getPriority() == 1) {
        highPriorityQueue.enqueue(song);
    } else {
        normalPriorityQueue.enqueue(song);
    }
}

private Song getNextSong() {
    if (!highPriorityQueue.isEmpty()) {
        return highPriorityQueue.dequeue();
    } else if (!normalPriorityQueue.isEmpty()) {
        return normalPriorityQueue.dequeue();
    }
    return null;
}


## ⏱ Simulación de Duración
### Implementación:
Thread.sleep(1000): Simula 1 segundo real por cada segundo de canción
Progreso segundo a segundo: Se muestra el avance con logs detallados
Duraciones variables: Cada canción tiene duración entre 5 y 30 segundos

### Formato de logs:
[LOG] Now playing: Song Title - Artist (12s)
[LOG] Playing: Song Title | 1s / 12s
[LOG] Playing: Song Title | 2s / 12s
...
[LOG] Finished: Song Title


## 📦 Extensiones Implementadas (Parte D)
Historial de canciones reproducidas: Se implementó una cola adicional para rastrear el historial
Contador total de canciones reproducidas: Variable que incrementa con cada canción completada

## 📸 Evidencias
Las capturas de pantalla se encuentran en la carpeta evidencias/:
maven_install_queue.jpg: Instalación de la librería
maven_package_queueHandler.jpg: Compilación del handler
evidencia_ejecucion_playlist.jpg: Ejecución con logs segundo a segundo ASI HICE EL README.md en block de notas