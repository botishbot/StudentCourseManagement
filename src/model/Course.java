package model;

public class Course {
    private final String courseCode;
    private final String courseTitle;
    private final int courseUnit;

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

    @Override
    public String toString() {
        return "Course{" +
                "code='" + courseCode + '\'' +
                ", title='" + courseTitle + '\'' +
                ", unit=" + courseUnit +
                '}';
    }
}