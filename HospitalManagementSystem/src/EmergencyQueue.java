/**
 * Requirement 2: Emergency Patient Queue - Queue (FIFO).
 * Implemented with a custom singly-linked node chain (front/rear pointers)
 * rather than java.util.Queue, so the underlying data structure is explicit.
 */
public class EmergencyQueue {

    private class Node {
        Patient patient;
        Node next;
        Node(Patient patient) { this.patient = patient; }
    }

    private Node front;
    private Node rear;
    private int size;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " (ID: " + patient.getPatientId() + ") added to emergency queue.");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patient to treat.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return patient;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.patient);
            current = current.next;
            position++;
        }
    }

    public boolean isEmpty() { return front == null; }
    public int getSize() { return size; }
}
