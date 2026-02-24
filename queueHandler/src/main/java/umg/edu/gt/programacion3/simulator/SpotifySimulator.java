package umg.edu.gt.programacion3.simulator;

import umg.edu.gt.data_structure.queue.manual.Queue;
import umg.edu.gt.programacion3.model.Song;

public class SpotifySimulator {
    
    private Queue<Song> highPriorityQueue;   // Prioridad 1
    private Queue<Song> normalPriorityQueue; // Prioridad 2
    
    // Extensiones Parte D
    private Queue<Song> playedHistory;       // Historial de canciones reproducidas
    private int totalSongsPlayed;            // Contador total de canciones
    private int totalAccumulatedTime;        // Tiempo total acumulado (en segundos)
    
    public SpotifySimulator() {
        highPriorityQueue = new Queue<>();
        normalPriorityQueue = new Queue<>();
        // Inicializar extensiones
        playedHistory = new Queue<>();
        totalSongsPlayed = 0;
        totalAccumulatedTime = 0;
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
        
        // Actualizar extensiones (Parte D)
        playedHistory.enqueue(song);
        totalSongsPlayed++;
        totalAccumulatedTime += song.getDuration();
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
        
        // Mostrar estadísticas finales (Parte D)
        System.out.println("\n========== ESTADÍSTICAS FINALES ==========");
        System.out.println("Total de canciones reproducidas: " + totalSongsPlayed);
        System.out.println("Tiempo total acumulado: " + totalAccumulatedTime + " segundos");
        System.out.println("===========================================");
    }
    
    // Getters para extensiones (Parte D)
    public int getTotalSongsPlayed() {
        return totalSongsPlayed;
    }
    
    public int getTotalAccumulatedTime() {
        return totalAccumulatedTime;
    }
    
    public Queue<Song> getPlayedHistory() {
        return playedHistory;
    }
}