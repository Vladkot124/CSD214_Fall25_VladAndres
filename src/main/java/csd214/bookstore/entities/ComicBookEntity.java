package csd214.bookstore.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "comic_books")
public class ComicBookEntity extends BookEntity {

    private int issueNumber;

    public ComicBookEntity() { }

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }
}
