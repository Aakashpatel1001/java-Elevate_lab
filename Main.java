import java.util.Scanner;
import java.util.ArrayList;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Issued: " + isIssued);
    }
}


class User {
    String name;
    int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public void displayInfo() {
        System.out.println("User ID: " + userId + ", Name: " + name);
    }
}




class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.title);
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued: " + title);
                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned: " + title);
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showAllBooks() {
        System.out.println("\nLibrary Collection:");
        for (Book book : books) {
            book.displayInfo();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

    
        library.addBook(new Book("Java Basics", "John"));
        library.addBook(new Book("Python 101", "Jane"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show all books");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    library.showAllBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

