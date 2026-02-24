package umg.edu.gt.programacion3;

import umg.edu.gt.programacion3.model.Song;
import umg.edu.gt.programacion3.simulator.SpotifySimulator;

public class Main {
    
    public static void main(String[] args) {
        
        // Crear el simulador
        SpotifySimulator simulator = new SpotifySimulator();
        
        // Agregar canciones con diferentes prioridades
        // Prioridad 1 = Alta, Prioridad 2 = Normal

        // Canciones de prioridad alta (1)
        simulator.addSong(new Song("Bohemian Rhapsody", "Queen", 8, 1));
        simulator.addSong(new Song("Hotel California", "Eagles", 10, 1));
        
        // Canciones de prioridad normal (2)
        simulator.addSong(new Song("Imagine", "John Lennon", 7, 2));
        simulator.addSong(new Song("Hey Jude", "The Beatles", 12, 2));
        simulator.addSong(new Song("Like a Rolling Stone", "Bob Dylan", 9, 2));
        
        // Iniciar la simulación
        simulator.startPlaylist();
    }
}