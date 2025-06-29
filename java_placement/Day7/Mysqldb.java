package Day7;

import java.sql.*;

public class ConnectToMysqldb {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","Priya@10");
			System.out.println("Successfully Connected to MysqlDB!");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
