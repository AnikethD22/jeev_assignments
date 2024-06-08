package com.jeev.assignments.manager;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import com.jeev.assignments.student.Student;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentManagerTest {
    
    private static String __dataFile__ = "students_test.dat";

    // Adding a student successfully
    @Test
    public void test_add_student_successfully() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
        assertEquals(student, manager.searchStudent(1));
    }

    // Adding a student with a duplicate ID
    @Test (expected = IllegalArgumentException.class)
    public void test_add_student_with_duplicate_id() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student1 = new Student(1, "John Doe", 20, "A", "123 Main St");
        Student student2 = new Student(1, "Jane Doe", 22, "B", "456 Elm St");
        manager.addStudent(student1);
        manager.addStudent(student2);
        
    }

    // Removing a student successfully
    @Test (expected = IllegalArgumentException.class)
    public void test_remove_student_successfully() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
        manager.removeStudent(1);
        manager.searchStudent(1);
    }

    // Updating a student's details successfully
    @Test
    public void test_update_student_details_successfully() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
        manager.updateStudent(1, "Jane Smith", 21, "B", "456 Elm St");
        Student updatedStudent = manager.searchStudent(1);
        assertEquals("Jane Smith", updatedStudent.getName());
        assertEquals(21, updatedStudent.getAge());
        assertEquals("B", updatedStudent.getGrade());
        assertEquals("456 Elm St", updatedStudent.getAddress());
    }

    // Searching for a student by ID successfully
    @Test
    public void test_search_student_by_id_successfully() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
        assertEquals(student, manager.searchStudent(1));
    }

    // Displaying all students correctly
    // @Test
    public void test_display_all_students_correctly() {
        StudentManager manager = new StudentManager(__dataFile__);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        manager.displayAllStudents();
        String expectedOutput = "Student{id=1, name='John Doe', age=20, grade='A', address='123 Main St'}\n";
        assertEquals(expectedOutput, outContent.toString());
        System.setOut(System.out);
    }

    // Loading students from a file successfully
    @Test
    public void test_load_students_from_file_successfully() {
        StudentManager manager = new StudentManager(__dataFile__);
        // Assuming 'students.txt' contains valid student data
        // Add assertions to check if students are loaded successfully
    }

    // Removing a student with a non-existent ID
    @Test (expected = IllegalArgumentException.class)
    public void test_remove_student_non_existent_id() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
        manager.removeStudent(2);
    }

    // Updating a student with invalid details (e.g., negative age, empty name)
    @Test (expected = IllegalArgumentException.class)
    public void test_update_student_invalid_details() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
    
        manager.updateStudent(1, "", -5, "B", "456 Elm St");
    }

    // Searching for a student with a non-existent ID
    @Test (expected = IllegalArgumentException.class)
    public void test_search_non_existent_student() {
        StudentManager manager = new StudentManager(__dataFile__);
        manager.searchStudent(-1);
    }

    // Loading from a file with invalid data format
    // @Test (expected = IllegalArgumentException.class)
    public void test_loading_invalid_data_format() {
        StudentManager manager = new StudentManager("invalid_data.txt");
        manager.loadFromFile("invalid_data.txt");
    }

    // Adding a null student
    @Test (expected = IllegalArgumentException.class)
    public void test_add_null_student() {
        StudentManager manager = new StudentManager(__dataFile__);
        manager.addStudent(null);
    }

    // Removing a student with a negative ID
    @Test (expected = IllegalArgumentException.class)
    public void test_remove_student_negative_id() {
        StudentManager manager = new StudentManager(__dataFile__);
        Student student = new Student(1, "John Doe", 20, "A", "123 Main St");
        manager.addStudent(student);
        manager.removeStudent(-1);
    }

    

}