package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;

public class EnrollmentService {

    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    // Enroll student
    public void enrollStudent(Enrollment enrollment) {
        enrollments.add(enrollment);
        System.out.println("Enrollment successful.");
    }

    // View enrollments for a student
    public void listEnrollmentsByStudent(int studentId) {
        boolean found = false;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                System.out.println(
                    "Enrollment ID: " + enrollment.getId() +
                    " | Course ID: " + enrollment.getCourseId() +
                    " | Status: " + enrollment.getStatus()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("No enrollments found for this student.");
        }
    }

    // Update enrollment status
    public boolean updateEnrollmentStatus(int enrollmentId, String status) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == enrollmentId) {
                enrollment.setStatus(status);
                return true;
            }
        }
        return false;
    }
}

