# Parking Spot Finder App

## Introduction
The Parking Spot Finder App is a comprehensive solution designed to streamline the management of parking lots. It allows parking lot operators to efficiently handle various tasks such as managing parking spots, tracking bookings, and overseeing transactions. This application is ideal for improving the utilization of parking resources and enhancing user experience for both operators and drivers.

## Features
- **User Account Management:** Secure login and management of user profiles for both drivers and operators.
- **Parking Spot Management:** Operators can add, delete, and update parking spots.
- **Booking System:** Drivers can book parking spots in advance, check-in, and check-out with ease.
- **Transaction Handling:** Automated calculation of parking fees based on duration, with support for promotional rates and discounts.
- **Real-Time Updates:** Live updates on parking spot availability to minimize wait times and optimize parking space usage.
- **Historical Data:** Access to historical booking and transaction data for both users and operators.

## Installation

### Prerequisites
- Oracle Database 12c or later
- JavaFX SDK 17 or later
- JDK 11 or later

### Database Setup
1. Clone the repository.
2. Navigate to the `sql` directory.
3. Run the SQL scripts provided to set up the database schema and populate the tables with initial data:
   
   ```
   sqlplus username/password@localhost @setup.sql
   ```

### Application Setup
1. Ensure JavaFX is correctly configured on your IDE.
2. Open the project in your IDE.
3. Set the classpath to include the JavaFX library and configure the VM options:
   
   ```
   --module-path path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
   ```
5. Build and run the application.

## Usage
- **Operator:**
  - Log in using your operator credentials.
  - Manage parking lots and spots through the dashboard.
  - View and handle bookings and transactions.
- **Driver:**
  - Register or log in.
  - Search for available parking spots.
  - Book, check-in, and check-out of spots.
  - View booking history and transactions.

## Contributing
Contributions to the Parking Spot Finder App are welcome! If you have suggestions for improvements or new features, feel free to fork this repository, make your changes, and submit a pull request.


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
