package coditas.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtil {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			String url2 = "jdbc:mysql://localhost:3306/coditas?user=root&password=admin";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url2);
			if (connection != null) {
				System.out.println("Connected to the database test2");
			}
			return connection;
	} catch (SQLException ex) {
			System.out.println(" An error occurred ");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not loaded");
			e.printStackTrace();
		}
		
		return connection;
	}

}
