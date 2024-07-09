package librarytest;



import org.junit.Before;
import org.junit.Test;

import library.Book;
import library.Library;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "123456789"));
        library.addBook(new Book("1984", "George Orwell", "987654321"));
    }

    @Test
    public void testAddBook() {
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "1122334455"));
        List<Book> allBooks = library.listAllBooks();
        assertEquals(3, allBooks.size());
    }

    @Test
    public void testSearchByTitle() {
        List<Book> searchResults = library.searchByTitle("The Hobbit");
        assertEquals(1, searchResults.size());
        assertEquals("The Hobbit", searchResults.get(0).getTitle());
    }

    @Test
    public void testListAllBooks() {
        List<Book> allBooks = library.listAllBooks();
        assertEquals(2, allBooks.size());
        assertTrue(allBooks.stream().anyMatch(book -> book.getTitle().equals("The Hobbit")));
        assertTrue(allBooks.stream().anyMatch(book -> book.getTitle().equals("1984")));
    }
}

