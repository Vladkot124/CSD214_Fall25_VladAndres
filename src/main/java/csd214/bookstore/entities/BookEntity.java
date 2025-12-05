package csd214.bookstore.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
@DiscriminatorValue("BOOK")
public class BookEntity extends PublicationEntity {

    private String author;

    public BookEntity() { }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return super.toString() + " Book{author='" + author + "'}";
    }
}
