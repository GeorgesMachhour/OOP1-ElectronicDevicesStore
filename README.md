
Electronic Devices Store Backend System
This repository contains the backend system for an electronic devices store. The application is designed to manage various electronic devices such as laptops, smartphones, smartwatches, and tablets. It provides functionalities for adding, searching, updating, deleting, sorting, and saving modifications of items. The backend system is built using Java and incorporates principles of Object-Oriented Programming (OOP) to ensure modularity, flexibility, and maintainability.

Table of Contents
Features
Class Structure
Data Handling
Setup
Usage
Contributing
License
Features
Manage electronic devices including laptops, smartphones, smartwatches, and tablets.
Add, search, update, and delete items.
Sort items and save modifications.
Support for multiple data storage formats (CSV, JSON, MongoDB).
Class Structure
Item Categories Representation
ElectronicDevice: Superclass for all electronic devices. Contains common attributes such as ID, brand, model, color, capacity, quantity, and price.
Laptop, Smartphone, SmartWatch, Tablet: Subclasses extending ElectronicDevice with additional attributes specific to their category (e.g., CPU for laptops, camera resolution for smartphones).
Data Handling
dataHandeling Interface: Defines methods for writing and reading electronic device data from different sources. Implemented by:
CSV Class: Handles CSV file operations using BufferedReader and BufferedWriter.
Json Class: Manages JSON file operations using JSON parsing libraries.
Mongo Class: Interacts with MongoDB using the MongoDB Java driver.
Core Classes
dataBase.java: Manages electronic devices and interacts with data sources. Handles CRUD operations and maintains an in-memory list of devices to optimize performance and ensure data integrity.
Main.java: Entry point providing a command-line interface for users to interact with the electronic device database.
Setup
Clone the repository:

bash
Copy code
git clone https://github.com/your-username/electronic-devices-store.git
cd electronic-devices-store
Compile the project:

bash
Copy code
javac -cp .:path/to/external/libraries Main.java
Run the application:

bash
Copy code
java -cp .:path/to/external/libraries Main
Usage
Follow the command-line prompts to add, search, update, delete, buy, and sort electronic devices.
Data is stored in the selected format (CSV, JSON, or MongoDB) and can be modified through the provided interface.
Contributing
Contributions are welcome! Please submit a pull request or open an issue to discuss any changes or enhancements.

License
This project is licensed under the MIT License. See the LICENSE file for details.
