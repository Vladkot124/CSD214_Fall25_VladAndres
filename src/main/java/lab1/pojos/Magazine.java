package lab1.pojos;

import java.time.LocalDate;

public class Magazine extends Publication {
    private int orderQty;
    private LocalDate currentIssue;

    @Override
    public void initialize() {
        System.out.print("Enter magazine title: ");
        setTitle(getInput(""));

        System.out.print("Enter price: ");
        setPrice(getInput(0.0));

        System.out.print("Enter copies: ");
        setCopies(getInput(0));

        System.out.print("Enter order quantity: ");
        orderQty = getInput(0);

        System.out.print("Enter issue date (dd-MM-yyyy): ");
        currentIssue = getInput(LocalDate.now());
    }

    @Override
    public void edit() {
        System.out.println("--- Editing Magazine ---");
        System.out.print("New title (current: " + getTitle() + "): ");
        setTitle(getInput(getTitle()));

        System.out.print("New price (current: " + getPrice() + "): ");
        setPrice(getInput(getPrice()));

        System.out.print("New copies (current: " + getCopies() + "): ");
        setCopies(getInput(getCopies()));

        System.out.print("New order quantity (current: " + orderQty + "): ");
        orderQty = getInput(orderQty);

        System.out.print("New issue date (current: " + currentIssue + "): ");
        currentIssue = getInput(currentIssue);
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
            System.out.println("Sold magazine \"" + getTitle() + "\" - Issue: " + currentIssue);
        } else {
            System.out.println("Out of stock!");
        }
    }

    @Override
    public String toString() {
        return "Magazine - " + getTitle() +
                " | Issue: " + currentIssue +
                " | $" + getPrice() +
                " | Copies: " + getCopies();
    }
}
