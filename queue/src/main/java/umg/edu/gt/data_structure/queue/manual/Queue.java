package umg.edu.gt.data_structure.queue.manual;

public class Queue<T> {
    
    private Node<T> head; // primero en salir
    private Node<T> tail; // ultimo en entrar
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Agregar elemento - O(1)
    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    // Eliminar y retornar el primero - O(1)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow: cannot dequeue from empty queue");
        }
        
        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    // Ver el primero sin eliminar
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow: cannot peek from empty queue");
        }
        return head.value;
    }
}