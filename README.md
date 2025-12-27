# LearnTrack – Student, Course & Enrollment Management System

LearnTrack is a console-based application built using **Core Java** to manage students, courses, and enrollments.  
The project is designed to strengthen Java fundamentals, Object-Oriented Programming concepts, collections, and exception handling.

---

##  Features
- Student Management  
  - Add, view, search, and deactivate students
- Course Management  
  - Add, view, activate/deactivate courses
- Enrollment Management  
  - Enroll students into courses
  - View enrollments for a student
  - Update enrollment status (ACTIVE / COMPLETED / CANCELLED)
- Menu-driven console interface
- Custom exception handling
- In-memory data storage using `ArrayList`

---

## 🛠 Technologies Used
- Core Java
- JDK 17
- Terminal / IntelliJ IDEA
- Git & GitHub

---

##  Project Structure
                +----------------+
                |    Person      |
                +----------------+
                | id             |
                | firstName      |
                | lastName       |
                | email          |
                +----------------+
                        ▲
                        |
                +----------------+
                |    Student     |
                +----------------+
                | batch          |
                | active         |
                +----------------+

+----------------+        +------------------+
|     Course     |        |   Enrollment     |
+----------------+        +------------------+
| id             |        | id               |
| courseName     |        | studentId        |
| description    |        | courseId         |
| durationWeeks  |        | enrollmentDate   |
| active         |        | status           |
+----------------+        +------------------+

+---------------------+
|  StudentService     |
+---------------------+
| addStudent()        |
| findStudentById()   |
| deactivateStudent() |
+---------------------+

+---------------------+
|  CourseService      |
+---------------------+
| addCourse()         |
| toggleCourseStatus()|
+---------------------+

+---------------------+
| EnrollmentService   |
+---------------------+
| enrollStudent()     |
| updateStatus()      |
+---------------------+

+---------------------+
| Main (UI Layer)     |
+---------------------+
| Menu Handling       |
| User Input          |
+---------------------+

## How to Compile and Run
javac -d out $(find src -name "*.java")
java -cp out com.airtribe.learntrack.ui.Main

 Exception Handling
Custom EntityNotFoundException is used to handle invalid student or course IDs.
Input parsing is wrapped in try-catch blocks to prevent runtime crashes

## Author
Varun Srinivas

> Submission branch created for project evaluation.

