package com.jeev.assignments;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jeev.assignments.books.Book;
import com.jeev.assignments.library.Library;
import com.jeev.assignments.library.MaxBookLimitReachedException;
import com.jeev.assignments.library.BookNotAvailableException;
import com.jeev.assignments.library.BookNotIssuedException;
import com.jeev.assignments.library.Librarian;
import com.jeev.assignments.members.Member;
import com.jeev.assignments.members.StudentMember;

public class Demo {
    public static List<Book> books = new ArrayList<>();
    public static Library library = new Library();
    public static Librarian librarian = new Librarian("Librarian");
    public static List<Member> members = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Assign library to librarian
            librarian.setLibrary(library);
            displayOptions();

            try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            createBook();
                            break;
                        case 2:
                            createStudentMember();
                            break;
                        case 3:
                            createTeacherMember();
                            break;
                        case 4:
                            listMembers();
                            break;
                        case 5:
                            listBooks();
                            break;
                        case 6:
                            issueBook();
                            break;
                        case 7:
                            removeBook();
                            break;
                        case 8:
                            showMemberInfo();
                            break;
                        case 9:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nERROR: Invalid input. Please enter a number.\n");
                    scanner.nextLine(); // Clear the invalid input
                }
        }
    }

    // Display the menu options to the user
    public static void displayOptions() {
        System.out.println("1. Create a book and add it to the library");
        System.out.println("2. Create a new StudentMember and add as a member of the Library");
        System.out.println("3. Create a new TeacherMember and add as a member of the Library");
        System.out.println("4. List members of the Library");
        System.out.println("5. List books of the Library");
        System.out.println("6. Issue a book to a member");
        System.out.println("7. Remove a book from a member");
        System.out.println("8. Show member info");
        System.out.println("9. Exit");
        System.out.print("\n\nEnter your choice: ");
    }

    // Create a new book and add it to the library
    public static void createBook() {
        System.out.print("\n\nEnter book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book Author: ");
        String author = scanner.nextLine();
        library.addBook(new Book(title, author));
        System.out.println("Book added to the library");
        listBooks();
    }

    // Create a new student member and add to the library
    public static void createStudentMember() {
        System.out.print("\n\nEnter student name: ");
        String name = scanner.nextLine();
        library.addMember(new StudentMember(name));
        System.out.println("Student member added to the library");
        listMembers();
    }

    // Create a new teacher member and add to the library
    public static void createTeacherMember() {
        System.out.print("\n\nEnter teacher name: ");
        String name = scanner.nextLine();
        library.addMember(new StudentMember(name)); // This should be TeacherMember
        System.out.println("Teacher member added to the library.");
        listMembers();
    }

    // List all members of the library
    public static void listMembers() {
        System.out.println("\n\nLibrary Members:");
        members = library.getMembers();
        for (Member member : members) {
            System.out.println(member);
        }
    }

    // List all books in the library
    public static void listBooks() {
        System.out.println("\n\nLibrary Books:");
        books = library.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Issue a book to a member
    public static void issueBook() {
        System.out.print("\n\nEnter Member ID: ");
        int id = scanner.nextInt();
        Member mem = library.getMemberByID(id);
        if (mem == null)
            System.out.println("Invalid Member id\n\n");
        else {
            System.out.print("Enter Book ID: ");
            int bookid = scanner.nextInt();
            Book book = library.getBookByID(bookid);
            if (book == null)
                System.out.println("Invalid book id\n\n");
            else {
                try {
                    library.issueBook(book, mem);
                    System.out.println("Book issued");
                    listBooks();
                } catch (BookNotAvailableException | MaxBookLimitReachedException e) {
                    System.out.println("\n\nERROR: " + e.getMessage() + "\n\n");
                }
            }
        }
    }

    // Remove a book from a member
    public static void removeBook() {
        System.out.print("\n\nEnter Member ID: ");
        int id = scanner.nextInt();
        Member mem = library.getMemberByID(id);
        if (mem == null)
            System.out.println("Invalid Member id\n\n");
        else {
            System.out.println(mem);
            System.out.print("Enter Book ID: ");
            int bookid = scanner.nextInt();
            Book book = library.getBookByID(bookid);
            if (book == null)
                System.out.println("Invalid book id\n\n");
            else {
                try {
                    library.returnBook(book, mem);
                    System.out.println("Book returned");
                    listBooks();
                } catch (BookNotIssuedException e) {
                    System.out.println("\n\nERROR: " + e.getMessage());
                }
            }
        }
    }

    // Show information of a specific member
    public static void showMemberInfo() {
        System.out.print("\n\nEnter Member ID: ");
        int id = scanner.nextInt();
        Member mem = library.getMemberByID(id);
        System.out.println(mem);
    }
}