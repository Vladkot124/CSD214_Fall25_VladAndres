package csd214.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "magazines")
public class MagazineEntity extends PublicationEntity {

    private int orderQty;
    private LocalDate currentIssue;

    public MagazineEntity() { }

    public int getOrderQty() { return orderQty; }
    public void setOrderQty(int orderQty) { this.orderQty = orderQty; }

    public LocalDate getCurrentIssue() { return currentIssue; }
    public void setCurrentIssue(LocalDate currentIssue) { this.currentIssue = currentIssue; }

    @Override
    public String toString() {
        return super.toString() +
                " Magazine{orderQty=" + orderQty + ", currentIssue=" + currentIssue + "}";
    }
}
