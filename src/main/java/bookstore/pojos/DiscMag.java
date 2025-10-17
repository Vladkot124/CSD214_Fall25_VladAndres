package bookstore.pojos;

import java.time.LocalDate;

public class DiscMag extends Magazine {
    private boolean hasDisc;

    public DiscMag() { super(); }

    public DiscMag(Long id, String title, double price, int copies, String isbn,
                   String description, int orderQty, LocalDate currentIssue, boolean hasDisc) {
        super(id, title, price, copies, isbn, description, orderQty, currentIssue);
        this.hasDisc = hasDisc;
    }

    public boolean isHasDisc() { return hasDisc; }
    public void setHasDisc(boolean hasDisc) { this.hasDisc = hasDisc; }

    @Override
    public String toString() {
        return super.toString() + (hasDisc ? " + Disc" : "");
    }
}
