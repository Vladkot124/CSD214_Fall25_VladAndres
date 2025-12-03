package csd214.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pencils")
public class PencilEntity extends ProductEntity {

    private String hardness; // HB, 2B ...

    public PencilEntity() { }

    public String getHardness() { return hardness; }
    public void setHardness(String hardness) { this.hardness = hardness; }
}
