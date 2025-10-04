package lab1;

import lab1.pojos.*;

public class App {
    public void run() {
        System.out.println("--- Bookstore App ---");

        CashTill till = new CashTill();

        Book b = new Book();
        b.initialize();
        System.out.println(b);
        b.edit();

        Magazine m = new Magazine();
        m.initialize();
        System.out.println(m);

        till.sellItem(b);
        till.sellItem(m);

        till.showTotal();
    }
}
