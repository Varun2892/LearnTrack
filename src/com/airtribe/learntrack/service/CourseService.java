package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import java.util.ArrayList;

public class CourseService {

    private ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        System.out.println("\n--- Course List ---");
        for (Course course : courses) {
            System.out.println(
                "ID: " + course.getId() +
                " | Name: " + course.getCourseName() +
                " | Duration: " + course.getDurationInWeeks() + " weeks" +
                " | Active: " + course.isActive()
            );
        }
    }

    public Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public boolean toggleCourseStatus(int id) {
        Course course = findCourseById(id);
        if (course == null) {
            return false;
        }
        course.setActive(!course.isActive());
        return true;
    }
}

