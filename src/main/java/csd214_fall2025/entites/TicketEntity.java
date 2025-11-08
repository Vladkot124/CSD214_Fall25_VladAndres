package csd214_fall2025.entites;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Scanner;

@Entity
@Table(name = "tickets")
public class TicketEntity extends PublicationEntity {

    @Column(name = "event_name")
    private String event;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "event_date")
    private LocalDate date;

    public TicketEntity() {}

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter event name: ");
        this.event = input.nextLine();
        System.out.print("Enter quantity: ");
        try {
            this.quantity = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            this.quantity = 0;
        }
        System.out.print("Enter event date (YYYY-MM-DD): ");
        try {
            this.date = LocalDate.parse(input.nextLine());
        } catch (Exception e) {
            this.date = LocalDate.now();
        }
    }

    @Override
    public void initialize() {
        setTitle("Untitled Ticket");
        this.event = "Untitled Event";
        this.quantity = 0;
        this.date = LocalDate.now();
        setCopies(0);
        setPrice(0.0);
    }

    @Override
    public void sellCopy() {
        if (quantity > 0) {
            quantity--;
            System.out.println("Sold one ticket for: " + event);
        } else {
            System.out.println("No more tickets available for: " + event);
        }
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + getId() +
                ", event='" + event + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
