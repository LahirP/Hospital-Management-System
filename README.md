# Hospital-Management-System
A Java-based Hospital Management System using custom data structures to manage patients, doctors, appointments, and hospital records efficiently.


# Mini Hospital Emergency Management System

A console-based Java application developed for **CIT300 – Data Structures and Algorithms**. The system demonstrates how core data structures can be applied to a simple hospital emergency workflow, including patient registration, emergency queuing, treatment recording, and patient visit history management.

## Features

- Register, search, delete, and display patient records.
- Store patient records in a **Binary Search Tree (BST)** using Patient ID as the key.
- Add registered patients to an emergency **FIFO Queue**.
- Dequeue the next patient and record the completed treatment.
- Store completed treatments in a **LIFO Stack**.
- Maintain a separate **Singly Linked List** of visits for each patient.
- Add, search, remove, and display patient visits.
- Automatically add a treatment record and patient visit when an emergency patient is treated.
- Handle empty data structures and invalid numeric input with user-friendly console messages.

## Data Structures Used

| System Requirement | Data Structure | Main Class |
|---|---|---|
| Patient records | Binary Search Tree (BST) | `PatientBST.java` |
| Emergency patient waiting list | Queue (FIFO) | `EmergencyQueue.java` |
| Completed treatment history | Stack (LIFO) | `TreatmentStack.java` |
| Individual patient visit history | Singly Linked List | `VisitLinkedList.java` |

All four required data structures are implemented manually with custom node classes. The project does not use `java.util.LinkedList`, `java.util.Queue`, or `java.util.Stack` for these structures.

## How the System Works

### 1. Patient Records – Binary Search Tree
Patients are stored according to their unique Patient ID. The BST supports insertion, searching, deletion, and in-order traversal. Displaying the tree in-order shows patients in ascending Patient ID order. BST deletion handles nodes with zero, one, or two children.

### 2. Emergency Patient Queue – FIFO
A patient must first exist in the patient records before being added to the emergency queue. Patients are treated in **First In, First Out (FIFO)** order. When the next patient is dequeued, the program asks for the treatment and completion date.

### 3. Treatment History – Stack
Completed treatments are stored in a custom stack. Because the stack follows **Last In, First Out (LIFO)** order, the most recently completed treatment is displayed or removed first. Treatment records can also be entered manually for registered patients.

### 4. Patient Visit History – Singly Linked List
Each `Patient` object owns its own `VisitLinkedList`. A visit contains a Visit ID, date, doctor name, diagnosis, and treatment. Visits can be added, searched by Visit ID, removed, and displayed.

When a patient is treated through the emergency queue, the system automatically:

1. Removes the next patient from the queue.
2. Creates and pushes a `TreatmentRecord` onto the treatment stack.
3. Creates a `Visit` and appends it to that patient's visit history.

This workflow demonstrates how the four data structures work together in one application.

## Main Menu

```text
===== Mini Hospital Emergency Management System =====
1. Patient Records (BST)
2. Emergency Patient Queue
3. Treatment History (Stack)
4. Patient Visit History (Linked List)
0. Exit
```

## Technologies

- Java
- Console-based user interface
- Object-Oriented Programming (OOP)
- Custom implementations of BST, Queue, Stack, and Singly Linked List

## Requirements

Install a **Java Development Kit (JDK)** and make sure `java` and `javac` are available from your terminal.

The project has been tested with **Oracle JDK 26**. It uses standard Java features and does not require any external libraries.

Check your Java installation with:

```bash
java -version
javac -version
```

## Compile and Run

From the repository root:

### Windows PowerShell

```powershell
cd "HospitalManagementSystem\src"
javac *.java
java HospitalManagementSystem
```

### macOS / Linux

```bash
cd HospitalManagementSystem/src
javac *.java
java HospitalManagementSystem
```

If you are using the JDK included in the original project folder on Windows, you can also run the compiler and Java executable using their full relative paths. For a public GitHub repository, however, it is better to install a JDK separately rather than commit the complete JDK distribution.

## Project Structure

```text
Hospital System/
├── README.md
├── HospitalManagementSystem/
│   ├── README.md
│   └── src/
│       ├── EmergencyQueue.java
│       ├── HospitalManagementSystem.java
│       ├── Patient.java
│       ├── PatientBST.java
│       ├── TreatmentRecord.java
│       ├── TreatmentStack.java
│       ├── Visit.java
│       └── VisitLinkedList.java
└── Screenshots of program output/
    └── ... program output screenshots
```

## Class Overview

| Class | Purpose |
|---|---|
| `HospitalManagementSystem` | Application entry point, menus, input handling, and workflow coordination |
| `Patient` | Stores patient details and owns the patient's visit history |
| `PatientBST` | Stores and manages patient records using a BST |
| `EmergencyQueue` | Maintains emergency patients in FIFO order |
| `TreatmentRecord` | Represents one completed treatment |
| `TreatmentStack` | Stores treatment records in LIFO order |
| `Visit` | Represents one hospital visit |
| `VisitLinkedList` | Stores and manages a patient's visits |

## Example Workflow

1. Open **Patient Records** and register a patient.
2. Open **Emergency Patient Queue** and enqueue the patient's ID.
3. Display the queue to view waiting patients.
4. Dequeue the next patient for treatment.
5. Enter the treatment details and completion date.
6. Open **Treatment History** to view the completed treatment.
7. Open **Patient Visit History** to view the visit automatically recorded for that patient.

## Screenshots

Program output screenshots are included in the `Screenshots of program output` folder and demonstrate the console menus and system operations.

## Important Notes

- Patient IDs must be unique.
- A patient must be registered before being added to the emergency queue or receiving a manual treatment record.
- Treatment Record IDs and Visit IDs are generated automatically while the program is running.
- Data is stored in memory only. Closing the program clears the current records because no database or file persistence is used.
- Automatically created emergency visits currently use `Duty Doctor` as the doctor name and the patient's registered medical condition as the diagnosis.

## Academic Purpose

This project was created to demonstrate practical understanding of **Data Structures and Algorithms** in Java, especially Binary Search Trees, Queues, Stacks, and Singly Linked Lists.
