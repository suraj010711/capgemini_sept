package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Tester {

	public static void main(String[] args) {

		String dbURL = "jdbc:postgresql://localhost:5432/Test";
		Properties parameters = new Properties();
		parameters.put("user", "postgres");
		parameters.put("password", "root");
		Connection conn;
		try {
			 conn = DriverManager.getConnection(dbURL, parameters);
			if (conn != null) {
				System.out.println("Connected to database ");
			}

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM students");
			while (rs.next()) {
				System.out.println("Student ID: " + rs.getString(1) + " Student Name: " + rs.getString(2));

			}
			rs.close();
			st.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
