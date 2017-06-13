package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	static JdbcConnection jdbcConnection = new JdbcConnection();
	Connection connection;

	private JdbcConnection() {

	}
	
	public static JdbcConnection getJdbcConnection(){
		return jdbcConnection;
	}
	public Connection getConnection() {
		try {
			if (connection == null) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("class is loaded");
				try {
					connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "practice",
							"varun");
					System.out.println("load new connection");
				} catch (SQLException e) {
					System.out.println("Error while load the connection" + e.getMessage());
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("returning existing connection");
				return connection;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error while load the class" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
