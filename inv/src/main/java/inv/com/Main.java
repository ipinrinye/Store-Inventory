package inv.com;


import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n Welcome to Olu's Inventory Management System!");

        Thread.sleep(5000);
        
        // Database URL, username, and password
        /*String sql = "select * from product";
        String sqladd = "INSERT INTO Product (name, SKU, size, price) VALUES (?, ?, ?, ?)";
        String url = "jdbc:mysql://localhost:3306/inventory";
        String user = "root";
        String password = "Olakunbi1!";
        Connection conn = null;
        PreparedStatement ps = null; */

        //Menu

         int choice;
        do {
            System.out.println("\n Olu Inventory Management System");
            System.out.println("1. Add New Product");
            System.out.println("2. Update Existing Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Existing Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            //scanner.close();

            switch (choice) {
                case 1 -> Product.addProduct();
                case 2 -> Product.updateProduct();
                case 3 -> Product.deleteProduct();
                case 4 -> Product.viewInventory();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        /*
        try {
            // Load MySQL JDBC Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            
            if (conn != null) {
                System.out.println("Connected to the database!");
            }
            System.out.println("......");
            Thread.sleep(3000);
            
            //statement and query
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            System.out.println("First, let's display current Inventory...");

            Thread.sleep(5000);

            System.out.println("ID" + "\t" + "Product" + "\t" + "SKU" + "\t" + "Size" + "\t" + "Price" );

            while(rs.next()) 
            {
                System.out.println(rs.getInt("id")
                + "\t" + rs.getString("name")
                + "\t" + rs.getString("SKU")
                + "\t" + rs.getInt("size")
                + "\t" + rs.getDouble("price"));
            }
           
            //Capture from screen

            Thread.sleep(5000);

        System.out.println("Please add new produt into inventory:");

        System.out.print("Enter Product nane: ");
        String pname = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter SKU: ");
        String psku = scanner.nextLine();
        System.out.print("Enter Size: ");
        int psize = scanner.nextInt();
        System.out.print("Enter Price: ");
        double pprice = scanner.nextDouble();
        scanner.close();

            //Prepared statement to add product
            ps = conn.prepareStatement(sqladd);
            ps.setString(1,pname);
            ps.setString(2,psku);
            ps.setInt(3,psize);
            ps.setDouble(4,pprice);
            ps.executeUpdate();
            

            //Re-display the db

            Thread.sleep(5000);

            System.out.println("Now, let's see the updated Inventory....");

            Thread.sleep(5000);


            ResultSet rs1 = sta.executeQuery(sql);
            System.out.println("ID" + "\t" + "Product" + "\t" + "SKU" + "\t" + "Size" + "\t" + "Price" );

            while(rs1.next()) 
            {
                System.out.println(rs1.getInt("id")
                + "\t" + rs1.getString("name")
                + "\t" + rs1.getString("SKU")
                + "\t" + rs1.getInt("size")
                + "\t" + rs1.getDouble("price"));
            }


            // Close the connection
            conn.close();
            Thread.sleep(3000);
            System.out.println("Connection is Closed");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }

        } */
    
} 
}