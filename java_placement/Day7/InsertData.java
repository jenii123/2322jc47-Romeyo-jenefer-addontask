package Day7;

import java.sql.*;

public class InsertData {

	public static void main(String[] args) {
		try {
			String quary = "insert into student (id,name,age,dept) values(?,?,?,?)";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","Priya@10");
			PreparedStatement ps = con.prepareStatement(quary);
			ps.setInt(1, 5);
			ps.setString(2,"ram");
			ps.setInt(3, 20);
			ps.setString(4, "IT");
			ps.executeUpdate();
			System.out.println("Data Inserted Successfully...");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
