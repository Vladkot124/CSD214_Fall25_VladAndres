package csd214.bookstore.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        name = "product_type",
        discriminatorType = DiscriminatorType.STRING,
        length = 50
)
@Table(name = "products")
public abstract class ProductEntity implements Editable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    @Column(length = 500)
    private String description;

    @Column(name = "quantity_in_stock", nullable = false)
    private int quantityInStock = 0;

    public ProductEntity() { }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantityInStock() { return quantityInStock; }
    public void setQuantityInStock(int quantityInStock) { this.quantityInStock = quantityInStock; }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{id=" + id + ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", description='" + description + "'}";
    }
}
