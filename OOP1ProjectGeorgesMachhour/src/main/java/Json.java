import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class Json implements dataHandeling{
    
      private static final String filePath="C:\\Users\\georg\\Documents\\NetBeansProjects\\OOP1ProjectGeorgesMachhour\\src\\Data\\data.json";
         
     @Override
    public void WriteFromArrayList(List<ElectronicDevice> device) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
         objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), device);
         System.out.println("Succesfully saved");
    } catch (IOException e) {
        System.out.println("An error occurred while writing the device to JSON file: " + e.getMessage());
        e.printStackTrace();
    }
}
  ////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public ArrayList<ElectronicDevice> Write2ArrayList(){
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<ElectronicDevice> devices=new ArrayList<>();
    File jsonFile = new File(filePath);
try {
            // Read the JSON data from the file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            
            // Check if the root node is an array
            if (rootNode.isArray()) {
                // Iterate through each JSON node in the array
                for (JsonNode deviceNode : rootNode) {
                    // Extract the deviceType attribute from the JSON node
                    String deviceType = deviceNode.get("deviceType").asText();
                    
                    // Dynamically obtain the Class object for the specified deviceType
                    Class<?> deviceClass = Class.forName(deviceType);
                    
                    // Deserialize the JSON node into a ElectronicDevice object of the corresponding type
                    ElectronicDevice device = objectMapper.readValue(deviceNode.toString(),(Class<ElectronicDevice>) deviceClass);
                    
                    // Add the deserialized ElectronicDevice object to the ArrayList
                    devices.add(device);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return devices;
    }
}