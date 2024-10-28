# workbook-4

# Car Dealership

The **Car Dealership** project is a Java-based application that allows users to interact with a virtual vehicle inventory. This application enables users to view, filter, add, and remove vehicles within the inventory stored in a CSV file (`inventory.csv`), making it easy to manage dealership inventory data.

## Features

- **View all vehicles**: Display a full list of all vehicles in inventory.
- **Filter vehicles** by various criteria:
  - Price range
  - Make and model
  - Year range
  - Color
  - Mileage range
  - Vehicle type
- **Add a new vehicle**: Add a new vehicle to the inventory.
- **Remove a vehicle**: Remove an existing vehicle from the inventory by VIN.

## Project Structure

The application comprises several classes:

- **Program**: The main entry point of the application.
- **UserInterface**: Handles user input and interactions, providing the main interface for filtering and managing vehicles.
- **Dealership**: Manages a list of `Vehicle` objects and provides methods for filtering and manipulating vehicle data.
- **DealershipFileManager**: Manages reading from and writing to the `inventory.csv` file to persist dealership data.
- **Vehicle**: Represents individual vehicle data including attributes like VIN, year, make, model, color, odometer reading, and price.

## Usage

Once the application is running, you will be presented with a menu to choose from the following options:

- **A) Filter vehicles by price**
- **B) Filter vehicles by make and model**
- **C) Filter vehicles by year**
- **D) Filter vehicles by color**
- **E) Filter vehicles by mileage**
- **F) Filter vehicles by type**
- **G) Show all vehicles**
- **H) Add new vehicle to dealership**
- **I) Remove vehicle from dealership**
- **X) Exit application**

## Menu screenshot
![image](https://github.com/user-attachments/assets/11794b15-2e82-4a7f-9790-e21ea3813864)

## Showing all vehicles screenshot
![image](https://github.com/user-attachments/assets/0d566fb5-e376-4e1f-b077-9c9a425fef4e)



### Example Commands

- **Filtering by price**: Enter a minimum and maximum price to view vehicles within that range.
  ![image](https://github.com/user-attachments/assets/c634466e-8eee-4718-a47b-0cb0f2b1c27f)

- **Adding a vehicle**: Follow prompts to enter vehicle details (e.g., VIN, make, model, year, color, mileage, and price).
  ![image](https://github.com/user-attachments/assets/73e4039b-e79a-40dd-8f53-05b0b28ac4c6)

- **Removing a vehicle**: Enter the VIN of the vehicle to remove it from inventory.
  ![image](https://github.com/user-attachments/assets/c9205299-0f99-434a-9a4c-9818badc6acf)


## Interesting code
### Stream-based Filtering in Inventory Search

This project uses Java Streams to efficiently filter the `inventory` list based on conditions like price range or make and model. Here’s why this approach is beneficial:

- **Efficient Processing**: The `Stream` API applies filtering only when necessary (lazy evaluation), which can be faster than traditional loops, especially for large datasets.
- **Readable and Concise**: By using `.filter()` with lambda expressions, the code is cleaner and follows functional programming principles, enhancing readability and reducing complexity.
- **Immutable Results**: The `.toList()` method creates a new list with the filtered items, leaving the original inventory unchanged, which is safer and more predictable.

![image](https://github.com/user-attachments/assets/6cde6d88-aa54-4937-9d5f-788af799ee10)


