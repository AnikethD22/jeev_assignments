package com.jeev.assignments.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jeev.assignments.dao.StudentDAO;
import com.jeev.assignments.student.Student;

public class StudentDAOImpl implements StudentDAO {
    private Connection conn;

    public StudentDAOImpl()  {
        try {
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResourceAsStream("db.properties"));
            
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"),properties.getProperty("db.password"));
            
            createTableIfNotExists();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    private void createTableIfNotExists() {
            try (Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE IF NOT EXISTS students (" +
                            "id BIGINT PRIMARY KEY, " +
                            "name VARCHAR(255), " +
                            "age INT, " +
                            "grade VARCHAR(255), " +
                            "address VARCHAR(255)" +
                            ")";
                stmt.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void createStudent(Student student) throws SQLIntegrityConstraintViolationException {
        String sql = "INSERT INTO students (id, name, age, grade, address) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getGrade());
            pstmt.setString(5, student.getAddress());
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Student with the same id exists!");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = null;
        String sql = "SELECT * FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGrade(rs.getString("grade"));
                student.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGrade(rs.getString("grade"));
                student.setAddress(rs.getString("address"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, grade = ?, address = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getGrade());
            pstmt.setString(4, student.getAddress());
            pstmt.setLong(5, student.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
