package csd214.bookstore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cash_till")
public class CashTillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double cashOnHand;

    public CashTillEntity() { }

    public Long getId() { return id; }

    public double getCashOnHand() { return cashOnHand; }
    public void setCashOnHand(double cashOnHand) { this.cashOnHand = cashOnHand; }

    @Override
    public String toString() {
        return "CashTillEntity{id=" + id + ", cashOnHand=" + cashOnHand + "}";
    }
}
