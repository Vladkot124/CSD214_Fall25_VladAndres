package csd214.bookstore.entities;

public class Publication extends EditableBase implements SaleableItem {

    private String title;
    private double price;
    private int copies;
    private String isbn10;
    private String description;

    public Publication() { }

    public Publication(long id, String title, double price, int copies, String isbn10, String description) {
        super(id);
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.isbn10 = isbn10;
        this.description = description;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }

    public String getIsbn10() { return isbn10; }
    public void setIsbn10(String isbn10) { this.isbn10 = isbn10; }

    @Override
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Publication{title='" + title + "', price=" + price + ", copies=" + copies +
                ", isbn_10='" + isbn10 + "', description='" + description + "'} " + super.toString();
    }
}
