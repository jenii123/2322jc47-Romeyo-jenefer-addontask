package Home_task;

import java.sql.*;
import java.util.*;
public class ProductDB {
 static final String URL="jdbc:mysql://localhost:3306/productdb";
 static final String USER="root";
 static final String PASS="Priya@10";
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		while(true) {
		System.out.println("\n1.Add Product\n2.View Product\n3.Search Product\n4.Exit");
		System.out.println("Enter your option:");
		int option = s.nextInt();
		s.nextLine();
		switch (option) {
		case 1: {
			addProduct(s);
			break;}
		case 2: {
			viewProduct();
			break;}
		case 3: {
			SearchProduct(s);
			break;}
		case 4:{
			System.out.println("Goodbye!");
			break;}
		default:
			System.out.println("invalid option.");
		}
		}
			}

	static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASS);	
		
		}

static void addProduct(Scanner s) {
	try (Connection con = getConnection()){
		System.out.println("Enter Product Name:");
		String name = s.nextLine();
		System.out.println("Enter Product Quantity:");
		int quantity = s.nextInt();
		System.out.println("Enter Product Price:");
		double price=s.nextDouble();
		
		String sql="insert into prod(name,quantity,price) values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setInt(2, quantity);
		ps.setDouble(3, price);
		ps.executeUpdate();
		System.out.println("Prodect Added Successfully!");
	} catch (Exception e) {
		e.printStackTrace();
	}
}

static void viewProduct() {
	try(Connection con = getConnection()) {
		String sql = "select * from prod";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		System.out.println("ID| NAME   |QTY| PRICE ");
		while(rs.next()) {
			System.out.printf("%d | %s | %d | %s\n",
		        	rs.getInt("id"),rs.getString("name"),rs.getInt("quantity"),rs.getDouble("price"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
static void SearchProduct(Scanner s) {
	try(Connection con = getConnection()) {
		System.out.println("Enter Product id:");
		int id = s.nextInt();
		
		String sql ="select * from prod where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("Product Name:"+rs.getString("name"));
			System.out.println("Product Quantity:"+rs.getInt("quantity"));
			System.out.println("Product Price:"+rs.getDouble("price"));
		}else {
			System.out.println("Product Not Found");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
}







