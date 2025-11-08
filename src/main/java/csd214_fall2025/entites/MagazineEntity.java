package csd214_fall2025.entites;

import jakarta.persistence.*;
import java.util.Scanner;

@Entity
@Table(name = "magazines")
public class MagazineEntity extends PublicationEntity {

    @Column(name = "issue_number")
    private int issueNumber;

    public MagazineEntity() {}

    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    @Override
    public void edit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new issue number: ");
        try {
            this.issueNumber = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            this.issueNumber = 0;
        }
    }

    @Override
    public void initialize() {
        setTitle("Untitled Magazine");
        this.issueNumber = 0;
        setCopies(0);
        setPrice(0.0);
    }

    @Override
    public void sellCopy() {
        int copies = getCopies();
        if (copies > 0) setCopies(copies - 1);
        System.out.println("Sold one copy of magazine: " + getTitle());
    }
}
