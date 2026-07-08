package service;

import model.Course;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CourseManager {

    private final ArrayList<Course> courses;
    private boolean hasUnsavedChanges;

    private static final String FILE_NAME = "data/courses.txt";
    private static final String DELIMITER = ",";

    public CourseManager() {
        courses = new ArrayList<>();
        hasUnsavedChanges = false;
    }

    public boolean addCourse(Course course) {
        for (Course existingCourse : courses) {
            if (existingCourse.getCourseCode().equals(course.getCourseCode())) {
                return false;
            }
        }

        courses.add(course);
        hasUnsavedChanges = true;
        return true;
    }

    public ArrayList<Course> getAllCourses() {
        return courses;
    }

    public Course searchCourse(String courseCode) {
        return recursiveSearch(courseCode, 0);
    }

    private Course recursiveSearch(String courseCode, int index) {
        if (index >= courses.size()) {
            return null;
        }

        Course currentCourse = courses.get(index);

        if (currentCourse.getCourseCode().equals(courseCode)) {
            return currentCourse;
        }

        return recursiveSearch(courseCode, index + 1);
    }

    public int calculateTotalUnits() {
        int total = 0;

        for (Course course : courses) {
            total += course.getCourseUnit();
        }

        return total;
    }

    public boolean saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Course course : courses) {
                writer.write(
                        course.getCourseCode() + DELIMITER +
                            course.getCourseTitle() + DELIMITER +
                            course.getCourseUnit()
                );

                writer.newLine();
            }

            hasUnsavedChanges = false;
            return true;

        } catch (IOException e) {
            System.out.println("Error saving courses: " + e.getMessage());
            return false;
        }
    }

    public boolean loadFromFile() {
        courses.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(DELIMITER);

                Course course = new Course(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2])
                );

                courses.add(course);
            }

            hasUnsavedChanges = false;
            return true;

        } catch (IOException e) {
            System.out.println("Error loading courses: " + e.getMessage());
            return false;
        }
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getFileName() {
        return FILE_NAME;
    }

    public boolean hasUnsavedChanges() {
        return hasUnsavedChanges;
    }
}