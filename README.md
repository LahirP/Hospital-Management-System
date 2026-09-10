# Hospital-Management-System
A Java-based Hospital Management System using custom data structures to manage patients, doctors, appointments, and hospital records efficiently.


# 🏥 Hospital Management System

A simple **Java-based Hospital Management System** developed to manage basic hospital operations such as patients, doctors, appointments, emergency visits, diagnoses, and treatments.

This project was developed using **Java** and demonstrates the practical use of **Object-Oriented Programming (OOP)** and **Data Structures & Algorithms**.

---

## 📌 Project Overview

The Hospital Management System is a console-based Java application designed to organize and manage hospital-related information.

The system allows users to manage patient and doctor information, create appointments, record emergency visits, enter diagnoses and treatments, and view stored hospital records.

The project mainly focuses on applying Java programming concepts and data structures in a practical application.

---

## ✨ Main Features

The system provides several hospital management functions, including:

- Add and manage patient details
- Add and manage doctor details
- Create hospital appointments
- Manage emergency patient visits
- Enter patient diagnosis details
- Record treatment information
- Search and view stored records
- Remove records when required
- Display hospital information through a console-based menu

---

## 🧠 Concepts Used

This project demonstrates several important programming concepts:

### Object-Oriented Programming

The system uses Java OOP concepts such as:

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- Object interaction
- Modular program structure

### Data Structures

Different data structures are used to organize and manage hospital information efficiently.

These structures help demonstrate how data can be stored, accessed, searched, added, and removed within a real-world application.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| Oracle JDK 26 | Java compiler and runtime environment |
| Visual Studio Code | Development environment |
| PowerShell / Command Prompt | Compiling and running the application |
| GitHub | Source code hosting and version control |

---

## 📂 Project Structure

A simplified structure of the project is shown below:

```text
Hospital-Management-System/
│
├── HospitalManagementSystem/
│   └── src/
│       ├── Java source files
│       └── ...
│
├── README.md
└── .gitignore
```

> **Note:** The `oracleJdk-26` folder is not included in this GitHub repository.

---

# ☕ Java Requirements

This project requires **Oracle JDK 26** to compile and run.

Oracle JDK 26 was used during the development and testing of this project.

The complete Oracle JDK folder is **not uploaded to this repository** because the JDK contains a large number of files and significantly increases the repository size.

Therefore, users should download and install **Oracle JDK 26 separately** before running the project.

---

## 📥 Step 1 – Download Oracle JDK 26

Download **Oracle JDK 26** from the official Oracle Java website:

https://www.oracle.com/java/technologies/downloads/

Choose the correct version for your operating system.

For example, Windows users can download the appropriate **Windows x64** version.

---

## ⚙️ Step 2 – Install Oracle JDK 26

After downloading Oracle JDK 26, install it on your computer.

After installation, open:

- Command Prompt

or

- Windows PowerShell

Then check the Java version:

```powershell
java -version
```

You can also check the Java compiler:

```powershell
javac -version
```

The output should indicate that **Java/JDK 26** is available.

Example:

```text
java version "26.x.x"
javac 26.x.x
```

---

# 🚀 How to Run the Project

## Method 1 – Using Visual Studio Code

### Step 1

Download or clone this GitHub repository.

If you download it as a ZIP file, extract the ZIP file first.

### Step 2

Make sure **Oracle JDK 26** is installed on your computer.

### Step 3

Open **Visual Studio Code**.

### Step 4

Select:

```text
File → Open Folder
```

Then select the Hospital Management System project folder.

### Step 5

Open the Java source files inside the `src` folder.

### Step 6

Open the VS Code terminal:

```text
Terminal → New Terminal
```

### Step 7

Navigate to the folder containing the Java source files.

For example:

```powershell
cd HospitalManagementSystem\src
```

### Step 8

Compile the Java files:

```powershell
javac *.java
```

### Step 9

Run the main Java class.

For example:

```powershell
java HospitalManagementSystem
```

The Hospital Management System menu should now appear in the terminal.

---

# 💻 Method 2 – Using PowerShell or Command Prompt

Open PowerShell or Command Prompt inside the project directory.

Navigate to the source folder:

```powershell
cd HospitalManagementSystem\src
```

Compile the Java source files:

```powershell
javac *.java
```

Then run the main class:

```powershell
java HospitalManagementSystem
```

---

## 🖥️ Example Program Flow

When the program starts, the user can select different options from the main menu.

A typical workflow may look like this:

```text
Start Program
     ↓
Main Menu
     ↓
Select an Operation
     ↓
Enter Required Information
     ↓
Process Data
     ↓
Display Result
     ↓
Return to Main Menu
```

For example, an emergency visit can include information such as:

```text
Patient Details
      ↓
Emergency Visit
      ↓
Diagnosis
      ↓
Treatment
      ↓
Record Stored
```

---

## 🏥 Example Medical Record

A simple example of information entered into the system could be:

```text
Diagnosis: Minor workplace injury with cuts and bruises
Treatment: Clean the wound, apply antiseptic and bandage
```

Another example:

```text
Diagnosis: Fever
Treatment: Rest, fluids and appropriate medical treatment
```

These are demonstration records used to test the hospital management functions.

---

## 📊 System Objectives

The main objectives of this project are to:

- Develop a basic hospital management application using Java
- Apply Object-Oriented Programming concepts
- Apply Data Structures and Algorithms in a practical system
- Organize patient and hospital information
- Practice adding, searching, viewing and removing records
- Improve Java programming and problem-solving skills

---

## ⚠️ Important Notes

### Oracle JDK

The `oracleJdk-26` folder is intentionally excluded from this repository.

You **do not need to upload the Oracle JDK folder to GitHub**.

Users who download this project should install Oracle JDK 26 separately.

### Data Storage

This is primarily an educational Java project. Depending on the current implementation, application data may be stored temporarily while the program is running.

If the program does not use a permanent database or file storage system, the stored data may be lost when the application is closed.

### Medical Use

This project was created for **educational and academic purposes only**.

It is **not intended for use as a real hospital or clinical information system**.

---

## 🔧 Troubleshooting

### `java` is not recognized

If you receive an error similar to:

```text
'java' is not recognized as an internal or external command
```

make sure Oracle JDK 26 is installed correctly and Java has been added to the system PATH.

### `javac` is not recognized

If:

```powershell
javac -version
```

does not work, check your JDK installation and environment variables.

### Program does not start

Make sure you are running the command from the correct folder containing the compiled Java files.

---

## 🔮 Future Improvements

The system can be improved in the future by adding features such as:

- Graphical User Interface (GUI)
- Database integration
- User login system
- Admin dashboard
- Permanent patient record storage
- Prescription management
- Billing system
- Pharmacy management
- Staff management
- Improved appointment scheduling
- Report generation
- Advanced search functionality

---

## 🎓 Academic Purpose

This project was developed as an educational project to demonstrate knowledge of:

**Java Programming, Object-Oriented Programming, Data Structures, Algorithms, and basic Hospital Management System concepts.**

---

## 👨‍💻 Developer

Developed as part of an academic Java programming project.

---

## 📄 License

This project is intended for **educational purposes**.

---

⭐ If you find this project useful, feel free to star the repository.
