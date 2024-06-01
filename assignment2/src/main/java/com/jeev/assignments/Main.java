package com.jeev.assignments;

import com.jeev.assignments.books.Book;
import com.jeev.assignments.library.Library;
import com.jeev.assignments.library.MaxBookLimitReachedException;
import com.jeev.assignments.library.BookNotAvailableException;
import com.jeev.assignments.library.Librarian;
import com.jeev.assignments.members.StudentMember;
import com.jeev.assignments.members.TeacherMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 1. Take input from user for number of books
        System.out.print("Enter the number of books to create: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        // 1. Create a list of Books
        System.out.println("Creating " + numberOfBooks +" books");

        List<Book> books = new ArrayList<>();
        for (int i = 1; i <= numberOfBooks; i++) {
            books.add(new Book("Book" + i, "Author" + i));
        }

        System.out.println("Creating the Library and adding the created books..");
        // 2. Create a library with the books
        Library library = new Library();
        library.addBooks(books);
        System.out.println("Creating a Librarian and assigning the Library..");
        // 3. Create a librarian for the library
        Librarian librarian = new Librarian("Librarian");
        // Assign the library to the librarian
        librarian.setLibrary(library);

        System.out.println("Creating a StudentMember and adding the membership to the Library..");
        // 4. Create and add a student member and then a teacher member
        StudentMember studentMember = new StudentMember("Student1");
        library.addMember(studentMember);
        System.out.println("Creating a TeacherMember and adding the membership to the Library..");
        TeacherMember teacherMember = new TeacherMember("Teacher1");
        library.addMember(teacherMember);

        // 5. Issue a book to a student member
        try {
            librarian.getLibrary().issueBook(books.get(0),studentMember);
            librarian.getLibrary().issueBook(books.get(1), teacherMember);
        } catch (BookNotAvailableException | MaxBookLimitReachedException e) {
            
            e.printStackTrace();
        }

        // 6. Issue 3 books to Teacher member
        
        scanner.close();

    }
}