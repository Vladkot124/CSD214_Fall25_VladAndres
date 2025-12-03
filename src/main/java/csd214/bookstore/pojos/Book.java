package csd214.bookstore.pojos;

public class Book extends Publication {

    private String author;

    public Book() { }

    public Book(long id, String title, double price, int copies, String isbn10, String description, String author) {
        super(id, title, price, copies, isbn10, description);
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Book{author='" + author + "'} " + super.toString();
    }
}
