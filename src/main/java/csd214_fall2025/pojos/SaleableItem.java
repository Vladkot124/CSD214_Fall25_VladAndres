package csd214_fall2025.pojos;

public interface SaleableItem {
    void sellCopy();
    double getPrice();
    // Some POJOs used getCopies/setCopies, you can add defaults if necessary
    default int getCopies() { return 0; }
    default void setCopies(int copies) {}
}
