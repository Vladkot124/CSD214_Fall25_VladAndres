package lab1.pojos;

public class CashTill {
    private double total = 0;

    public void sellItem(SaleableItem item) {
        if (item == null) {
            System.out.println("Item is null!");
            return;
        }
        item.sellItem();
        total += item.getPrice();
        System.out.printf("Added $%.2f. Total: $%.2f%n", item.getPrice(), total);
    }

    public void showTotal() {
        System.out.printf("Current total: $%.2f%n", total);
    }
}