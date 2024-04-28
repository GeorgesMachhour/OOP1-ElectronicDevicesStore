import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Store!");
        System.out.println("Choose the data storage format:");
        System.out.println("1. JSON");
        System.out.println("2. CSV");
        System.out.println("3. MongoDB");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        dataBase store = new dataBase(choice);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a new item");
            System.out.println("2. Buy an item");
            System.out.println("3. Update an item");
            System.out.println("4. Delete an item");
            System.out.println("5. Search for an item");
            System.out.println("6. Sort items");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    store.AddNewDevice();
                    break;
                case 2:
                    // Provide implementation for buying an item
                    break;
                case 3:
                    // Provide implementation for updating an item
                    break;
                case 4:
                    // Provide implementation for deleting an item
                    break;
                case 5:
                    // Provide implementation for searching for an item
                    break;
                case 6:
                    System.out.println("Sort by:");
                    System.out.println("1. Name");
                    System.out.println("2. Quantity");
                    System.out.println("3. Price");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Provide implementation for sorting items
                    break;
                case 7:
                    try {
                        store.saveModifiction();
                    } catch (IOException e) {
                        System.out.println("Error saving modifications: " + e.getMessage());
                    }
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 7.");
            }
        }

        scanner.close();
    }
}
