package csd214_fall2025.pojos;

import java.time.LocalDate;

public class Ticket extends Publication {
    private String event;
    private LocalDate date;

    public Ticket() {}

    public Ticket(String event, double price, int copies, LocalDate date) {
        super(event, price, copies, "", "");
        this.event = event;
        this.date = date;
    }

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public void initialize() {
        setTitle("Untitled Ticket");
        setPrice(0.0);
        setCopies(0);
        this.event = "Event";
        this.date = LocalDate.now();
    }

    @Override
    public void edit() {
        System.out.println("Editing ticket: " + event);
    }

    @Override
    public String toString() {
        return "Ticket[event=" + event + ", price=" + getPrice() + ", copies=" + getCopies() + ", date=" + date + "]";
    }
}
