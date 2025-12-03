package csd214.bookstore.pojos;

public class Ticket extends EditableBase implements SaleableItem {

    private String description;
    private double price;

    public Ticket() { }

    public Ticket(long id, String description, double price) {
        super(id);
        this.description = description;
        this.price = price;
    }

    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Ticket Description: " + description + "  Price: " + price + "  " + super.toString();
    }
}
