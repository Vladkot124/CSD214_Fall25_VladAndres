package bookstore;

import bookstore.pojos.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final String menu = "\n***********************\n"
            + " 1. Add Items\n"
            + " 2. Edit Items\n"
            + " 3. Delete Items\n"
            + " 4. Sell item(s)\n"
            + " 5. List items\n"
            + "99. Quit\n"
            + "***********************\n"
            + "Enter choice: ";

    private final ArrayList<SaleableItem> saleableItems = new ArrayList<>();
    private final Scanner input;
    private final PrintStream out;

    public App() { this(System.in, System.out); }
    public App(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.out = out;
    }

    public void run() {
        populate();
        boolean running = true;
        while (running) {
            out.print(menu);
            String line = input.nextLine().trim();
            int choice;
            try { choice = Integer.parseInt(line); } catch (Exception e) { out.println("Invalid choice."); continue; }
            switch (choice) {
                case 1 -> addItem();
                case 2 -> editItem();
                case 3 -> deleteItem();
                case 4 -> sellItem();
                case 5 -> listAll();
                case 99 -> { out.println("Goodbye"); running = false; }
                default -> out.println("Unknown choice.");
            }
        }
    }

    public void populate() {
        saleableItems.add(Util.getFakeBook());
        saleableItems.add(Util.getFakeMagazine());
        saleableItems.add(Util.getFakeDiscMag());
        saleableItems.add(Util.getFakeTicket());
    }

    public void addItem() {
        out.println("Add an item: 1=Book 2=Magazine 3=DiscMag 4=Ticket 99=Exit");
        out.print("Enter choice: ");
        int choice = parseInt(input.nextLine(), 99);
        switch (choice) {
            case 1 -> {
                out.print("Title: "); String title = input.nextLine();
                out.print("Author: "); String author = input.nextLine();
                out.print("Price: "); double price = parseDouble(input.nextLine(), 0.0);
                out.print("Copies: "); int copies = parseInt(input.nextLine(), 1);
                out.print("ISBN: "); String isbn = input.nextLine();
                out.print("Description: "); String desc = input.nextLine();
                saleableItems.add(new Book(nextId(), title, price, copies, isbn, desc, author));
                out.println("Book added.");
            }
            case 2 -> {
                out.print("Title: "); String title = input.nextLine();
                out.print("Price: "); double price = parseDouble(input.nextLine(), 0.0);
                out.print("Copies: "); int copies = parseInt(input.nextLine(), 1);
                saleableItems.add(new Magazine(nextId(), title, price, copies, "MAG", "Magazine", 5, LocalDate.now()));
                out.println("Magazine added.");
            }
            case 3 -> {
                saleableItems.add(Util.getFakeDiscMag());
                out.println("DiscMag added.");
            }
            case 4 -> {
                saleableItems.add(Util.getFakeTicket());
                out.println("Ticket added.");
            }
            default -> out.println("Exiting add menu.");
        }
    }

    public void listAll() {
        if (saleableItems.isEmpty()) {
            out.println("No items.");
            return;
        }
        int i = 1;
        for (SaleableItem s : saleableItems) {
            out.printf("%d) %s%n", i++, s.toString());
        }
    }

    public void editItem() {
        listAll();
        out.print("Choose index to edit (99 cancel): ");
        int idx = parseInt(input.nextLine(), 99);
        if (idx == 99 || idx < 1 || idx > saleableItems.size()) return;
        SaleableItem s = saleableItems.get(idx - 1);
        if (s instanceof Book b) {
            out.print("New author (blank to keep): ");
            String a = input.nextLine();
            if (!a.isBlank()) b.setAuthor(a);
        }
        if (s instanceof Publication p) {
            out.print("New price (blank to keep): ");
            String pr = input.nextLine();
            if (!pr.isBlank()) {
                try { double newP = Double.parseDouble(pr); p.setPrice(newP); }
                catch (NumberFormatException e) { out.println("Invalid price input; skipped."); }
            }
        }
        out.println("Updated: " + s);
    }

    public void deleteItem() {
        listAll();
        out.print("Choose index to delete (99 cancel): ");
        int idx = parseInt(input.nextLine(), 99);
        if (idx == 99 || idx < 1 || idx > saleableItems.size()) return;
        SaleableItem removed = saleableItems.remove(idx - 1);
        out.println("Removed: " + removed);
    }

    public void sellItem() {
        listAll();
        out.print("Choose index to sell (99 cancel): ");
        int idx = parseInt(input.nextLine(), 99);
        if (idx == 99 || idx < 1 || idx > saleableItems.size()) return;
        SaleableItem s = saleableItems.get(idx - 1);
        out.print("Quantity to sell: ");
        int q = parseInt(input.nextLine(), 0);
        if (q <= 0) { out.println("Quantity must be positive"); return; }
        if (s.getCopies() < q) { out.println("Not enough copies. Current: " + s.getCopies()); return; }
        s.setCopies(s.getCopies() - q);
        out.println("Sold " + q + ". Remaining: " + s.getCopies());
    }

    private long nextId() {
        long max = 0;
        for (SaleableItem s : saleableItems) {
            if (s instanceof Editable e && e.getId() != null) max = Math.max(max, e.getId());
        }
        return max + 1;
    }

    private static int parseInt(String s, int def) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return def; }
    }

    private static double parseDouble(String s, double def) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return def; }
    }

    // for tests (if needed)
    List<SaleableItem> getSaleableItems() { return saleableItems; }
}
