public class Laptop extends ElectronicDevice {
 
    private String CPU;

    public Laptop(String brand, String model, String color, int capacity, int quantity, Double price, String CPU) {
        super(brand, model, color, capacity, quantity, price);
        this.CPU = CPU;
        super.setDeviceType("Laptop");
        
    }
    public Laptop(){
        super.setDeviceType("Laptop");
    }
    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    } 

    @Override
    public String toString() {
        return "Laptop," + CPU + super.toString();
}
}