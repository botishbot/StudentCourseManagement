package ui;

import java.util.Scanner;
import service.CourseManager;
import model.Course;
import java.util.ArrayList;

public class ConsoleUi {

    private static final String APP_TITLE = "STUDENT COURSE MANAGEMENT SYSTEM";
    private static final String MENU_PROMPT = "Enter your choice: ";

    private final Scanner scanner;
    private final CourseManager manager;

    public ConsoleUi() {
        scanner = new Scanner(System.in);
        manager = new CourseManager();
    }

    private void displayMenu() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("          " + APP_TITLE);
        System.out.println("============================================================");
        System.out.println();

        System.out.println("Courses Loaded : " + manager.getCourseCount());
        System.out.println("Data File      : " + manager.getFileName());
        System.out.println();

        System.out.println("------------------------------------------------------------");
        System.out.println("1. Add Course");
        System.out.println("2. View All Courses");
        System.out.println("3. Search Course");
        System.out.println("4. Calculate Total Units");
        System.out.println("5. Save Courses");
        System.out.println("6. Load Courses");
        System.out.println("7. Exit");
        System.out.println("------------------------------------------------------------");

        System.out.print(MENU_PROMPT);

    }

    private int getMenuChoice() {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <=7) {
                    return choice;
                }
                System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                System.out.print("Enter your choice: ");
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine();
                System.out.print(MENU_PROMPT);
            }
        }
    }

    public void start() {
        boolean running = true;

        while (running) {
            displayMenu();

            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    addCourseUI();
                    break;

                case 2:
                    viewCoursesUI();
                    break;

                case 3:
                    searchCourseUI();
                    break;

                case 4:
                    calculateTotalUnitsUI();
                    break;

                case 5:
                    saveCoursesUI();
                    break;

                case 6:
                    loadCoursesUI();
                    break;

                case 7:
                    running = exitApplicationUI();
                    break;

                default:
                    break;
            }
        }
    }

    private void addCourseUI() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                     ADD COURSE");
        System.out.println("============================================================");
        System.out.println();

        System.out.print("Course Code: ");
        String code = scanner.nextLine().trim().toUpperCase();

        System.out.print("Course Title: ");
        String title = scanner.nextLine().trim();

        int units;

        while (true) {
            System.out.print("Course Units: ");

            try {
                units = Integer.parseInt(scanner.nextLine());

                if (units <= 0) {
                    System.out.println("Units must be greater than zero.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        Course course = new Course(code, title, units);

        if (manager.addCourse(course)) {
            System.out.println("\nCourse added successfully.");
        } else {
            System.out.println("\nA course with that code already exists.");
        }
    }

    private void viewCoursesUI() {
        System.out.println();
        System.out.println("============================================================");
        System.out.println("                    ALL COURSES");
        System.out.println("============================================================");
        System.out.println();

        ArrayList<Course> courseList = manager.getAllCourses();

        if (courseList.isEmpty()) {

            System.out.println("No courses have been added yet.");
            System.out.println();
            System.out.print("Press Enter to return to the main menu...");
            scanner.nextLine();
            return;

        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-35s %-5s%n",
                "S/N", "Code", "Course Title", "Units");
        System.out.println("--------------------------------------------------------------------------");

        int serialNumber = 1;
        for (Course course : courseList) {
            System.out.printf("%-5d %-15s %-35s %-5d%n",
                    serialNumber,
                    course.getCourseCode(),
                    course.getCourseTitle(),
                    course.getCourseUnit());

            serialNumber++;
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total Courses: " + courseList.size());
        System.out.println();

        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private void searchCourseUI() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                    SEARCH COURSE");
        System.out.println("============================================================");
        System.out.println();

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine().trim().toUpperCase();
        System.out.println();

        Course course = manager.searchCourse(courseCode);

        if (course == null) {

            System.out.println("Course not found.");
            System.out.println();
            System.out.print("Press Enter to return to the main menu...");
            scanner.nextLine();
            return;

        }

        System.out.println("------------------------------------------------------------");
        System.out.println("Course Found");
        System.out.println("------------------------------------------------------------");

        System.out.printf("%-15s : %s%n", "Course Code", course.getCourseCode());
        System.out.printf("%-15s : %s%n", "Course Title", course.getCourseTitle());
        System.out.printf("%-15s : %d%n", "Units", course.getCourseUnit());

        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private void calculateTotalUnitsUI() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("               CALCULATE TOTAL UNITS");
        System.out.println("============================================================");
        System.out.println();

        if (manager.getCourseCount() == 0) {

            System.out.println("No courses have been added yet.");
            System.out.println();
            System.out.print("Press Enter to return to the main menu...");
            scanner.nextLine();
            return;

        }

        int totalUnits = manager.calculateTotalUnits();

        System.out.printf("%-28s : %d%n",
                "Total Registered Courses",
                manager.getCourseCount());

        System.out.printf("%-28s : %d%n",
                "Total Credit Units",
                totalUnits);

        System.out.println();

        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private void saveCoursesUI() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                    SAVE COURSES");
        System.out.println("============================================================");
        System.out.println();

        System.out.println("Saving courses...");
        System.out.println();

        if (manager.saveToFile()) {
            System.out.println("Courses saved successfully.");
        } else {
            System.out.println("Failed to save courses.");
        }
        System.out.println();

        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private void loadCoursesUI() {

        System.out.println();
        System.out.println("============================================================");
        System.out.println("                    LOAD COURSES");
        System.out.println("============================================================");
        System.out.println();

        System.out.println("Loading courses...");
        System.out.println();

        if (manager.loadFromFile()) {
            System.out.println("Courses loaded successfully.");
            System.out.printf("%-18s : %d%n",
                    "Courses Loaded",
                    manager.getCourseCount());
        } else {
            System.out.println("Failed to load courses.");
        }
        System.out.println();

        System.out.printf("%-18s : %d%n",
                "Courses Loaded",
                manager.getCourseCount());

        System.out.println();

        System.out.print("Press Enter to return to the main menu...");
        scanner.nextLine();
    }

    private boolean exitApplicationUI() {
        if (manager.hasUnsavedChanges()) {

            System.out.println();
            System.out.println("============================================================");
            System.out.println("                     Exit Application");
            System.out.println("============================================================");
            System.out.println();

            System.out.println("You have unsaved changes.");
            String answer;

            while (true) {

                System.out.print("Save before exiting? (Y/N): ");
                answer = scanner.nextLine().trim().toUpperCase();

                if (answer.equals("Y") || answer.equals("N")) {
                    break;
                }

                System.out.println("Invalid choice. Please enter Y or N.");
                System.out.println();
            }

            if (answer.equals("Y")) {

                System.out.println();

                if (manager.saveToFile()) {
                    System.out.println("Courses saved successfully.");
                } else {
                    System.out.println("Failed to save courses.");
                }
            }
        }

        System.out.println();
        System.out.println("Thank you for using the Student Course Management System.");
        return false;
    }
}
