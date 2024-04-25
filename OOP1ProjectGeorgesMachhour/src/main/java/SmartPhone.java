public class SmartPhone extends ElectronicDevice {

private String cameraResolution;

public SmartPhone(String brand, String model, String color, int capacity, Double price, String cameraResolution) {
    super(brand, model, color, capacity, price);
    this.cameraResolution = cameraResolution;
    super.setDeviceType("SmartPhone");
}

public SmartPhone(){
    super.setDeviceType("SmartPhone");
}


public String getcameraResolution() {
    return cameraResolution;
}

public void setcameraResolution(String cameraResolution) {
    this.cameraResolution = cameraResolution;
}
    
@Override
    public String toString() {
        return "SmartPhone," + cameraResolution + super.toString();

}
}