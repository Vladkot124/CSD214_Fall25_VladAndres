package bookstore.pojos;

public class Book extends Publication implements Editable {
    private Long id;
    private String author;

    public Book() {}

    public Book(Long id, String title, double price, int copies,
                String isbn, String description, String author) {
        super(title, price, copies, isbn, description);
        this.id = id;
        this.author = author;
    }

    @Override public Long getId() { return id; }
    @Override public void setId(Long id) { this.id = id; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Book[id=" + (id==null?"N/A":id) + ", title=" + getTitle() + ", author=" + author + ", price=" + getPrice() + ", copies=" + getCopies() + "]";
    }
}
