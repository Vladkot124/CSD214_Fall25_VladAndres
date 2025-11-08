package csd214_fall2025;

import csd214_fall2025.pojos.*;
import java.time.LocalDate;

public class Util {

    public static Book getFakeBook() {
        return new Book(1L, "Effective Java", 45.99, 5, "0134685997", "Java best practices", "Joshua Bloch");
    }

    public static Magazine getFakeMagazine() {
        return new Magazine(2L, "Tech Monthly", 6.99, 10, "MAG-001", "Monthly tech", 5, LocalDate.now());
    }

    public static DiscMag getFakeDiscMag() {
        return new DiscMag(3L, "DiscMag Special", 9.99, 4, "DM-100", "Magazine with disc", 2, LocalDate.now(), true);
    }

    public static Ticket getFakeTicket() {
        return new Ticket("Concert ticket", 59.99, 50, LocalDate.of(2025, 12, 25));
    }
}
