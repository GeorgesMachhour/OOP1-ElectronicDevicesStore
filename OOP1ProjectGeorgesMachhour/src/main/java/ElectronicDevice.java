import java.io.*;

public abstract class ElectronicDevice {
    private int id;

    protected void setId(int id) {
        this.id = id;
    }


    private String brand;
    private String model;
    private String color;
    private int capacity;
    private Double price;
    private String deviceType;
    
    public ElectronicDevice() {
        updateID();
    }
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public ElectronicDevice(String brand, String model, String color, int capacity, Double price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.capacity = capacity;
        this.price = price;
        updateID();
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }

    private void updateID(){
        String filePath = "C:\\Users\\georg\\Desktop\\Project_OOP1\\src\\id.txt";
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
          brand + "," + model + "," + color + "," + capacity + "," + price + "\n";
    }
}
