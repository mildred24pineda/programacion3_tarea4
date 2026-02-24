package umg.edu.gt.data_structure.queue;
import umg.edu.gt.data_structure.queue.manual.Queue;
public class Main {
    
    public static void main(String[] args) {
        
        // Prueba con Strings
        Queue<String> queueStrings = new Queue<>();
        queueStrings.enqueue("A");
        queueStrings.enqueue("B");
        queueStrings.enqueue("C");

        System.out.println("=== Prueba con Strings ===");
        System.out.println("Peek: " + queueStrings.peek()); // A
        System.out.println("Dequeue: " + queueStrings.dequeue()); // A
        System.out.println("Dequeue: " + queueStrings.dequeue()); // B
        System.out.println("Size: " + queueStrings.size()); // 1
        System.out.println("Dequeue: " + queueStrings.dequeue()); // C
        System.out.println("IsEmpty: " + queueStrings.isEmpty()); // true

        // Prueba con Integers 
        System.out.println("\n=== Prueba con Integers ===");
        Queue<Integer> queueIntegers = new Queue<>();
        queueIntegers.enqueue(10);
        queueIntegers.enqueue(20);
        queueIntegers.enqueue(30);

        System.out.println("Peek: " + queueIntegers.peek()); // 10
        System.out.println("Dequeue: " + queueIntegers.dequeue()); // 10
        System.out.println("Size: " + queueIntegers.size()); // 2
        
        System.out.println("\n=== Todas las pruebas completadas ===");
    }
}