package csd214_fall2025.pojos;

public class Book extends Publication {

    private String author;

    public Book() {}
    public Book(Long id, String title, double price, int copies, String isbn, String description, String author) {
        super(title, price, copies, isbn, description);
        this.author = author;
    }
    public Book(String title, String author, double price) {
        super(title, price, 0, "", "");
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public void initialize() {
        setTitle("Unknown Title");
        this.author = "Unknown Author";
        setPrice(0.0);
        setCopies(0);
    }

    @Override
    public void edit() {
        System.out.println("Editing book: " + getTitle());
    }

    @Override
    public void sellCopy() {
        int c = getCopies();
        if (c > 0) setCopies(c - 1);
    }

    @Override
    public String toString() {
        return "Book[title=" + getTitle() + ", author=" + author + ", price=" + getPrice() + "]";
    }
}
