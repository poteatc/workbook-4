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

### Example Commands

- **Filtering by price**: Enter a minimum and maximum price to view vehicles within that range.
- **Adding a vehicle**: Follow prompts to enter vehicle details (e.g., VIN, make, model, year, color, mileage, and price).
- **Removing a vehicle**: Enter the VIN of the vehicle to remove it from inventory.

