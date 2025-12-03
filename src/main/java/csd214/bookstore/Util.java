package csd214.bookstore;

import com.github.javafaker.Faker;
import csd214.bookstore.entities.*;

import java.time.LocalDate;
import java.util.UUID;

public class Util {
    private static final Faker faker = new Faker();
    private static final com.github.javafaker.Book fakeBook = faker.book();
    private static final com.github.javafaker.Number number = faker.number();
    private static final com.github.javafaker.Code code = faker.code();

    public static long newId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public static Book getFakeBook(){
        String title = fakeBook.title();
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        String author = fakeBook.author();
        String isbn = code.isbn10();
        String description = "Book: " + fakeBook.genre();
        return new Book(newId(), title, price, copies, isbn, description, author);
    }

    public static Magazine getFakeMagazine(){
        String title = fakeBook.title();
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        String isbn = code.isbn10();
        String description = "Magazine: " + fakeBook.genre();
        return new Magazine(newId(), title, price, copies, isbn, description, copies, LocalDate.now());
    }

    public static DiscMag getFakeDiscMag(){
        Magazine m = getFakeMagazine();
        boolean hasDisc = new java.util.Random().nextBoolean();
        return new DiscMag(m.getId(), m.getTitle(), m.getPrice(), m.getCopies(), m.getIsbn10(), m.getDescription(),
                m.getOrderQty(), m.getCurrentIssue(), hasDisc);
    }

    public static Ticket getFakeTicket(){
        int n = new java.util.Random().nextInt(9999);
        return new Ticket(newId(), "Ticket for event #" + n, getFakeDoubleBetween(1, 100));
    }

    public static double getFakeDoubleBetween(int min, int max) {
        return number.randomDouble(2, min, max);
    }
}
