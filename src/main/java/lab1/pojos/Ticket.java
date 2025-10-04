package lab1.pojos;

public class Ticket extends Editable implements SaleableItem {
    private long id;
    private String description;
    private double price;

    @Override
    public void initialize() {
        System.out.print("Enter ticket ID: ");
        id = getInput((int) id);

        System.out.print("Enter description: ");
        description = getInput("");

        System.out.print("Enter price: ");
        price = getInput(0.0);
    }

    @Override
    public void edit() {
        System.out.print("New description (current: " + description + "): ");
        description = getInput(description);

        System.out.print("New price (current: " + price + "): ");
        price = getInput(price);
    }

    @Override
    public void sellItem() {
        System.out.println("Sold ticket: " + description + " for $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + id + ", " + description + ", $" + price;
    }
}
