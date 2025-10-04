package lab1.pojos;

public class Book extends Publication {
    private String author;

    public Book() {}

    public Book(String author, String title, double price, int copies) {
        super(title, price, copies);
        this.author = author;
    }

    @Override
    public void initialize() {
        System.out.print("Enter book title: ");
        setTitle(getInput(""));

        System.out.print("Enter author: ");
        author = getInput("");

        System.out.print("Enter price: ");
        setPrice(getInput(0.0));

        System.out.print("Enter copies: ");
        setCopies(getInput(0));
    }

    @Override
    public void edit() {
        System.out.println("--- Editing Book ---");
        System.out.print("New title (current: " + getTitle() + "): ");
        setTitle(getInput(getTitle()));

        System.out.print("New author (current: " + author + "): ");
        author = getInput(author);

        System.out.print("New price (current: " + getPrice() + "): ");
        setPrice(getInput(getPrice()));

        System.out.print("New copies (current: " + getCopies() + "): ");
        setCopies(getInput(getCopies()));
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
            System.out.println("Sold one copy of \"" + getTitle() + "\" by " + author);
        } else {
            System.out.println("Out of stock!");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " by " + author +
                ", $" + getPrice() + ", Copies: " + getCopies();
    }
}
