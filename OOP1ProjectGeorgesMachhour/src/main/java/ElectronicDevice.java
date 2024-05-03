import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class ElectronicDevice {
    private int id;

    protected void setId(int id) {
        this.id = id ;
    }


    private String brand;
    private String model;
    private String color;
    private int capacity;
    private int quantity;
    private Double price;
    private String deviceType;
    
    public ElectronicDevice() {
        
    }
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public ElectronicDevice(String brand, String model, String color, int capacity, int quantity, Double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.quantity = quantity;
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void updateID(){
        String filePath = "C:\\Users\\georg\\Documents\\NetBeansProjects\\OOP1ProjectGeorgesMachhour\\src\\main\\java\\id.txt";
        int idInfile = 0;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            reader.close();
            
            if (line != null && !line.isEmpty()) {
                idInfile = Integer.parseInt(line);
            } else {
                idInfile = 1; // Set ID to 1 if file is empty
            }
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            id = idInfile;
            idInfile++;
            writer.write(Integer.toString(idInfile)); // Write integer as a string
            writer.close();
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write("1"); // Write 1 if there is an error reading the file
                writer.close();
            } catch (IOException ex) {
                System.out.println("Error writing default ID to file: " + ex.getMessage());
            }
        }
    }
    
    
    @Override
    public String toString() {
        return 
          ","+brand + "," + model + "," + color + "," + capacity + "," + quantity+ "," + price + "\n";
    }

    public int compareTo(ElectronicDevice other) {
        return Double.compare(this.price, other.price);
    }

    // Method to sort by name alphabetically
    public static void sortByName(List<ElectronicDevice> devices) {
        Collections.sort(devices, Comparator.comparing(ElectronicDevice::getModel));
    }

    // Method to sort by quantity
    public static void sortByQuantity(List<ElectronicDevice> devices) {
        Collections.sort(devices, Comparator.comparingInt(ElectronicDevice::getQuantity));
    }

     // Method to sort by price
    public static void sortByPrice(List<ElectronicDevice> devices) {
        Collections.sort(devices, Comparator.comparingDouble(ElectronicDevice::getPrice));
    }
}