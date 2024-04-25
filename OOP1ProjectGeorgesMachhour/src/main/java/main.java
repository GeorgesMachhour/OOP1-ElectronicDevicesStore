import java.util.ArrayList;
import java.util.List;

public class main{
    public static void main (String[] args)
    {
        Mongo csv = new Mongo();
        List<ElectronicDevice> devices = new ArrayList<>();
      
        devices = csv.Write2ArrayList();

        for(ElectronicDevice device : devices){
            System.out.println(device);
        }
         /*
        ElectronicDevice l1 = new Laptop ("lenovo", "legion", "black", 256, 1099.00, "i7");
        ElectronicDevice t1 = new Tablet ("Apple", "IPad", "silver", 250, 199.00, "lightening");
        ElectronicDevice s1 = new SmartPhone ("Samsung", "s23", "blue", 64, 99.00, "48");
        ElectronicDevice s2 = new SmartWatch ("Apple", "ultra", "black", 256, 1099.00, "leather");
        devices.add(l1);
        devices.add(t1);
        devices.add(s1);
        devices.add(s2);

        
        csv.WriteFromArrayList(devices); */
    }
}