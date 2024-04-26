public class SmartWatch extends ElectronicDevice {
    private String bandType;

    public SmartWatch(String brand, String model, String color, int capacity, int quantity, Double price, String bandType) {
        super(brand, model, color, capacity, quantity, price);
        this.bandType = bandType;
        super.setDeviceType("SmartWatch");
    }
    public SmartWatch(){
        super.setDeviceType("SmartWatch");
    }
    public String getBandType() {
        return bandType;
    }

    public void setBandType(String bandType) {
        this.bandType = bandType;
    }
    
    @Override
    public String toString() {
        return "SmartWatch," + bandType + super.toString();

}
}