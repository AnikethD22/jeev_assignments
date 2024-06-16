package com.jeev.assignments.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import com.jeev.assignments.student.Student;

public interface StudentDAO {
    void createStudent(Student student) throws SQLIntegrityConstraintViolationException;
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    void updateStudent(Student student);
    void deleteStudent(Long id);
}