package csd214_fall2025.entites;

import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@Table(name = "books")
public class BookEntity extends PublicationEntity {

    @Column(name = "author")
    private String author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "pages")
    private int pages;

    public BookEntity() {}

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new author: ");
        this.author = input.nextLine();
        System.out.print("Enter new ISBN: ");
        this.isbn = input.nextLine();
        System.out.print("Enter page count: ");
        try {
            this.pages = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            this.pages = 0;
        }
    }

    @Override
    public void initialize() {
        setTitle("Unknown Author");
        this.author = "Unknown Author";
        this.isbn = "0000000000";
        this.pages = 0;
        setCopies(0);
        setPrice(0.0);
    }

    @Override
    public void sellCopy() {
        int copies = getCopies();
        if (copies > 0) setCopies(copies - 1);
        System.out.println("Sold one copy of book: " + getTitle());
    }
}
