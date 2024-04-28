import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class dataBase { 
    private final int choice; 
    private static ArrayList<ElectronicDevice> devices;
    dataHandeling Data ;
    
    public dataBase(int choice)
    {
        this.choice=choice;
        switch (choice){
            case 1: 
                Data = new Json();
                break;
            case 2: 
                Data = new CSV();
                break;
            case 3:
                Data = new Mongo();
                break;
            default : 
                System.exit(-1);
                //program should not arrive here
        }
              devices = Data.Write2ArrayList();
    }
           
   
        
        public void AddNewDevice() 
        {
            String type = "";
            ElectronicDevice toBeAdded = null;
            Scanner scan=new Scanner(System.in);
            System.out.print("Enter Brand : ");
            String brand = scan.nextLine();
            brand = brand.toLowerCase();
            System.out.print("Enter model : ");
            String model = scan.nextLine();
            model=model.toLowerCase();
            System.out.print("Enter Color : ");
            String color = scan.nextLine();
            color=color.toLowerCase();
           int capacity = 0;
           boolean isValid = false;
           while (!isValid) {
            try {
                System.out.print("Enter Capacity : ");
                String capacityString = scan.nextLine();
                capacity = Integer.parseInt(capacityString);
                isValid = true; // Mark input as valid
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
            
        int qty = 0;
            isValid = false;
            while (!isValid || qty<=0)
            {
                  System.out.print("Enter the quantity: ");
                    String input = scan.nextLine();
                try {
                     qty = Integer.parseInt(input);
                      isValid = true;
                     } catch (NumberFormatException e) {
                   System.out.println("Invalid input: please enter a valid number.");
                    }
             }
              isValid = false;
              double price=0.00;
                while (!isValid || price<=0)
            {
                  System.out.print("Enter a price in U$D number: ");
                    String input = scan.nextLine();
                try {
                     price = Double.parseDouble(input);
                      isValid = true;
                     } catch (NumberFormatException e) {
                   System.out.println("Invalid input: please enter a valid price.");
                    }
             }
           
           while (!type.equals("1") && !type.equals("2") && !type.equals("3") && !type.equals("4")) 
           {
                System.out.print("\nChoose Device Type: \n1-Laptop\n2-SmartPhone\n3-SmartWatch\n4-Tablet\nOption: ");
                type = scan.nextLine();
                if (!type.equals("1") && !type.equals("2") && !type.equals("3") && !type.equals("4")) 
                {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
           }
           ////////////////////////////////////////////////////////////////////////////////////////////////
            
           
            switch(type)
            {
                case"1":
                {
                    System.out.print("Enter CPU : ");
                    String CPU=scan.nextLine();
                    CPU=CPU.toLowerCase();
                    toBeAdded = new Laptop(brand,model,color,capacity,qty,price,CPU);
                    System.out.println(toBeAdded.toString());
                    break;
                }
                
                case"2":
                {
                    System.out.print("Enter Camera Resolution : ");
                    String cameraResolution=scan.nextLine();
                    cameraResolution=cameraResolution.toLowerCase();
                    toBeAdded = new SmartPhone(brand,model,color,capacity,qty,price,cameraResolution);
                    System.out.println(toBeAdded.toString());
                    break;
                }
                case"3":
                 {
                    System.out.print("Enter Band Type : ");
                    String bandType=scan.nextLine();
                    bandType=bandType.toLowerCase();
                    toBeAdded = new SmartWatch(brand,model,color,capacity,qty,price,bandType);
                    System.out.println(toBeAdded.toString());
                    break;     
                 }

                case "4":
                 {
                    System.out.print("Enter Port Type : ");
                    String portType=scan.nextLine();
                    portType=portType.toLowerCase();
                    toBeAdded = new SmartPhone(brand,model,color,capacity,qty,price,portType);
                    System.out.println(toBeAdded.toString());
                    break;
                 }
                 default:
                 {
                     System.out.println("Error occured while adding devices.");
                     break;
                 }
                
            }
           devices.add(toBeAdded);
        }
        
        public void saveModifiction() throws IOException
        {
            Data.WriteFromArrayList(devices);  
        }
        
        public ElectronicDevice Search4 (String Searching,boolean returnValue, String priceFilter)
        {
            int maxPrice=0, minPrice=0;
            Scanner scanner = new Scanner(System.in);
            if (priceFilter.equalsIgnoreCase("in a given range")) 
            {
                System.out.println("Max price: ");
                maxPrice=Integer.parseInt(scanner.nextLine());
                System.out.println("Min price: ");
                minPrice=Integer.parseInt(scanner.nextLine());
            }
            int count=0;
            if (devices.isEmpty())
            {
                System.out.println("The dataBase is still empty");
                return null;
            }
            HashSet<String> wordsSet = new HashSet<>();
            String searching=Searching.toLowerCase();
            String[] words = searching.split("\\s+");
            for (String word : words)
                {
                if (!word.isEmpty()) 
                {
                    wordsSet.add(word);
                }       
                }
            List <ElectronicDevice> search=null;
            ArrayList<ElectronicDevice>Matched=new ArrayList<>();
            for (String Searching4 : wordsSet)
            {
            search= devices.stream()
                .filter(    D -> 
                   (D instanceof Laptop && ((Laptop) D).getCPU().equalsIgnoreCase(Searching4))
                || (D instanceof SmartPhone && ((SmartPhone) D).getcameraResolution().equalsIgnoreCase(Searching4))
                || (D instanceof SmartWatch && ((SmartWatch) D).getBandType().equalsIgnoreCase(Searching4))       
                || (D instanceof Tablet && ((Tablet) D).getPortType().equalsIgnoreCase(Searching4))
                || D.getBrand().equalsIgnoreCase(Searching4)
                || D.getDeviceType().equalsIgnoreCase(Searching4)
                || D.getModel().equalsIgnoreCase(Searching4)
                || D.getColor().equalsIgnoreCase(Searching4)
                || Integer.toString(D.getCapacity()).equalsIgnoreCase(Searching4)
                || Integer.toString(D.getQuantity()).equalsIgnoreCase(Searching4)      
                || (priceFilter.equalsIgnoreCase("less or equal") && D.getPrice() <= Double.parseDouble(Searching4))
                || (priceFilter.equalsIgnoreCase("equal") && D.getPrice() == Double.parseDouble(Searching4))
                || (priceFilter.equalsIgnoreCase("larger or equal") && D.getPrice() >= Double.parseDouble(Searching4))
                || (priceFilter.equalsIgnoreCase("in a given range") && D.getPrice() >= minPrice && D.getPrice() <= maxPrice)
                )
                  .collect(Collectors.toList());
            }
            System.out.println("Search Results : ");
   
               if (!search.isEmpty()) 
               {
                 for (ElectronicDevice result : search)
                 {
                         count++;
                         System.out.println(count+"- "+result.toString());
                         Matched.add(result);
                 }
               }    else {  System.out.println("Not found : ");}
              
               if (returnValue)
               {
                   if (count==0  || Matched.isEmpty())
                   {
                       System.out.println("No result to be returned");
                       return null;
                   }
                   System.out.println("Enter the option Number : ");
                   Scanner scan=new Scanner(System.in);
                   boolean enteredValid=false;
                   int Choice =-1;
                   String choiceString;
                   while(!enteredValid)
                   {
                         choiceString=scan.nextLine();
                        try {
                        Choice = Integer.parseInt(choiceString);
                        } catch (NumberFormatException e) 
                        {
                            System.out.println("Invalid choice. Please enter a valid integer.");
                            enteredValid=false;
                        }
                        if ( Choice>count || Choice<=0)
                        {
                            enteredValid=false;
                            System.out.println("Invalid choice. Please enter a valid option number."+count);
                        }
                        else
                        {
                            enteredValid=true;
                            
                        }
                    }
                   
                   return Matched.get(Choice-1);
               }
               
        return null;
    }
        
        public void DeleteElectronicDevices(ElectronicDevice D)
        {
            if (D==null)
            {
                System.out.println("Can't be deleted!");
                return;
            }
            int ind=devices.indexOf(D);
            
            ElectronicDevice vDeleted=devices.remove(ind);
            System.out.println("Succssefully deleted "+vDeleted.toString());
        }
        
        public void UpdateElectronicDevices(ElectronicDevice D)
        {
            if (D==null)
            {
                System.out.println("Can't be updated!!");
                return;
            }
            int ind=devices.indexOf(D);
            Scanner scan=new Scanner(System.in);
            String option="0";
            ElectronicDevice toBeAdded=D;
            while(true)
            {
                System.out.print("What would you like to update :\n\tA-Exit Without Saving\n\t0-Exit and save\n\t1-Brand \n\t2-model\n\t3-color\n\t4-capacity\n\t"
                        + "5-price\n\t6-quantity\n\t");
                if (toBeAdded instanceof Laptop)
                {
                    System.out.print("7-CPU\n");
                }
                else if (toBeAdded instanceof SmartWatch)
                {
                    System.out.print("7-Band Type\n");
                }
                else if (toBeAdded instanceof Tablet)
                {
                    System.out.print("7-Port Type\n");
                }
                else if (toBeAdded instanceof SmartPhone)
                {
                    System.out.print("7-Camera Resolution\n");
                }
                option= scan.nextLine();
                  
                switch (option)
                {
                    case "0":
                            {
                               devices.set(ind, toBeAdded);
                               System.out.println("Succesfully updated"); 
                               return;
                            }
                    case "A":
                              {
                                      return;
                               }
                    case "1":
                    {
                        System.out.print("New Brand : ");
                        toBeAdded.setBrand(scan.nextLine());
                        break;
                    }
                    case "2":
                    {
                        System.out.print("New model : ");
                        toBeAdded.setModel(scan.nextLine());
                        break;
                    }
                    case "3":
                    {
                        System.out.print("New color : ");
                        toBeAdded.setColor(scan.nextLine());
                        break;
                    }
                    case "4":
                    {
                        int capacity = 0;
                        boolean  isValidInput = false;//to check if the entered is a valid integer
                         while (!isValidInput || capacity<=0)
                          {
                               System.out.print("Enter the new capacity: ");
                               String input = scan.nextLine();
                             try {
                                 capacity = Integer.parseInt(input);// if its a string it will catch the exception before seting the isvalid to true
                                 isValidInput = true;
                                 } catch (NumberFormatException e) {
                                                System.out.println("Invalid input: please enter a valid number.");
                                                                   }
                           }
                      toBeAdded.setCapacity(capacity);
                      break;
                    }
                    case "5":
                    {
                                    boolean isValidInput = false;
                                    double price=0.00;
                                    while (!isValidInput || price<=0)
                                    {
                                         System.out.print("Enter the new price in U$D number: ");
                                         String input = scan.nextLine();
                                            try {
                                                  price = Double.parseDouble(input);
                                                     isValidInput = true;
                                                } catch (NumberFormatException e) {
                                                  System.out.println("Invalid input: please enter a valid price.");
                                                                                    }
                                    }
                           toBeAdded.setPrice(price);
                           break;
                    }
                    case "6":
                    {
                                        int qty = 0;
                                       boolean  isValidInput = false;
                                        while (!isValidInput || qty<=0)
                                         {
                                              System.out.print("Enter the new quantity: ");
                                              String input = scan.nextLine();
                                            try {
                                                qty = Integer.parseInt(input);
                                                isValidInput = true;
                                                } catch (NumberFormatException e) {
                                                               System.out.println("Invalid input: please enter a valid number.");
                                                                                  }
                                          }
                       toBeAdded.setQuantity(qty);
                       break;
                    }
                    case"7":
                    {
                        if ((toBeAdded.getDeviceType()).equalsIgnoreCase("Laptop")|| toBeAdded instanceof Laptop)
                        {
                            System.out.println("Enter new CPU:");
                            ((Laptop) toBeAdded).setCPU(scan.nextLine());
                        }
                        else if ((toBeAdded.getDeviceType()).equalsIgnoreCase("Smart Watch")|| toBeAdded instanceof SmartWatch)
                        {
                            System.out.println("Enter new band type    :");
                            ((SmartWatch) toBeAdded).setBandType(scan.nextLine());
                        }
                        else if ((toBeAdded.getDeviceType()).equalsIgnoreCase("Tablet")|| toBeAdded instanceof Tablet)
                        {
                            System.out.println("Enter new port type  :");
                            ((Tablet) toBeAdded).setPortType(scan.nextLine());
                        }
                        else if ((toBeAdded.getDeviceType()).equalsIgnoreCase("Smart Phone")|| toBeAdded instanceof SmartPhone)
                        {
                            System.out.println("Enter new camera resolution  :");
                            ((SmartPhone) toBeAdded).setcameraResolution(scan.nextLine());
                        }
                        break;
                    }       
                    default:
                    {
                        System.out.println("kindly enter a valid input");
                        break;
                    }
                }
            }
        }      
    
        public void buyElectronicDevice(ElectronicDevice d, int orderedQty)
        {
            int deviceQty = d.getQuantity();
            if (deviceQty<orderedQty){
                System.out.println("The ordered quantity is larger than the available quantity\t Available quantity: "+deviceQty);
                return;
            }
            d.setQuantity(deviceQty-orderedQty);
        }
    }   