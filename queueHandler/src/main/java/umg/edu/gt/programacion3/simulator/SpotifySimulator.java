package umg.edu.gt.programacion3.simulator;

import umg.edu.gt.data_structure.queue.manual.Queue;
import umg.edu.gt.programacion3.model.Song;

public class SpotifySimulator {
    
    private Queue<Song> highPriorityQueue;  // Prioridad 1
    private Queue<Song> normalPriorityQueue; // Prioridad 2
    
    public SpotifySimulator() {
        highPriorityQueue = new Queue<>();
        normalPriorityQueue = new Queue<>();
    }
    
    // Agregar canción según su prioridad
    public void addSong(Song song) {
        if (song.getPriority() == 1) {
            highPriorityQueue.enqueue(song);
        } else {
            normalPriorityQueue.enqueue(song);
        }
    }
    
    // Obtener siguiente canción (prioridad primero)
    private Song getNextSong() {
        if (!highPriorityQueue.isEmpty()) {
            return highPriorityQueue.dequeue();
        } else if (!normalPriorityQueue.isEmpty()) {
            return normalPriorityQueue.dequeue();
        }
        return null;
    }
    
    // Verificar si hay canciones
    public boolean hasSongs() {
        return !highPriorityQueue.isEmpty() || !normalPriorityQueue.isEmpty();
    }
    
    // Reproducir canción con simulación segundo a segundo
    public void playSong(Song song) {
        System.out.println("[LOG] Now playing: " + song.getTitle() + " - " + 
                          song.getArtist() + " (" + song.getDuration() + "s)");
        
        // Simular reproducción segundo a segundo
        for (int i = 1; i <= song.getDuration(); i++) {
            System.out.println("[LOG] Playing: " + song.getTitle() + " | " + i + "s / " + 
                             song.getDuration() + "s");
            try {
                Thread.sleep(1000); // 1 segundo real = 1 segundo de simulación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("[LOG] Finished: " + song.getTitle());
    }
    
    // Iniciar playlist
    public void startPlaylist() {
        System.out.println("[LOG] Starting playlist...");
        
        while (hasSongs()) {
            Song song = getNextSong();
            if (song != null) {
                playSong(song);
            }
        }
        
        System.out.println("[LOG] Playlist finished.");
    }
}