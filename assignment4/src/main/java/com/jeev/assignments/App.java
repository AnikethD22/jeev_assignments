package com.jeev.assignments;

import java.lang.reflect.Member;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jeev.assignments.service.StudentService;
import com.jeev.assignments.student.Student;



public class App {

    public static StudentService studentManager = new StudentService();
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
        System.out.println("5. Display all students");
        System.out.println("6. Exit");
        System.out.print("\n\nEnter your choice: ");
    }

    public static void addStudent() {
        long id = -1;
        try {
            System.out.print("Enter Student ID: ");
            id = scanner.nextLong();
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
            studentManager.createStudent(new Student(id, name, age, grade, address));
            System.out.println("Student added to the Database");
        }catch (SQLIntegrityConstraintViolationException e) {
            // TODO Auto-generated catch block
            System.out.println("\nERROR: Student with the id " + id + " exists. Please enter unique student ID.\n");
            System.err.println(studentManager.getAllStudents());
        }catch (InputMismatchException e) {
            System.out.println("\nERROR: Invalid input. Please enter the correct data type.\n");
            scanner.nextLine(); // Clear the invalid input
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: " + e.getMessage() + "\n");
        } 
    }

    public static void deleteStudent() {
        try {
            System.out.print("Enter the Student ID to delete: ");
            long id = scanner.nextLong();
            studentManager.deleteStudent(id);
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
            long id = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            Student student = studentManager.getStudentById(id);
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
            
            studentManager.updateStudent(new Student(id, name, age, grade, address));
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
            long id = scanner.nextLong();
            Student student = studentManager.getStudentById(id);
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
        System.out.println(studentManager.getAllStudents());
        System.out.print("\n\n");
    }

    public static void displayStudent() {
        try {
            System.out.print("Enter Student ID: ");
            long id = scanner.nextInt();
            Student student = studentManager.getStudentById(id);
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


}