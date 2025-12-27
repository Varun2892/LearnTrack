# LearnTrack – Student & Course Management System

LearnTrack is a console-based Student, Course, and Enrollment Management System built using Core Java.
The project focuses on practicing Java fundamentals, OOP concepts, collections, and exception handling.

## Features
- Add, view, search, and deactivate students
- Add, view, activate/deactivate courses
- Enroll students into courses
- View and update enrollment status
- Menu-driven console application
- Custom exception handling
- In-memory storage using ArrayList

## Technologies Used
- Core Java
- JDK 17
- Terminal / IntelliJ IDEA

## Project Structure
src/
└── com/airtribe/learntrack
    ├── entity
    ├── service
    ├── ui
    ├── exception
    └── util

## How to Compile and Run
javac -d out $(find src -name "*.java")
java -cp out com.airtribe.learntrack.ui.Main

## Author
Varun Srinivas

