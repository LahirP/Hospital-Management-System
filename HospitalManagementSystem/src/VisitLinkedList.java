/**
 * Requirement 4: Patient Visit History - Singly Linked List.
 * Each Patient owns one instance of this list, holding their past visits
 * in the order they were added. Supports add, remove (by Visit ID),
 * search (by Visit ID), and display.
 */
public class VisitLinkedList {

    private class Node {
        Visit visit;
        Node next;
        Node(Visit visit) { this.visit = visit; }
    }

    private Node head;
    private int size;

    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean removeVisit(int visitId) {
        if (head == null) return false;

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            size--;
            return true;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("  No visit history recorded.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("  " + current.visit);
            current = current.next;
        }
    }

    public boolean isEmpty() { return head == null; }
    public int getSize() { return size; }
}
