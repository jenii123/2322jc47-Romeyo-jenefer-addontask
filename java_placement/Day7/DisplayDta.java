package Day7;

import java.sql.*;

public class DisplayDta {

	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","Priya@10");
			Statement st = con.createStatement();
			
			
			ResultSet rs = st.executeQuery("Select * from student");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
			}
		}
		catch (Exception e) {
			System.out.println("Connection failed"+e.toString());
		}

	}

}
