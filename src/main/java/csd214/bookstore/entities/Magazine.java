package csd214.bookstore.entities;

import java.time.LocalDate;

public class Magazine extends Publication {

    private int orderQty;
    private LocalDate currentIssue;

    public Magazine() { }

    public Magazine(long id, String title, double price, int copies, String isbn10, String description, int orderQty, LocalDate currentIssue) {
        super(id, title, price, copies, isbn10, description);
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
    }

    public int getOrderQty() { return orderQty; }
    public void setOrderQty(int orderQty) { this.orderQty = orderQty; }

    public LocalDate getCurrentIssue() { return currentIssue; }
    public void setCurrentIssue(LocalDate currentIssue) { this.currentIssue = currentIssue; }

    @Override
    public String toString() {
        return super.toString() + " Order Qty: " + orderQty + "  Current Issue: " + currentIssue;
    }
}
