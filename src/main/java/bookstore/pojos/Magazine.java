package bookstore.pojos;

import java.time.LocalDate;

public class Magazine extends Publication implements Editable {
    private Long id;
    private int orderQty;
    private LocalDate currentIssue;

    public Magazine() {}

    public Magazine(Long id, String title, double price, int copies, String isbn,
                    String description, int orderQty, LocalDate currentIssue) {
        super(title, price, copies, isbn, description);
        this.id = id;
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    @Override public Long getId() { return id; }
    @Override public void setId(Long id) { this.id = id; }

    public int getOrderQty() { return orderQty; }
    public void setOrderQty(int orderQty) { this.orderQty = orderQty; }

    public LocalDate getCurrentIssue() { return currentIssue; }
    public void setCurrentIssue(LocalDate currentIssue) { this.currentIssue = currentIssue; }

    @Override
    public String toString() {
        return "Magazine[id=" + (id==null?"N/A":id) + ", title=" + getTitle() + ", issue=" + (currentIssue==null?"N/A":currentIssue.toString()) + ", price=" + getPrice() + ", copies=" + getCopies() + "]";
    }
}
