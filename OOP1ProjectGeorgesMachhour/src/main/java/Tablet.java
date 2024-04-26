public class Tablet extends ElectronicDevice {
    private String portType;

    public Tablet(String brand, String model, String color, int capacity, int quantity, Double price, String portType) {
        super(brand, model, color, capacity, quantity, price);
        this.portType = portType;
        super.setDeviceType("Tablet");
    }
    public Tablet(){
        super.setDeviceType("Tablet");
    }
    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    @Override
    public String toString() {
        return "Tablet," + portType + super.toString();

}
}