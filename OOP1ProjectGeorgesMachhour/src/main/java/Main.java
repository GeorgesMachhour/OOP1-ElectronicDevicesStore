import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

       while (choice!=1 && choice!=2 && choice!=3){
        System.out.println("Welcome to the Online Store!");
        System.out.println("Choose the data storage format:");
        System.out.println("1. JSON");
        System.out.println("2. CSV");
        System.out.println("3. MongoDB");
        try{
        choice = scanner.nextInt();
        scanner.nextLine();
        if  (choice!=1 && choice!=2 && choice!=3)
            System.out.println("Enter A valid option 1 or 2 or 3");
        }catch (Exception e){
            System.out.println("Enter A valid option 1 or 2 or 3");
        }
       }
        dataBase store = new dataBase(choice);

        ElectronicDevice tempDevice;
        String tempString;

        String priceFilterOption;
        String priceFilter;

        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a new item");
            System.out.println("2. Search & Buy an item");
            System.out.println("3. Search & Update an item");
            System.out.println("4. Search & Delete an item");
            System.out.println("5. Search for an item");
            System.out.println("6. Sort items");
            System.out.println("7. Exit without Saving");
            System.out.println("8. Exit & Save");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    store.AddNewDevice();
                    break;
                case 2:
                    System.out.print("Search Item to buy : ");
                    tempString = scanner.nextLine();
                    System.out.println("Do you want to apply a price filter?");
                    System.out.println("Enter one of the following options:");
                    System.out.println("1. Equal");
                    System.out.println("2. Less or equal");
                    System.out.println("3. Larger or equal");
                    System.out.println("4. In a given range");
                    System.out.println("5. No price filter");
                    System.out.print("Your choice: ");
                    priceFilterOption = scanner.nextLine();
                    priceFilter = null;
                    switch (priceFilterOption) {
                        case "1":
                            priceFilter = "equal";
                            break;
                        case "2":
                            priceFilter = "less or equal";
                            break;
                        case "3":
                            priceFilter = "larger or equal";
                            break;
                        case "4":
                            priceFilter = "in a given range";
                            break;
                        case "5":
                            priceFilter = null;
                            break;
                        default:
                            System.out.println("Invalid option, no price filter will be applied.");
                            priceFilter = null;
                            break;
                    }
                    tempDevice = store.Search4(tempString, true, priceFilter);
                    System.out.println("Selected item:\t" + tempDevice);

                    int quantityToBuy = -1;
                    while (quantityToBuy <= 0) {
                        System.out.print("Enter the quantity to buy (greater than 0): ");
                        try {
                            quantityToBuy = Integer.parseInt(scanner.nextLine());
                            if (quantityToBuy <= 0) {
                                System.out.println("Please enter a valid quantity (greater than 0).");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                        }
                    }
                    store.buyElectronicDevice(tempDevice,quantityToBuy);
                    break;
                case 3:
                    System.out.print("Search Item to Update : ");
                    tempString = scanner.nextLine();
                    System.out.println("Do you want to apply a price filter?");
                    System.out.println("Enter one of the following options:");
                    System.out.println("1. Equal");
                    System.out.println("2. Less or equal");
                    System.out.println("3. Larger or equal");
                    System.out.println("4. In a given range");
                    System.out.println("5. No price filter");
                    System.out.print("Your choice: ");
                    priceFilterOption = scanner.nextLine();
                    priceFilter = null;
                    switch (priceFilterOption) {
                        case "1":
                            priceFilter = "equal";
                            break;
                        case "2":
                            priceFilter = "less or equal";
                            break;
                        case "3":
                            priceFilter = "larger or equal";
                            break;
                        case "4":
                            priceFilter = "in a given range";
                            break;
                        case "5":
                            priceFilter = null;
                            break;
                        default:
                            System.out.println("Invalid option, no price filter will be applied.");
                            priceFilter = null;
                            break;
                    }
                    tempDevice = store.Search4(tempString, true, priceFilter);
                    System.out.println("Selected item:\t" + tempDevice);

                    store.UpdateElectronicDevices(tempDevice);
                    break;
                case 4:
                    System.out.print("Search Item to Delete : ");
                    tempString = scanner.nextLine();
                    System.out.println("Do you want to apply a price filter?");
                    System.out.println("Enter one of the following options:");
                    System.out.println("1. Equal");
                    System.out.println("2. Less or equal");
                    System.out.println("3. Larger or equal");
                    System.out.println("4. In a given range");
                    System.out.println("5. No price filter");
                    System.out.print("Your choice: ");
                    priceFilterOption = scanner.nextLine();
                    priceFilter = null;
                    switch (priceFilterOption) {
                        case "1":
                            priceFilter = "equal";
                            break;
                        case "2":
                            priceFilter = "less or equal";
                            break;
                        case "3":
                            priceFilter = "larger or equal";
                            break;
                        case "4":
                            priceFilter = "in a given range";
                            break;
                        case "5":
                            priceFilter = null;
                            break;
                        default:
                            System.out.println("Invalid option, no price filter will be applied.");
                            priceFilter = null;
                            break;
                    }
                    tempDevice = store.Search4(tempString, true, priceFilter);
                    System.out.println("Selected item:\t" + tempDevice);

                    store.DeleteElectronicDevices(tempDevice);
                    break;
                case 5:
                    System.out.print("Search Item: ");
                    tempString = scanner.nextLine();
                    System.out.println("Do you want to apply a price filter?");
                    System.out.println("Enter one of the following options:");
                    System.out.println("1. Equal");
                    System.out.println("2. Less or equal");
                    System.out.println("3. Larger or equal");
                    System.out.println("4. In a given range");
                    System.out.println("5. No price filter");
                    System.out.print("Your choice: ");
                    priceFilterOption = scanner.nextLine();
                    priceFilter = null;
                    switch (priceFilterOption) {
                        case "1":
                            priceFilter = "equal";
                            break;
                        case "2":
                            priceFilter = "less or equal";
                            break;
                        case "3":
                            priceFilter = "larger or equal";
                            break;
                        case "4":
                            priceFilter = "in a given range";
                            break;
                        case "5":
                            priceFilter = null;
                            break;
                        default:
                            System.out.println("Invalid option, no price filter will be applied.");
                            priceFilter = null;
                            break;
                    }
                    tempDevice = store.Search4(tempString, false, priceFilter); 
                    break;
                case 6:
                    int sortOption = 0;
                    while (true) {
                        System.out.println("Sort by:");
                        System.out.println("1. Name");
                        System.out.println("2. Quantity");
                        System.out.println("3. Price");
                        sortOption = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (sortOption == 1 || sortOption == 2 || sortOption == 3)
                            break;
                        else
                            System.out.println("Enter a valid option (1,2,3)");
                    }
                    store.sortList(sortOption);
                    break;
                case 7: {
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                }
                case 8:
                    try {
                        System.out.println("Saving...");
                        store.saveModifiction();
                    } catch (IOException e) {
                        System.out.println("Error saving modifications: " + e.getMessage());
                    }
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 7.");
                    break;
            }
        }

        scanner.close();
    }
}
