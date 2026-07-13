package model;

/**
 * Represents a course with its code, title and credit unit.
 */
public class Course {
    private final String courseCode;
    private final String courseTitle;
    private final int courseUnit;

    /**
     * Creates a new course object.
     */
    public Course(String courseCode, String courseTitle, int courseUnit) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseUnit = courseUnit;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    /**
     * Returns a readable representation of the course.
     * Useful for debugging and testing.
     */
    @Override
    public String toString() {
        return "Course{" +
                "code='" + courseCode + '\'' +
                ", title='" + courseTitle + '\'' +
                ", unit=" + courseUnit +
                '}';
    }
}