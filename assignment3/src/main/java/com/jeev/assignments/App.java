package com.jeev.assignments;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jeev.assignments.manager.StudentManager;
import com.jeev.assignments.student.Student;



public class App {

    private static final String __DATA_FILE__ = "students.dat";
    public static StudentManager studentManager = new StudentManager(__DATA_FILE__);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            displayOptions();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        deleteStudent();
                        break;
                    case 3:
                        editStudent();
                        break;
                    case 4:
                        searchStudent();
                        break;
                    case 5:
                        displayStudents();
                        break;
                    case 6:
                        saveStudentRecords();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for Enter key
            } catch (InputMismatchException e) {
                System.out.println("\nERROR: Invalid input. Please enter a number.\n");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public static void displayOptions() {
        System.out.println("1. Add a new student");
        System.out.println("2. Remove a student by ID");
        System.out.println("3. Update student details by ID");
        System.out.println("4. Search for a student by ID");
        System.out.println("5. Display all students (sorted by chosen attribute)");
        System.out.println("6. Save data and Exit");
        System.out.print("\n\nEnter your choice: ");
    }

    public static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter the Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Student Grade: ");
            String grade = scanner.nextLine();
            System.out.print("Enter Student Address: ");
            String address = scanner.nextLine();
            studentManager.addStudent(new Student(id, name, age, grade, address));
            System.out.println("Student added to the Register");
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid input. Please enter the correct data type.\n");
            scanner.nextLine(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
    }

    public static void deleteStudent() {
        try {
            System.out.print("Enter the Student ID to delete: ");
            int id = scanner.nextInt();
            studentManager.removeStudent(id);
            System.out.println("Student removed from the Register");
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid input. Please enter a number.\n");
            scanner.nextLine(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
    }

    public static void editStudent() {
        try {
            System.out.print("Enter Student ID to edit: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Student student = studentManager.searchStudent(id);
            if (student == null) {
                System.out.println("Student not found.");
                return;
            }
            System.out.print("Enter new Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Student Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new Student Grade: ");
            String grade = scanner.nextLine();
            System.out.print("Enter new Student Address: ");
            String address = scanner.nextLine();
            studentManager.updateStudent(id, name, age, grade, address);
            System.out.println("Student updated");
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid input. Please enter the correct data type.\n");
            scanner.nextLine(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
    }

    public static void searchStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            Student student = studentManager.searchStudent(id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid input. Please enter a number.\n");
            scanner.nextLine(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
    }

    public static void displayStudents() {
        System.out.print("\n\nCurrent registered Students sorted by Name: \n");
        studentManager.displaySortedStudents();
        System.out.print("\n\n");
    }

    public static void displayStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            Student student = studentManager.searchStudent(id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid input. Please enter a number.\n");
            scanner.nextLine(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        }
    }

    public static void saveStudentRecords() {
        System.out.println("\nSaving below listed students to the file");
        displayStudents();
        studentManager.saveToFile(__DATA_FILE__);
        System.out.println("\nData saving complete.");
    }
}