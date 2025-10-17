package bookstore.pojos;

public class Ticket implements SaleableItem {
    private String description;
    private double price;
    private int copies;

    public Ticket() {}

    public Ticket(String description, double price, int copies) {
        this.description = description;
        this.price = price;
        this.copies = copies;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override public int getCopies() { return copies; }
    @Override public void setCopies(int copies) { this.copies = copies; }

    @Override
    public String toString() {
        return "Ticket[" + (description==null?"":description) + ", $" + price + ", copies=" + copies + "]";
    }
}

