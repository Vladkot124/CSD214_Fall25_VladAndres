package csd214_fall2025.pojos;

import java.util.Objects;

/**
 * POJO Publication (not entity)
 */
public class Publication extends Product {
    private String title;
    private double price;
    private int copies;
    private String isbn10;
    private String description;

    public Publication() {}

    public Publication(String title, double price, int copies, String isbn10, String description) {
        super();
        this.title = title;
        this.price = price;
        this.copies = copies;
        this.isbn10 = isbn10;
        this.description = description;
    }

    // getters/setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override public int getCopies() { return copies; }
    @Override public void setCopies(int copies) { this.copies = copies; }

    public String getIsbn10() { return isbn10; }
    public void setIsbn10(String isbn10) { this.isbn10 = isbn10; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", copies=" + copies +
                ", isbn10='" + isbn10 + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    @Override
    public void sellCopy() {
        if (copies > 0) copies--;
    }

    @Override
    public void initialize() {
        this.title = "Untitled";
        this.price = 0.0;
        this.copies = 0;
        this.isbn10 = "";
        this.description = "";
    }

    @Override
    public void edit() {
        System.out.println("Edit called for Publication: " + title);
    }
}
