import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV implements dataHandeling {

    private static final String filePath = "C:\\Users\\georg\\Documents\\NetBeansProjects\\OOP1ProjectGeorgesMachhour\\src\\Data\\data.csv";

    @Override
    public void WriteFromArrayList(List<ElectronicDevice> devices) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (ElectronicDevice device : devices) {
                StringBuilder sb = new StringBuilder();
                sb.append(device.getId()).append(",");
                sb.append(device.getBrand()).append(",");
                sb.append(device.getDeviceType()).append(",");
                sb.append(device.getModel()).append(",");
                sb.append(device.getColor()).append(",");
                sb.append(device.getCapacity()).append(",");
                sb.append(device.getQuantity()).append(",");
                sb.append(device.getPrice());

                if (device instanceof Laptop) {
                    sb.append(",").append(((Laptop) device).getCPU());
                } else if (device instanceof SmartPhone) {
                    sb.append(",").append(((SmartPhone) device).getcameraResolution());
                } else if (device instanceof SmartWatch) {
                    sb.append(",").append(((SmartWatch) device).getBandType());
                } else if (device instanceof Tablet) {
                    sb.append(",").append(((Tablet) device).getPortType());
                }

                writer.write(sb.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<ElectronicDevice> Write2ArrayList() {
        ArrayList<ElectronicDevice> devices = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                ElectronicDevice device;
                switch (parts[2]) {
                    case "Laptop":
                        device = new Laptop();
                        ((Laptop) device).setCPU(parts[8]);
                        break;
                    case "SmartPhone":
                        device = new SmartPhone();
                        ((SmartPhone) device).setcameraResolution(parts[8]);
                        break;
                    case "SmartWatch":
                        device = new SmartWatch();
                        ((SmartWatch) device).setBandType(parts[8]);
                        break;
                    case "Tablet":
                        device = new Tablet();
                        ((Tablet) device).setPortType(parts[8]);
                        break;
                    default:
                    throw new RuntimeException("Custom error message here");
                }
                device.setId(Integer.parseInt(parts[0]));
                device.setBrand(parts[1]);
                device.setDeviceType(parts[2]);
                device.setModel(parts[3]);
                device.setColor(parts[4]);
                device.setCapacity(Integer.parseInt(parts[5]));
                device.setQuantity(Integer.parseInt(parts[6]));
                device.setPrice(Double.valueOf(parts[7]));
                devices.add(device);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
        return devices;
    }
}
