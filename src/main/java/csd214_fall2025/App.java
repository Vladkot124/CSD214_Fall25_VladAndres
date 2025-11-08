package csd214_fall2025;

import csd214_fall2025.entites.*;
import csd214_fall2025.pojos.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {

    public static void run() {

        // ====== POJO TESTS ======
        System.out.println("=== POJO TESTS ===");

        Book myBook = new Book("1984", "George Orwell", 15.99);
        myBook.initialize();
        myBook.sellCopy();
        System.out.println("POJO Book created: " + myBook);

        Ticket myTicket = new Ticket("Concert", 50.0, 100, LocalDate.of(2025, 12, 25));
        myTicket.initialize();
        myTicket.sellCopy();
        System.out.println("POJO Ticket created: " + myTicket);


        // ====== ENTITY TESTS ======
        System.out.println("\n=== ENTITY TESTS ===");

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("1984");
        bookEntity.setAuthor("George Orwell");
        bookEntity.setPrice(19.99);
        bookEntity.setCopies(10);
        bookEntity.setIsbn("0123456789");
        System.out.println("Entity Book created: " + bookEntity);

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTitle("Concert");
        ticketEntity.setEvent("Music Festival");
        ticketEntity.setPrice(50.0);
        ticketEntity.setQuantity(100);
        ticketEntity.setDate(LocalDate.of(2025, 12, 25));
        System.out.println("Entity Ticket created: " + ticketEntity);


        // ====== INVERSION OF CONTROL (IoC) DEMO ======
        System.out.println("\n=== Inversion of Control Demo ===");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        // Here we choose which repository to use:
        // (You can easily change this line to switch DB type)
        ProductRepository<BookEntity> bookRepo = new MySQLBookRepository(em);
        // For H2 test, replace above line with:
        // ProductRepository<BookEntity> bookRepo = new H2BookRepository(em);

        ProductService<BookEntity> bookService = new ProductService<>(bookRepo);

        // --- Add a sample book ---
        BookEntity newBook = new BookEntity();
        newBook.setTitle("IoC Example");
        newBook.setAuthor("Test Author");
        newBook.setPrice(9.99);
        newBook.setCopies(3);

        bookService.add(newBook);

        // --- List all books ---
        System.out.println("Books in DB: " + bookService.getAll());

        em.close();
        emf.close();

        System.out.println("\n=== IoC Demo Completed ===");
    }

    public static void main(String[] args) {
        run();
    }
}
