package csd214.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "publications")
public class PublicationEntity extends ProductEntity {

    @Column(nullable = false)
    private String title;

    private int copies;

    @Column(name = "isbn10")
    private String isbn10;

    public PublicationEntity() { }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }

    public String getIsbn10() { return isbn10; }
    public void setIsbn10(String isbn10) { this.isbn10 = isbn10; }

    @Override
    public String toString() {
        return super.toString() +
                " Publication{title='" + title + "', copies=" + copies + ", isbn10='" + isbn10 + "'}";
    }
}
