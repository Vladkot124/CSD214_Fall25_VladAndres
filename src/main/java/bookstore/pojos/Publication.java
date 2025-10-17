package bookstore.pojos;

public class Publication implements SaleableItem {
    private String title;
    private double price;
    private int copies;
    private String isbn;
    private String description;

    public Publication() {}

    public Publication(String title, double price, int copies, String isbn, String description) {
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.isbn = isbn;
        this.description = description;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public int getCopies() { return copies; }
    @Override
    public void setCopies(int copies) { this.copies = copies; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return String.format("%s (ISBN:%s) $%.2f x%d - %s",
                title == null ? "<no title>" : title,
                isbn == null ? "N/A" : isbn,
                price, copies, description == null ? "" : description);
    }
}
