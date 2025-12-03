package csd214.bookstore;

import csd214.bookstore.entities.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;
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

    public App() {
        this(System.in, System.out);
    }

    public App(InputStream in, PrintStream out) {
        this.input = new Scanner(in);
        this.out = out;
        populate();
    }

    public void run() {
        int choice;
        do {
            out.print(menu);
            choice = readInt();
            switch (choice) {
                case 1 -> addItem();
                case 2 -> editItem();
                case 3 -> deleteItem();
                case 4 -> sellItem();
                case 5 -> listAny();
                case 99 -> out.println("Bye!");
                default -> out.println("Invalid choice.");
            }
        } while (choice != 99);
    }

    public boolean findItemExists(SaleableItem item) {
        return findItem(item) != null;
    }

    public SaleableItem findItem(SaleableItem item) {
        if (item == null) return null;

        if (item instanceof Editable e && e.getId() != null) {
            for (SaleableItem si : saleableItems) {
                if (si instanceof Editable ee && Objects.equals(ee.getId(), e.getId())) return si;
            }
            return null;
        }

        for (SaleableItem si : saleableItems) {
            if (si.equals(item)) return si;
        }
        return null;
    }

    public void editItem() {
        if (saleableItems.isEmpty()) {
            out.println("No items to edit.");
            return;
        }

        out.println("\nEdit an item\n");
        listAllNumbered();
        out.print("\nChoose an item to edit or 99 to exit:\n\n");

        int choice = readInt();
        if (choice == 99) return;
        if (choice < 1 || choice > saleableItems.size()) {
            out.println("Invalid item.");
            return;
        }

        SaleableItem chosen = saleableItems.get(choice - 1);
        if (chosen instanceof Editable editable) {
            editItem(editable);
        } else {
            out.println("That item is not editable.");
        }
    }

    public void editItem(Editable item) {
        if (item instanceof Book b) {
            out.println("Edit Title (" + b.getTitle() + " [enter for no changes])");
            String title = readLineAllowEmpty();
            if (!title.isBlank()) b.setTitle(title);

            out.println("Edit Author (" + b.getAuthor() + " [enter for no changes])");
            String author = readLineAllowEmpty();
            if (!author.isBlank()) b.setAuthor(author);

            out.println("Edit copies (" + b.getCopies() + " [enter for no changes])");
            String copies = readLineAllowEmpty();
            if (!copies.isBlank()) b.setCopies(parseIntSafe(copies, b.getCopies()));

            out.println("Edit price (" + b.getPrice() + " [enter for no changes])");
            String price = readLineAllowEmpty();
            if (!price.isBlank()) b.setPrice(parseDoubleSafe(price, b.getPrice()));

        } else if (item instanceof Magazine m && !(item instanceof DiscMag)) {

            out.println("Edit Title (" + m.getTitle() + " [enter for no changes])");
            String title = readLineAllowEmpty();
            if (!title.isBlank()) m.setTitle(title);

            out.println("Edit copies (" + m.getCopies() + " [enter for no changes])");
            String copies = readLineAllowEmpty();
            if (!copies.isBlank()) m.setCopies(parseIntSafe(copies, m.getCopies()));

            out.println("Edit price (" + m.getPrice() + " [enter for no changes])");
            String price = readLineAllowEmpty();
            if (!price.isBlank()) m.setPrice(parseDoubleSafe(price, m.getPrice()));

        } else if (item instanceof DiscMag dm) {

            out.println("Edit Title (" + dm.getTitle() + " [enter for no changes])");
            String title = readLineAllowEmpty();
            if (!title.isBlank()) dm.setTitle(title);

            out.println("Edit copies (" + dm.getCopies() + " [enter for no changes])");
            String copies = readLineAllowEmpty();
            if (!copies.isBlank()) dm.setCopies(parseIntSafe(copies, dm.getCopies()));

            out.println("Edit price (" + dm.getPrice() + " [enter for no changes])");
            String price = readLineAllowEmpty();
            if (!price.isBlank()) dm.setPrice(parseDoubleSafe(price, dm.getPrice()));

            out.println("Has Disc (" + dm.isHasDisc() + " [enter for no changes])");
            String hasDisc = readLineAllowEmpty();
            if (!hasDisc.isBlank()) dm.setHasDisc(hasDisc.trim().equalsIgnoreCase("true") || hasDisc.trim().equalsIgnoreCase("yes"));

        } else if (item instanceof Ticket t) {

            out.println("Edit Description (" + t.getDescription() + " [enter for no changes])");
            String desc = readLineAllowEmpty();
            if (!desc.isBlank()) t.setDescription(desc);

            out.println("Edit price (" + t.getPrice() + " [enter for no changes])");
            String price = readLineAllowEmpty();
            if (!price.isBlank()) t.setPrice(parseDoubleSafe(price, t.getPrice()));

        } else {
            out.println("No edit rules for: " + item.getClass().getSimpleName());
        }
    }

    public void deleteItem() {
        if (saleableItems.isEmpty()) {
            out.println("No items to delete.");
            return;
        }
        out.println("\nDelete an item\n");
        listAllNumbered();
        out.print("\nChoose an item to delete or 99 to exit:\n\n");

        int choice = readInt();
        if (choice == 99) return;
        if (choice < 1 || choice > saleableItems.size()) {
            out.println("Invalid item.");
            return;
        }
        SaleableItem removed = saleableItems.remove(choice - 1);
        out.println("Deleted: " + removed);
    }

    public void populate() {
        saleableItems.clear();
        saleableItems.add(Util.getFakeBook());
        saleableItems.add(Util.getFakeMagazine());
        saleableItems.add(Util.getFakeDiscMag());
        saleableItems.add(Util.getFakeTicket());
        saleableItems.add(Util.getFakeBook());
        saleableItems.add(Util.getFakeMagazine());
        saleableItems.add(Util.getFakeDiscMag());
        saleableItems.add(Util.getFakeTicket());
    }

    public void listAny() {
        out.println("\nAll Items\n-----------\n");
        out.println("List");
        out.println("1. All");
        out.println("2. Books");
        out.println("3. Magazines");
        out.println("4. DiscMags");
        out.println("5. Tickets");
        out.println("99. Exit\n");

        int choice = readInt();
        switch (choice) {
            case 1 -> listI(saleableItems);
            case 2 -> listI(saleableItems.stream().filter(x -> x instanceof Book).toList());
            case 3 -> listI(saleableItems.stream().filter(x -> x instanceof Magazine && !(x instanceof DiscMag)).toList());
            case 4 -> listI(saleableItems.stream().filter(x -> x instanceof DiscMag).toList());
            case 5 -> listI(saleableItems.stream().filter(x -> x instanceof Ticket).toList());
            case 99 -> { }
            default -> out.println("Invalid list choice.");
        }
    }

    public SaleableItem getItem(SaleableItem template) {
        if (template instanceof Book) {
            out.println("Enter Title:");
            String title = readLineRequired();
            out.println("Enter Author:");
            String author = readLineRequired();
            out.println("Enter copies:");
            int copies = readInt();
            out.println("Enter price:");
            double price = readDouble();
            return new Book(Util.newId(), title, price, copies, null, null, author);
        }
        if (template instanceof Magazine && !(template instanceof DiscMag)) {
            out.println("Enter Title:");
            String title = readLineRequired();
            out.println("Enter copies:");
            int copies = readInt();
            out.println("Enter price:");
            double price = readDouble();
            return new Magazine(Util.newId(), title, price, copies, null, "Magazine", copies, java.time.LocalDate.now());
        }
        if (template instanceof DiscMag) {
            out.println("Enter Title:");
            String title = readLineRequired();
            out.println("Enter copies:");
            int copies = readInt();
            out.println("Enter price:");
            double price = readDouble();
            out.println("Has disc? (true/false)");
            String hasDisc = readLineRequired();
            boolean hd = hasDisc.trim().equalsIgnoreCase("true") || hasDisc.trim().equalsIgnoreCase("yes");
            return new DiscMag(Util.newId(), title, price, copies, null, "DiscMag", copies, java.time.LocalDate.now(), hd);
        }
        if (template instanceof Ticket) {
            out.println("Enter ticket description:");
            String desc = readLineRequired();
            out.println("Enter price:");
            double price = readDouble();
            return new Ticket(Util.newId(), desc, price);
        }
        return null;
    }

    public void sellItem() {
        if (saleableItems.isEmpty()) {
            out.println("No items to sell.");
            return;
        }

        out.println("\nSell an item\n");
        listAllNumbered();
        out.print("\nChoose an item to sell or 99 to exit:\n\n");

        int choice = readInt();
        if (choice == 99) return;
        if (choice < 1 || choice > saleableItems.size()) {
            out.println("Invalid item.");
            return;
        }

        SaleableItem chosen = saleableItems.get(choice - 1);

        if (chosen instanceof Publication p) {
            out.println("How many copies to sell? (available: " + p.getCopies() + ")");
            int qty = readInt();

            if (qty <= 0) {
                out.println("Quantity must be > 0.");
                return;
            }
            if (qty > p.getCopies()) {
                out.println("Not enough copies.");
                return;
            }

            p.setCopies(p.getCopies() - qty);
            out.println("Sold " + qty + " copies. Remaining: " + p.getCopies());
        } else if (chosen instanceof Ticket) {
            saleableItems.remove(chosen);
            out.println("Sold ticket and removed from inventory.");
        } else {
            out.println("Cannot sell this item type.");
        }
    }

    public void listI(Object listOrItem) {
        if (listOrItem instanceof java.util.List<?> list) {
            if (list.isEmpty()) {
                out.println("(none)");
                return;
            }

            int i = 1;
            for (Object obj : list) {
                out.println(i + ". " + obj);
                out.println();
                i++;
            }
            return;
        }
        out.println(String.valueOf(listOrItem));
    }

    public void addItem() {
        out.println("\nAdd an item\n");

        int choice;
        do {
            out.println("1. Add Book");
            out.println("2. Add Magazine");
            out.println("3. Add DiscMag");
            out.println("4. Add Ticket");
            out.println("99. Exit\n");

            choice = readInt();
            switch (choice) {
                case 1 -> addItem(new Book());
                case 2 -> addItem(new Magazine());
                case 3 -> addItem(new DiscMag());
                case 4 -> addItem(new Ticket());
                case 99 -> { }
                default -> out.println("Invalid choice.");
            }
        } while (choice != 99);
    }

    public void addItem(SaleableItem item) {
        SaleableItem created = getItem(item);
        if (created == null) {
            out.println("Could not create item.");
            return;
        }
        saleableItems.add(created);
    }

    private void listAllNumbered() {
        int i = 1;
        for (SaleableItem si : saleableItems) {
            out.println(i + ". " + si);
            out.println();
            i++;
        }
    }

    private int readInt() {
        while (true) {
            String s = readLineRequired();
            try {
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                out.println("Please enter an integer:");
            }
        }
    }

    private double readDouble() {
        while (true) {
            String s = readLineRequired();
            try {
                return Double.parseDouble(s.trim());
            } catch (NumberFormatException e) {
                out.println("Please enter a number:");
            }
        }
    }

    private String readLineRequired() {
        String s = input.nextLine();
        while (s == null || s.trim().isEmpty()) {
            s = input.nextLine();
        }
        return s;
    }

    private String readLineAllowEmpty() {
        return input.nextLine();
    }

    private int parseIntSafe(String s, int fallback) {
        try { return Integer.parseInt(s.trim()); } catch (Exception e) { return fallback; }
    }

    private double parseDoubleSafe(String s, double fallback) {
        try { return Double.parseDouble(s.trim()); } catch (Exception e) { return fallback; }
    }
}
