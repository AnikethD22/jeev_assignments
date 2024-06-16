package com.jeev.assignments.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.jeev.assignments.student.Student;
import com.jeev.assignments.dao.StudentDAO;
import com.jeev.assignments.dao.StudentDAOImpl;

/**
 * Service class for handling student operations.
 */
public class StudentService {
    private StudentDAO studentDAO;

    /**
     * Constructor to initialize StudentDAO.
     */
    public StudentService() {
        this.studentDAO = new StudentDAOImpl();
    }

    /**
     * Creates a new student.
     *
     * @param student The student to be created.
     */
    public void createStudent(Student student) throws SQLIntegrityConstraintViolationException {
        try {
            studentDAO.createStudent(student);
        } catch (SQLIntegrityConstraintViolationException e) {
            // Handle exception
            throw e;
        }catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a student by ID.
     *
     * @param id The ID of the student to retrieve.
     * @return The student with the specified ID.
     */
    public Student getStudentById(Long id) {
        try {
            return studentDAO.getStudentById(id);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves all students.
     *
     * @return A list of all students.
     */
    public List<Student> getAllStudents() {
        try {
            return studentDAO.getAllStudents();
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates an existing student.
     *
     * @param student The student to be updated.
     */
    public void updateStudent(Student student) {
        try {
            
            if (student != null) {
                studentDAO.updateStudent(student);
            }

        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    /**
     * Deletes a student by ID.
     *
     * @param id The ID of the student to delete.
     */
    public void deleteStudent(Long id) {
        try {
            studentDAO.deleteStudent(id);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}