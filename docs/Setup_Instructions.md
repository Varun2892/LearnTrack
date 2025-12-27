# Setup Instructions

## Java Setup
JDK Version Used: Java 17

## Verify Java Installation
java -version
javac -version

## Compilation
The project is compiled using:
javac -d out $(find src -name "*.java")

## Running the Application
The application is run using:
java -cp out com.airtribe.learntrack.ui.Main


