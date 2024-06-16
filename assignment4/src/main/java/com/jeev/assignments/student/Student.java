package com.jeev.assignments.student;

public class Student implements Comparable<Student>{
    private long id;
    private String name;
    private int age;
    private String grade;
    private String address;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor with validation
    public Student(long id, String name, int age, String grade, String address) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
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
        setId(id);
        setName(name);
        setAge(age);
        setGrade(grade);
        setAddress(address);
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getAddress() {
        return address;
    }

    // Setters with validation
    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
        this.age = age;
    }

    public void setGrade(String grade) {
        if (grade == null || grade.trim().isEmpty()) {
            throw new IllegalArgumentException("Grade cannot be null or empty.");
        }
        this.grade = grade;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        this.address = address;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (age != student.age) return false;
        if (!name.equals(student.name)) return false;
        if (!grade.equals(student.grade)) return false;
        return address.equals(student.address);
    }

    // hashCode method
    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + grade.hashCode();
        result = 31 * result + address.hashCode();
        return ((int)(result));
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); // Sorting by name
    }
}