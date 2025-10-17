package bookstore.pojos;

public interface SaleableItem {
    double getPrice();
    int getCopies();
    void setCopies(int copies);
}
