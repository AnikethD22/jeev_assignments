package com.jeev.assignments.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import com.jeev.assignments.student.Student;

public class StudentManager {
    private ArrayList<Student> students;
    private HashMap<Integer, Student> studentMap;
    private TreeSet<Student> sortedStudents;

    /**
     * Constructor that initializes the student manager and loads students from a file.
     * @param filepathString the path to the file containing student data.
     */
    public StudentManager(String filepathString) {
        students = new ArrayList<>();
        studentMap = new HashMap<>();
        sortedStudents = new TreeSet<>();
        loadFromFile(filepathString);
    }

    /**
     * Adds a new student to the manager.
     * @param student the student to be added.
     * @throws IllegalArgumentException if the student is null or a student with the same ID already exists.
     */
    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (studentMap.containsKey(student.getId())) {
            throw new IllegalArgumentException("A student with the same ID already exists.");
        }
        students.add(student);
        studentMap.put(student.getId(), student);
        sortedStudents.add(student);
    }

    /**
     * Removes a student from the manager by ID.
     * @param id the ID of the student to be removed.
     * @throws IllegalArgumentException if the ID is not positive or no student with the ID exists.
     */
    public void removeStudent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        if (!studentMap.containsKey(id)) {
            throw new IllegalArgumentException("No student with the ID exists.");
        }
        Student student = studentMap.get(id);
        
        if (student != null) {
            students.remove(student);
            studentMap.remove(id);
            sortedStudents.remove(student);
        }
    }

    /**
     * Updates the details of an existing student.
     * @param id the ID of the student to be updated.
     * @param name the new name of the student.
     * @param age the new age of the student.
     * @param grade the new grade of the student.
     * @param address the new address of the student.
     * @throws IllegalArgumentException if any of the parameters are invalid.
     */
    public void updateStudent(int id, String name, int age, String grade, String address) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
        if (grade == null || grade.trim().isEmpty()) {
            throw new IllegalArgumentException("Grade cannot be null or empty.");
        }
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }

        Student student = studentMap.get(id);
        if (student != null) {
            sortedStudents.remove(student); // Remove the old student object
            student.setName(name);
            student.setAge(age);
            student.setGrade(grade);
            student.setAddress(address);
            sortedStudents.add(student); // Add the updated student object
        }
    }

    /**
     * Searches for a student by ID.
     * @param id the ID of the student to be searched.
     * @return the student with the given ID.
     * @throws IllegalArgumentException if the ID is not positive or no student with the ID exists.
     */
    public Student searchStudent(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        if (!studentMap.containsKey(id)) {
            throw new IllegalArgumentException("No student with the ID exists.");
        }
        return studentMap.get(id);
    }

    /**
     * Displays all students.
     */
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Displays all students sorted by name.
     */
    public void displaySortedStudents() {
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
    }

    /**
     * Loads students from a file.
     * @param filename the name of the file to load students from.
     */
    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("Failed to create file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("###");
                
                if (data.length != 5) {
                    throw new IllegalArgumentException("Invalid data format in file.");
                }
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String grade = data[3];
                String address = data[4];

                if (id <= 0 || name == null || name.trim().isEmpty() || age <= 0 || grade == null || grade.trim().isEmpty() || address == null || address.trim().isEmpty()) {
                    throw new IllegalArgumentException("Invalid data in file.");
                }

                Student student = new Student(id, name, age, grade, address);
                students.add(student);
                studentMap.put(id, student);
                sortedStudents.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves students to a file.
     * @param filename the name of the file to save students to.
     */
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Student student : students) {
                writer.println(student.getId() + "###" + student.getName() + "###" + student.getAge() + "###" + student.getGrade() + "###" + student.getAddress());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}