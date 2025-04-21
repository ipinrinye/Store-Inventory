package inv.com;

import java.sql.*;
import java.util.Scanner;


public class Product 
    {
        int id;
        String name;
        String SKU;
        int size;
        double price;
    
        public Product (int id, String name, String SKU, int size, double price) {
            this.id = id;
            this.name = name;
            this.SKU = SKU;
            this.size = size;
            this.price = price;
        }

        static Scanner scanner = new Scanner(System.in);

        // Database URL, username, and password
static String sql = "select * from product";
static String sqladd = "INSERT INTO Product (name, SKU, size, price) VALUES (?, ?, ?, ?)";
static String sqlupdate = "UPDATE product SET SKU = ?, size =?, price =? WHERE name = ?";
static String sqldelete = "DELETE from Product where id =?";
static String url = "jdbc:mysql://localhost:3306/inventory";
static String user = "root";
static String password = "Olakunbi1!";
static Connection conn = null;
static PreparedStatement ps = null;
        

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", SKU: \" + SKU + \",  Size: " + size + ", Price: $" + price;
        }

//this method is activated when user selectd add product in main menu

        public static void addProduct() {
            try {
            // Load MySQL JDBC Driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            
            if (conn != null) {
                System.out.println("Connected to the database to add new product!");
            }
            System.out.println("......");
    ;
            
            //statement and query
        
            System.out.println("Please add new product into inventory:");

            Thread.sleep(3000);

        System.out.print("Enter Product nane: ");
        String pname = scanner.nextLine();
        //scanner.nextLine();
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

            conn.close();
                Thread.sleep(3000);
                System.out.println("Connection is Closed");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } catch (InterruptedException e) {
                    e.printStackTrace();
                }
             
        }

//this method is activated when user selects update product in main menu

        

        public static void updateProduct(){
            try {
                // Load MySQL JDBC Driver 
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Create a connection to the database
                conn = DriverManager.getConnection(url, user, password);
                
                if (conn != null) {
                    System.out.println("Connected to the database to update Inventory!");
                }
                System.out.println("......");

                int status = 0;
        ;
                
                //statement and query
            
                System.out.println("What product do you want to update?");
    
            System.out.print("Enter Product to update nane: ");
            String updatename = scanner.nextLine();
            //scanner.nextLine();
            System.out.print("Enter SKU: ");
            String updatesku = scanner.nextLine();
            System.out.print("Enter Size: ");
            int updatesize = scanner.nextInt();
            System.out.print("Enter Price: ");
            double updateprice = scanner.nextDouble();
            scanner.close();
    
                //Prepared statement to update product
                ps = conn.prepareStatement(sqlupdate);
                ps.setString(1,updatesku);
                ps.setInt(2,updatesize);
                ps.setDouble(3,updateprice);
                ps.setString(4, updatename);
                status = ps.executeUpdate();

                System.out.printf("/n You updated %d products with the name %d /n", status, updatename);

                Thread.sleep(2000);
    
                conn.close();
                    Thread.sleep(3000);
                    System.out.println("Connection is Closed");
    
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



        }

//this method is activated when user selects delete product in main menu

        public static void deleteProduct(){

            try {
                // Load MySQL JDBC Driver 
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Create a connection to the database
                conn = DriverManager.getConnection(url, user, password);
                
                if (conn != null) {
                    System.out.println("Connected to the database to delete a product!");
                }
                System.out.println("...Have the ID ready.....");

                Thread.sleep(2000);
                
                //statement and query
            
                System.out.println("What product do you want to delete?");
    
            System.out.print("Enter Product ID: ");
            int deleteid = scanner.nextInt();
            //scanner.nextLine();
            scanner.close();
    
                //Prepared statement to update product
                ps = conn.prepareStatement(sqldelete);
                ps.setInt(1,deleteid);
                
                ps.executeUpdate();

                System.out.printf( "\n You deleted product with ID: %d \n", deleteid);

    
                conn.close();
                    Thread.sleep(3000);
                    System.out.println("Connection is Closed");
    
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            } catch (InterruptedException e) {
                        e.printStackTrace();
                    }




        }

//this method is activated when user selects view inventory in main menu

        public static void viewInventory() throws InterruptedException{
        
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
                System.out.println("Now, let's display current Inventory...");
    
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
               
                conn.close();
                Thread.sleep(3000);
                System.out.println("Connection is Closed");
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC Driver not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            }



        }
    }
    
    

