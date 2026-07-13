package service;

import model.Course;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Manages all course-related operations including
 * adding, searching, saving, loading,
 * and calculating total course units.
 */
public class CourseManager {

    private final ArrayList<Course> courses;
    private boolean hasUnsavedChanges;

    private static final String FILE_NAME = "data/courses.txt";
    private static final String DELIMITER = ",";

    /**
     * Initializes the course manager with
     * an empty course list.
     */
    public CourseManager() {
        courses = new ArrayList<>();
        hasUnsavedChanges = false;
    }

    /**
     * Adds a new course to the collection.
     * Duplicate course codes are not allowed.
     * @return true if the course is added successfully,
     *         otherwise false.
     */
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

    /**
     * Searches for a course using recursion.
     *
     * @return Matching Course object, or null if not found.
     */
    public Course searchCourse(String courseCode) {
        return recursiveSearch(courseCode, 0);
    }

    /**
     * Recursively searches the course list.
     */
    private Course recursiveSearch(String courseCode, int index) {
        // Base case: end of the list reached
        if (index >= courses.size()) {
            return null;
        }

        Course currentCourse = courses.get(index);

        if (currentCourse.getCourseCode().equals(courseCode)) {
            return currentCourse;
        }
        // Recursive case: continue searching the next course
        return recursiveSearch(courseCode, index + 1);
    }

    /**
     * Calculates the total credit units
     * of all registered courses.
     *
     * @return Total course units.
     */
    public int calculateTotalUnits() {
        int total = 0;

        for (Course course : courses) {
            total += course.getCourseUnit();
        }

        return total;
    }

    /**
     * Saves all courses to the text file.
     *
     * @return true if the save operation succeeds,
     *         otherwise false.
     */
    public boolean saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // Write each course to the file
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

    /**
     * Loads all saved courses from the text file.
     *
     * @return true if loading succeeds,
     *         otherwise false.
     */
    public boolean loadFromFile() {
        // Clear existing courses before loading fresh data
        courses.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            // Read each line and recreate the Course object
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