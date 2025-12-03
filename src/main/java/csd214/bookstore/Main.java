package csd214.bookstore;

public class Main {
    public static void main(String[] args) {
        if (args != null && args.length > 0 && args[0].equalsIgnoreCase("lab3")) {
            runLab3IfExists(args);
            return;
        }

        App app = new App();
        app.run();
    }

    private static void runLab3IfExists(String[] args) {
        try {
            Class<?> clazz = Class.forName("csd214.bookstore.Lab3Main");
            clazz.getMethod("main", String[].class).invoke(null, (Object) args);
        } catch (Exception e) {
            System.out.println("Lab3Main not found or failed to run. Make sure you have csd214.bookstore.Lab3Main.");
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
