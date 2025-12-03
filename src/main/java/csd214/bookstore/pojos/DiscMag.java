package csd214.bookstore.pojos;

import java.time.LocalDate;

public class DiscMag extends Magazine {

    private boolean hasDisc;

    public DiscMag() { }

    public DiscMag(long id, String title, double price, int copies, String isbn10, String description, int orderQty, LocalDate currentIssue, boolean hasDisc) {
        super(id, title, price, copies, isbn10, description, orderQty, currentIssue);
        this.hasDisc = hasDisc;
    }

    public boolean isHasDisc() { return hasDisc; }
    public void setHasDisc(boolean hasDisc) { this.hasDisc = hasDisc; }

    @Override
    public String toString() {
        return super.toString() + "  Has Disc: " + hasDisc;
    }
}
