package coditas.empService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import coditas.dbUtil.MySQLConnUtil;

public class EmpDetailsService {

	public List empDetails() {
		Connection connection = MySQLConnUtil.getConnection();
		List list = new ArrayList();
				try {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM employee";

			// create the java statement
			Statement st = connection.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getInt(1));
				list.add(rs.getString(2));
				list.add(rs.getInt(3));
				list.add(rs.getInt(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
				list.add(rs.getString(8));
				list.add(rs.getString(9));
				list.add(rs.getString(10));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
