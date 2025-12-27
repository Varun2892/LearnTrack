package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;

import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;

import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean running = true;

        while (running) {

            System.out.println("\n=== LearnTrack Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Activate/Deactivate Course");
            System.out.println("8. Enroll Student in Course");
            System.out.println("9. View Student Enrollments");
            System.out.println("10. Update Enrollment Status");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Batch: ");
                    String batch = scanner.nextLine();

                    Student student = new Student(id, firstName, lastName, batch);
                    studentService.addStudent(student);
                    break;

                case 2:
                    studentService.listStudents();
                    break;

                case 3:
                    try {
                        System.out.print("Enter Student ID to search: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();

                        Student found = studentService.findStudentById(searchId);
                        System.out.println(
                                found.getDisplayName() +
                                        " | Batch: " + found.getBatch() +
                                        " | Active: " + found.isActive()
                        );
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.print("Enter Student ID to deactivate: ");
                        int deactivateId = scanner.nextInt();
                        scanner.nextLine();

                        studentService.deactivateStudent(deactivateId);
                        System.out.println("Student deactivated successfully.");
                    } catch (EntityNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Course ID: ");
                    int courseId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter Duration (weeks): ");
                    int duration = scanner.nextInt();
                    scanner.nextLine();

                    Course course = new Course(courseId, courseName, description, duration);
                    courseService.addCourse(course);
                    break;

                case 6:
                    courseService.listCourses();
                    break;

                case 7:
                    System.out.print("Enter Course ID: ");
                    int toggleId = scanner.nextInt();
                    scanner.nextLine();

                    boolean updated = courseService.toggleCourseStatus(toggleId);
                    if (updated) {
                        System.out.println("Course status updated.");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 8:
                    System.out.print("Enter Enrollment ID: ");
                    int enrollId = scanner.nextInt();

                    System.out.print("Enter Student ID: ");
                    int stuId = scanner.nextInt();

                    System.out.print("Enter Course ID: ");
                    int couId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Enrollment Date: ");
                    String date = scanner.nextLine();

                    Enrollment enrollment =
                            new Enrollment(enrollId, stuId, couId, date);
                    enrollmentService.enrollStudent(enrollment);
                    break;

                case 9:
                    System.out.print("Enter Student ID: ");
                    int sid = scanner.nextInt();
                    scanner.nextLine();

                    enrollmentService.listEnrollmentsByStudent(sid);
                    break;

                case 10:
                    System.out.print("Enter Enrollment ID: ");
                    int eid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Status (ACTIVE / COMPLETED / CANCELLED): ");
                    String status = scanner.nextLine();

                    boolean updatedEnroll =
                            enrollmentService.updateEnrollmentStatus(eid, status);

                    if (updatedEnroll) {
                        System.out.println("Enrollment status updated.");
                    } else {
                        System.out.println("Enrollment not found.");
                    }
                    break;

                case 11:
                    running = false;
                    System.out.println("Exiting LearnTrack. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
