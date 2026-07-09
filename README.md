#  Student Course Management System

> A clean, modular Java console application for managing academic courses with persistent file storage, recursive searching, and a user-friendly menu-driven interface.

![Java](https://img.shields.io/badge/Java-21+-orange?style=for-the-badge)
![Platform](https://img.shields.io/badge/Platform-Cross--Platform-blue?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Stable-success?style=for-the-badge)

---

## 📖 Overview

The **Student Course Management System** is a lightweight Java console application designed to simplify the management of academic course records.

Users can add new courses, search for existing courses, view all registered courses, calculate the total number of credit units, and save or load course information using a persistent text file.

The application follows a modular architecture that separates the data model, business logic, and user interface, making the codebase easier to understand, maintain, and extend.

Whether you're learning Java, exploring object-oriented programming, or looking for a simple reference implementation of a console-based CRUD application with file persistence, this project provides a practical and easy-to-follow example.

---

## ✨ Features

- ✅ Add new courses
- ✅ Prevent duplicate course codes
- ✅ View all registered courses
- ✅ Search courses by code using recursion
- ✅ Calculate total registered credit units
- ✅ Save course records to a text file
- ✅ Load saved course records
- ✅ Input validation for user entries
- ✅ Unsaved changes detection before exit
- ✅ Clean, menu-driven console interface
- ✅ Modular and maintainable project structure

---

## 🖼️ Screenshots

### Main Menu

The application's central dashboard provides quick access to every feature through a simple numbered menu.

![Main Menu](screenshots/main-menu.png)

---

### Add Course

Register a new course by entering its code, title, and credit units. Duplicate course codes are automatically rejected.

![Add Course](screenshots/add-course.png)

---

### View All Courses

Display every registered course in a neatly formatted table showing the course code, title, and credit units.

![View Courses](screenshots/view-courses.png)

---

### Search Course

Locate any registered course using its course code. This feature is powered by a recursive search algorithm.

![Search Course](screenshots/search-course.png)

---

### Calculate Total Units

Instantly calculate the total number of registered courses and the combined credit units.

![Total Units](screenshots/total-units.png)

---

### Save Courses

Save all registered courses to persistent storage for future use.

![Save Courses](screenshots/save-courses.png)

---

### Load Courses

Reload previously saved courses into the application.

![Load Courses](screenshots/load-courses.png)

---

### Unsaved Changes Detection

Before closing the application, users are prompted to save any unsaved changes, helping prevent accidental data loss.

![Unsaved Changes](screenshots/unsaved-changes.png)

---

## 🛠️ Technologies

- Java Development Kit (JDK) 21 or newer
- Object-Oriented Programming (OOP)
- Java Collections (`ArrayList`)
- File Handling (`BufferedReader`, `BufferedWriter`)
- Exception Handling
- Recursion
- IntelliJ IDEA
- Git & GitHub

---

## 🚀 Getting Started

This guide will help you set up and run the project on your local machine. Whether you're new to Java or an experienced developer, you should be able to get the application running in just a few minutes.

## 📋 Requirements

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK) 21 or newer**
- **Git** (optional, for cloning the repository)
- A terminal or command prompt
- *(Optional)* IntelliJ IDEA Community or Ultimate Edition

To verify that Java is installed correctly, run:

```bash
java --version
```

If Java is installed, your terminal will display the installed JDK version.

---

## 📥 Download the Project

There are two ways to obtain the project.

### Option 1 — Clone the Repository

```bash
git clone https://github.com/botishbot/StudentCourseManagement.git
```

Navigate into the project folder:

```bash
cd StudentCourseManagement
```

---

### Option 2 — Download ZIP

1. Open this repository on GitHub.
2. Click the green **Code** button.
3. Select **Download ZIP**.
4. Extract the archive.
5. Open the extracted project folder.

---

## ▶ Running the Application

### Method 1 — IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **Open**.
3. Choose the project folder.
4. Allow IntelliJ to index the project.
5. Open `src/Main.java`.
6. Click **Run**.

---

### Method 2 — Using the Terminal

Compile the project:

```bash
javac -d out src/Main.java src/model/*.java src/service/*.java src/ui/*.java
```

Run the application:

```bash
java -cp out Main
```

> **Note**
>
> Run the application from the **project root directory**. Running it from inside the `out` folder may prevent the application from locating the `data/courses.txt` file.

---

## 💻 Using the Application

After launching the program, a menu-driven interface will appear.

Simply choose the corresponding menu number to perform an operation such as:

- Add a new course
- View all registered courses
- Search for a course
- Calculate total credit units
- Save courses
- Load previously saved courses
- Exit the application

Input prompts guide you through each operation, making the application easy to use without prior experience.

---

# 🧠 Design Highlights

The project was designed with simplicity, modularity, and maintainability in mind. Each package has a clearly defined responsibility, making the codebase easier to understand and extend.

### Object-Oriented Design

The application follows object-oriented programming principles by separating the data model, business logic, and user interface into independent components.

### Modular Architecture

The project is organized into dedicated packages (`model`, `service`, and `ui`) to promote clean code and separation of concerns.

### Recursive Search

Course searching is implemented recursively, demonstrating an alternative approach to traversing collections while keeping the implementation concise.

### File Persistence

Course records can be saved to and loaded from a text file, allowing data to persist between application sessions.

### Input Validation

User input is validated throughout the application to reduce invalid entries and improve the overall user experience.

### Unsaved Changes Detection

The application tracks modifications made during runtime and reminds the user to save before exiting, helping prevent accidental data loss.

---

# 📁 Project Structure

```
StudentCourseManagement/
│
├── data/
│   └── courses.txt
│
├── screenshots/
│
├── src/
│   ├── model/
│   │   └── Course.java
│   │
│   ├── service/
│   │   └── CourseManager.java
│   │
│   ├── ui/
│   │   └── ConsoleUi.java
│   │
│   └── Main.java
│
├── LICENSE
└── README.md
```

### Package Overview

| Package | Responsibility |
|----------|----------------|
| `model` | Defines the `Course` class and represents application data. |
| `service` | Contains the business logic, including course management, recursion, and file operations. |
| `ui` | Implements the console-based user interface and user interaction. |
| `Main` | Application entry point responsible for starting the program. |

---

# 🚧 Future Improvements

Possible enhancements include:

- Edit existing courses
- Delete registered courses
- Sort courses by code or title
- Database integration
- Graphical User Interface (GUI)
- Export course data to additional formats

The current architecture was intentionally designed to make these enhancements easier to implement in the future.

---

# 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

If you find a bug or have an idea for improving the project, feel free to open an issue or submit a pull request.

---

# 📄 License

This project is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more information.

---

## 👤 Author

**BotishBot**

GitHub: https://github.com/botishbot

If you found this project useful, consider giving it a ⭐ on GitHub.