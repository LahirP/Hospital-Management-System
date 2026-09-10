import java.util.Scanner;

/**
 * Mini Hospital Emergency Management System.
 * Console menu that demonstrates:
 *   1. Patient Records      -> PatientBST (Binary Search Tree)
 *   2. Emergency Queue      -> EmergencyQueue (Queue, FIFO)
 *   3. Treatment History    -> TreatmentStack (Stack, LIFO)
 *   4. Patient Visit History-> VisitLinkedList (Singly Linked List, per patient)
 */
public class HospitalManagementSystem {

    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();
    private static final Scanner scanner = new Scanner(System.in);

    private static int treatmentRecordCounter = 1;
    private static int visitIdCounter = 1;

    public static void main(String[] args) {
        int choice;
        do {
            printMainMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: patientRecordsMenu(); break;
                case 2: emergencyQueueMenu(); break;
                case 3: treatmentHistoryMenu(); break;
                case 4: visitHistoryMenu(); break;
                case 0: System.out.println("Exiting system. Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n===== Mini Hospital Emergency Management System =====");
        System.out.println("1. Patient Records (BST)");
        System.out.println("2. Emergency Patient Queue");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("0. Exit");
    }

    // ---------------------------------------------------------------
    // 1. Patient Records - BST
    // ---------------------------------------------------------------
    private static void patientRecordsMenu() {
        int choice;
        do {
            System.out.println("\n-- Patient Records (BST) --");
            System.out.println("1. Insert Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients (In-order)");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: insertPatient(); break;
                case 2: searchPatient(); break;
                case 3: deletePatient(); break;
                case 4: patientBST.displayInOrder(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void insertPatient() {
        int id = readInt("Enter Patient ID: ");
        if (patientBST.search(id) != null) {
            System.out.println("A patient with this ID already exists.");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        int age = readInt("Enter Age: ");
        scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        patientBST.insert(new Patient(id, name, age, contact, condition));
        System.out.println("Patient added successfully.");
    }

    private static void searchPatient() {
        int id = readInt("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);
        System.out.println(patient != null ? patient : "Patient not found.");
    }

    private static void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");
        boolean deleted = patientBST.delete(id);
        System.out.println(deleted ? "Patient deleted successfully." : "Patient not found.");
    }

    // ---------------------------------------------------------------
    // 2. Emergency Patient Queue
    // ---------------------------------------------------------------
    private static void emergencyQueueMenu() {
        int choice;
        do {
            System.out.println("\n-- Emergency Patient Queue --");
            System.out.println("1. Enqueue Patient (must already exist in records)");
            System.out.println("2. Dequeue Patient (send next patient for treatment)");
            System.out.println("3. Display Waiting Patients");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: enqueuePatient(); break;
                case 2: dequeuePatient(); break;
                case 3: emergencyQueue.display(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void enqueuePatient() {
        int id = readInt("Enter Patient ID to add to queue: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records. Please register the patient first.");
            return;
        }
        emergencyQueue.enqueue(patient);
    }

    /**
     * Dequeues the next patient and, in one flow, records the completed
     * treatment on the TreatmentStack and appends a Visit to the patient's
     * VisitLinkedList - showing how the four structures work together.
     */
    private static void dequeuePatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient == null) return;
        System.out.println("Now treating: " + patient);

        scanner.nextLine();
        System.out.print("Enter treatment given: ");
        String treatment = scanner.nextLine();
        System.out.print("Enter completion date (e.g. 2026-09-09): ");
        String date = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                treatmentRecordCounter++, patient.getPatientId(), patient.getName(), treatment, date);
        treatmentStack.push(record);

        Visit visit = new Visit(visitIdCounter++, date, "Duty Doctor", patient.getMedicalCondition(), treatment);
        patient.getVisitHistory().addVisit(visit);

        System.out.println("Treatment completed and recorded.");
    }

    // ---------------------------------------------------------------
    // 3. Treatment History - Stack
    // ---------------------------------------------------------------
    private static void treatmentHistoryMenu() {
        int choice;
        do {
            System.out.println("\n-- Treatment History (Stack) --");
            System.out.println("1. Push Treatment Record (manual entry)");
            System.out.println("2. Pop Most Recent Treatment Record");
            System.out.println("3. Display All Treatment Records");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: pushTreatmentRecord(); break;
                case 2: popTreatmentRecord(); break;
                case 3: treatmentStack.display(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void pushTreatmentRecord() {
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        scanner.nextLine();
        System.out.print("Enter treatment details: ");
        String treatment = scanner.nextLine();
        System.out.print("Enter completion date: ");
        String date = scanner.nextLine();

        TreatmentRecord record = new TreatmentRecord(
                treatmentRecordCounter++, patient.getPatientId(), patient.getName(), treatment, date);
        treatmentStack.push(record);
        System.out.println("Treatment record pushed successfully.");
    }

    private static void popTreatmentRecord() {
        TreatmentRecord record = treatmentStack.pop();
        if (record != null) {
            System.out.println("Removed: " + record);
        }
    }

    // ---------------------------------------------------------------
    // 4. Patient Visit History - Singly Linked List
    // ---------------------------------------------------------------
    private static void visitHistoryMenu() {
        int choice;
        do {
            System.out.println("\n-- Patient Visit History (Linked List) --");
            System.out.println("1. Add Visit to Patient History");
            System.out.println("2. Remove Visit from Patient History");
            System.out.println("3. Search Visit in Patient History");
            System.out.println("4. Display Patient Visit History");
            System.out.println("0. Back to Main Menu");
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: addVisit(); break;
                case 2: removeVisit(); break;
                case 3: searchVisit(); break;
                case 4: displayVisitHistory(); break;
                case 0: break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static Patient getPatientOrPrintError() {
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
        }
        return patient;
    }

    private static void addVisit() {
        Patient patient = getPatientOrPrintError();
        if (patient == null) return;

        scanner.nextLine();
        System.out.print("Enter Visit Date: ");
        String date = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(visitIdCounter++, date, doctor, diagnosis, treatment);
        patient.getVisitHistory().addVisit(visit);
        System.out.println("Visit added successfully. Visit ID: " + visit.getVisitId());
    }

    private static void removeVisit() {
        Patient patient = getPatientOrPrintError();
        if (patient == null) return;
        int visitId = readInt("Enter Visit ID to remove: ");
        boolean removed = patient.getVisitHistory().removeVisit(visitId);
        System.out.println(removed ? "Visit removed successfully." : "Visit not found.");
    }

    private static void searchVisit() {
        Patient patient = getPatientOrPrintError();
        if (patient == null) return;
        int visitId = readInt("Enter Visit ID to search: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        System.out.println(visit != null ? visit : "Visit not found.");
    }

    private static void displayVisitHistory() {
        Patient patient = getPatientOrPrintError();
        if (patient == null) return;
        System.out.println("Visit history for " + patient.getName() + ":");
        patient.getVisitHistory().display();
    }

    // ---------------------------------------------------------------
    // Utility
    // ---------------------------------------------------------------
    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}
