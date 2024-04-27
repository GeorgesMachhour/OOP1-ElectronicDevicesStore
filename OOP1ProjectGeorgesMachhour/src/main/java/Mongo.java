import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Mongo implements dataHandeling {
    private final com.mongodb.client.MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public Mongo() {
        // Establishing connection to MongoDB
        String connectionString = "mongodb://localhost:27017";
        MongoClientURI uri = new MongoClientURI(connectionString);
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("ElectronicDevice");
        collection = database.getCollection("Devices");
    }
    
    @Override
    public void WriteFromArrayList(List<ElectronicDevice> devices) {
        
        List<Document> documents = new ArrayList<>();

        for (ElectronicDevice device : devices) {
            Document document = new Document ("Id", device.getId())
                    .append("brand", device.getBrand())
                    .append("deviceType", device.getDeviceType())
                    .append("model", device.getModel())
                    .append("color", device.getColor())
                    .append("capacity", device.getCapacity())
                    .append("quantity", device.getQuantity())
                    .append("price", device.getPrice());

            if (device instanceof Laptop) {
                document.append("CPU", ((Laptop) device).getCPU());
                        
            } else if (device instanceof SmartPhone) {
                document.append("cameraResolution", ((SmartPhone) device).getcameraResolution());

            } else if (device instanceof SmartWatch) {
                document.append("bandType", ((SmartWatch) device).getBandType());
                        
            } else if (device instanceof Tablet) {
                document.append("portType", ((Tablet) device).getPortType());
                        
            }

            documents.add(document);
        }
        emptyDatabase();
        collection.insertMany(documents);
    }
    @Override
    public ArrayList<ElectronicDevice> Write2ArrayList() 
    {

        ArrayList<ElectronicDevice> device = new ArrayList<>();

        for (Document document : collection.find()) {
            String deviceType = document.getString("deviceType");


            if (deviceType.equals("Laptop")) {
                Laptop laptop = new Laptop();
                laptop.setId(document.getInteger("Id"));
                laptop.setDeviceType(deviceType);
                laptop.setBrand(document.getString("brand"));
                laptop.setModel(document.getString("model"));
                laptop.setColor(document.getString("color"));
                laptop.setCapacity(document.getInteger("capacity"));
                laptop.setQuantity(document.getInteger("quantity"));
                laptop.setPrice(document.getDouble("price"));
                laptop.setCPU(document.getString("CPU"));
                device.add(laptop);
            } else if (deviceType.equals("SmartPhone")) {
                SmartPhone smartPhone = new SmartPhone();
                smartPhone.setId(document.getInteger("Id"));
                smartPhone.setDeviceType(deviceType);
                smartPhone.setBrand(document.getString("brand"));
                smartPhone.setModel(document.getString("model"));
                smartPhone.setColor(document.getString("color"));
                smartPhone.setCapacity(document.getInteger("capacity"));
                smartPhone.setQuantity(document.getInteger("quantity"));
                smartPhone.setPrice(document.getDouble("price"));
                smartPhone.setcameraResolution(document.getString("cameraResolution"));
                device.add(smartPhone);
            } else if (deviceType.equals("SmartWatch")) {
                SmartWatch smartWatch = new SmartWatch();
                smartWatch.setId(document.getInteger("Id"));
                smartWatch.setDeviceType(deviceType);
                smartWatch.setBrand(document.getString("brand"));
                smartWatch.setModel(document.getString("model"));
                smartWatch.setColor(document.getString("color"));
                smartWatch.setCapacity(document.getInteger("capacity"));
                smartWatch.setQuantity(document.getInteger("quantity"));
                smartWatch.setPrice(document.getDouble("price"));
                smartWatch.setBandType(document.getString("bandType"));
                device.add(smartWatch);
            }
            else if (deviceType.equals("Tablet")) {
                Tablet tablet = new Tablet();
                tablet.setId(document.getInteger("Id"));
                tablet.setDeviceType(deviceType);
                tablet.setBrand(document.getString("brand"));
                tablet.setModel(document.getString("model"));
                tablet.setColor(document.getString("color"));
                tablet.setCapacity(document.getInteger("capacity"));
                tablet.setQuantity(document.getInteger("quantity"));
                tablet.setPrice(document.getDouble("price"));
                tablet.setPortType(document.getString("portType"));
                device.add(tablet);

        }

    }
        return device;
    }

    private void closeConnection() {
        mongoClient.close();
    }
    private void emptyDatabase() {
        database.drop();
    }
}