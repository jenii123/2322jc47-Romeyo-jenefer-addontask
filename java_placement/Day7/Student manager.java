package Day7;

import java.sql.*;
import java.util.Scanner;

public class StudentManager {
	static final String URL="jdbc:mysql://localhost:3306/day7";
	static final String USER="root";
	static final String PASS="Priya@10";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n1.Add Student\n2.View Student\n3.Search by id\n4. Exit");
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: {
				addstudent(sc);
				break;
			}
			case 2:{
				viewstudent();
				break;
			}
			case 3:{
				 searchStudent(sc);
				 break;
			}
			case 4:{
				System.out.println("Goodbye!");
				return;
			}
			default:
				System.out.println("Invalid option");
			}
	}
	}
	
	
	
	static Connection getConnection() throws SQLException{
	return DriverManager.getConnection(URL,USER,PASS);	
	
	}
	
	
	

	static void addstudent(Scanner sc) {
		try(Connection con=getConnection()) {
			System.out.println("Enter Name:");
			String name = sc.nextLine();
			System.out.println("Enter age:");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Course:");
			String course=sc.nextLine();
			
			String sql = "insert into students (name,age,course) values (?,?,?)";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, course);
			ps.executeUpdate();
			System.out.println("Student added!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		
	static void viewstudent() {
		try (Connection con=getConnection()) {
			String sql = "select * from students";
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			System.out.println("ID | NAME | AGE | COURSE");
        while(rs.next()) {
        	System.out.printf("%d | %s | %d | %s\n",
        	rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("course"));
        	
        }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	static void searchStudent(Scanner sc) {
		try (Connection con=getConnection()){
			System.out.println("Enter student id:");
			int id = sc.nextInt();
			
			String sql = "select * from students where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Name: "+rs.getString("name"));
				System.out.println("age: "+rs.getInt("age"));
				System.out.println("Course: "+rs.getString("course"));
			}else {
				System.out.println("Student not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}
