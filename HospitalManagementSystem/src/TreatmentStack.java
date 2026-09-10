/**
 * Requirement 3: Treatment History - Stack (LIFO).
 * Implemented with a custom singly-linked node chain and a top pointer.
 */
public class TreatmentStack {

    private class Node {
        TreatmentRecord record;
        Node next;
        Node(TreatmentRecord record) { this.record = record; }
    }

    private Node top;
    private int size;

    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment history stack is empty. Nothing to remove.");
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        size--;
        return record;
    }

    public TreatmentRecord peek() {
        return isEmpty() ? null : top.record;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }

    public boolean isEmpty() { return top == null; }
    public int getSize() { return size; }
}
