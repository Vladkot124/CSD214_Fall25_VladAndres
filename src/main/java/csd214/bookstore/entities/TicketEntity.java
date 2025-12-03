package csd214.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class TicketEntity extends ProductEntity {

    public TicketEntity() { }

    @Override
    public String toString() {
        return super.toString() + " Ticket{}";
    }
}
