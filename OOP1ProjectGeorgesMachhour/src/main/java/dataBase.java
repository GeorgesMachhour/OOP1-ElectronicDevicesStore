/*
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataBase {
    private final int choice; // 1-JSON, 2-MongoDB, 3-CSV
    private static ArrayList<ElectronicDevice> devicesList;
    Json json = new Json();
    Mongo mongo = new Mongo();
    CSV csv = new CSV();

    public DataBase(int choice) {
        this.choice = choice;
        System.out.println("Loading...");
        switch (choice) {
            case 1:
                devicesList = json.Write2ArrayList();
                break;
            case 2:
                devicesList = mongo.Write2ArrayList();
                break;
            case 3:
                devicesList = csv.Write2ArrayList();
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                break;
        }
    }

    public void AddNewDevice() {
        String type = "";
        ElectronicDevice toBeAdded = null;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Brand : ");
        String brand = scan.nextLine().toLowerCase();
        System.out.print("Enter model : ");
        String model = scan.nextLine().toLowerCase();
        System.out.print("Enter Color : ");
        String color = scan.nextLine().toLowerCase();
        int capacity = 0;
        double price = 0.0;

        while (capacity <= 0) {
            System.out.print("Enter capacity: ");
            try {
                capacity = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        while (price <= 0) {
            System.out.print("Enter price: ");
            try {
                price = Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        while (!type.equals("1") && !type.equals("2") && !type.equals("3") && !type.equals("4")) {
            System.out.print("\nChoose Device Type: \n1-Smartphone\n2-Laptop\n3-Smartwatch\n4-Tablet\nOption: ");
            type = scan.nextLine();
            if (!type.equals("1") && !type.equals("2") && !type.equals("3") && !type.equals("4")) {
                System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
            }
        }

        switch (type) {
            case "1": // smartphone
                System.out.print("Enter smartphone camera resolution : ");
                String cameraResolution = scan.nextLine().toLowerCase();

                toBeAdded = new Smartphone(brand, model, color, capacity, price, cameraResolution);
                System.out.println(toBeAdded.toString());
                break;

            case "2": // laptop
                System.out.print("Enter laptop CPU : ");
                String cpu = scan.nextLine().toLowerCase();

                toBeAdded = new Laptop(brand, model, color, capacity, price, cpu);
                System.out.println(toBeAdded.toString());
                break;

            case "3": // smartwatch
                System.out.print("Enter smartwatch band type : ");
                String bandType = scan.nextLine().toLowerCase();

                toBeAdded = new Smartwatch(brand, model, color, capacity, price, bandType);
                System.out.println(toBeAdded.toString());
                break;

            case "4": // tablet
                System.out.print("Enter tablet port type : ");
                String portType = scan.nextLine().toLowerCase();

                toBeAdded = new Tablet(brand, model, color, capacity, price, portType);
                System.out.println(toBeAdded.toString());
                break;

            default:
                break;
        }
        devicesList.add(toBeAdded);
    }

    public void saveModification() throws IOException {
        if (!devicesList.isEmpty()) {
            switch (choice) {
                case 1: // JSON
                    json.WriteFromArrayList(devicesList);
                    break;
                case 2: // MongoDB
                    mongo.emptyDatabase();
                    mongo.WriteFromArrayList(devicesList);
                    mongo.closeConnection();
                    break;
                case 3: // CSV
                    csv.WriteFromArrayList(devicesList);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }

    private boolean isWeakMatch(String str1, String str2) {
        if (str1.length() < 3 || str2.length() < 3) {
            return false;
        }
        for (int i = 0; i <= str1.length() - 3; i++) {
            String sub = str1.substring(i, i + 3);
            if (str2.contains(sub)) {
                return true;
            }
        }
        return false;
    }

    public ElectronicDevice searchFor(String searching, boolean returnValue) {
        int count = 0;
        if (devicesList.isEmpty()) {
            System.out.println("The database is still empty");
            return null;
        }
        HashSet<String> wordsSet = new HashSet<>();
        String searchingLowerCase = searching.toLowerCase();
        String[] words = searchingLowerCase.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordsSet.add(word);
            }
        }
        List<ElectronicDevice> filteredList = devicesList.stream()
                .filter(device -> wordsSet.stream().anyMatch(word -> isWeakMatch(device.toString().toLowerCase(), word)))
                .collect(Collectors.toList());
        if (!filteredList.isEmpty()) {
            System.out.println("Found Devices");
            filteredList.forEach(System.out::println);
            return filteredList.get(0);
        } else {
            System.out.println("No Devices Found");
            return null;
        }
    }
    public void sortDevicesByID() {
        Collections.sort(devicesList, Comparator.comparingInt(ElectronicDevice::getId));
    }
}
*/