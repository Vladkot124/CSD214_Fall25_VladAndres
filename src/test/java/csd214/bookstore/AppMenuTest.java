package csd214.bookstore;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AppMenuTest {

    @Test
    void addBook_thenListAll_containsTitle() {
        String input = String.join("\n",
                "1",
                "1",
                "My Title",
                "My Author",
                "5",
                "9.99",
                "99",
                "5",
                "1",
                "99",
                "99"
        ) + "\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        App app = new App(new ByteArrayInputStream(input.getBytes()), new PrintStream(baos));
        app.run();

        String out = baos.toString();
        assertTrue(out.contains("My Title"));
        assertTrue(out.contains("My Author"));
    }

    @Test
    void deleteItem_outputsDeleted() {
        String input = String.join("\n",
                "3",
                "1",
                "99"
        ) + "\n";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        App app = new App(new ByteArrayInputStream(input.getBytes()), new PrintStream(baos));
        app.run();

        assertTrue(baos.toString().contains("Deleted:"));
    }
}
