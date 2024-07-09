package library;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (option) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Book> searchResults = library.searchByTitle(searchTitle);
                    for (Book book : searchResults) {
                        System.out.println(book);
                    }
                    break;
                case 3:
                    List<Book> allBooks = library.listAllBooks();
                    for (Book book : allBooks) {
                        System.out.println(book);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
