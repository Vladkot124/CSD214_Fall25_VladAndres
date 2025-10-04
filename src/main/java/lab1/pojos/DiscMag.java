package lab1.pojos;

public class DiscMag extends Magazine {
    private boolean hasDisc;

    @Override
    public void initialize() {
        super.initialize();
        System.out.print("Does it include a disc (y/n)? ");
        hasDisc = getInput(false);
    }

    @Override
    public void edit() {
        super.edit();
        System.out.print("Includes disc (y/n)? ");
        hasDisc = getInput(hasDisc);
    }

    @Override
    public void sellItem() {
        super.sellItem();
        System.out.println("Disc included: " + (hasDisc ? "Yes" : "No"));
    }

    @Override
    public String toString() {
        return super.toString() + " | Disc: " + (hasDisc ? "Yes" : "No");
    }
}
