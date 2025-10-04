package lab1.pojos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class Editable {
    protected static final Scanner in = new Scanner(System.in);
    protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public abstract void initialize();
    public abstract void edit();

    protected String getInput(String current) {
        String input = in.nextLine().trim();
        if (input.isEmpty()) return current;
        return input;
    }

    protected int getInput(int current) {
        String input = in.nextLine().trim();
        if (input.isEmpty()) return current;
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, keeping old value.");
            return current;
        }
    }

    protected double getInput(double current) {
        String input = in.nextLine().trim();
        if (input.isEmpty()) return current;
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number, keeping old value.");
            return current;
        }
    }

    protected boolean getInput(boolean current) {
        String input = in.nextLine().trim().toLowerCase();
        if (input.isEmpty()) return current;
        return input.equals("y") || input.equals("yes");
    }

    protected LocalDate getInput(LocalDate current) {
        String input = in.nextLine().trim();
        if (input.isEmpty()) return current;
        try {
            return LocalDate.parse(input, FORMAT);
        } catch (Exception e) {
            System.out.println("Invalid date format (expected dd-MM-yyyy). Keeping old date.");
            return current;
        }
    }
}
