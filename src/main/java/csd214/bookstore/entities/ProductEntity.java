package csd214.bookstore.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public abstract class ProductEntity implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    @Column(length = 500)
    private String description;

    public ProductEntity() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id=" + id + ", price=" + price + ", description='" + description + "'}";
    }
}
