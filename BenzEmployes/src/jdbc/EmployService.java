package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Employe;

public class EmployService {
	PreparedStatement statement;
	JdbcConnection connection = JdbcConnection.getJdbcConnection();
	Connection con;

	public PreparedStatement insertingEmployData() {
		try {
			con = connection.getConnection();
			statement = con.prepareStatement("INSERT INTO  BENZ_EMPLOY values (?,?,?,?,?,?)");

			System.out.println("insert complited");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while inserting" + e.getMessage());
			e.printStackTrace();
		}
		return statement;
	}

	public PreparedStatement displayEmployData() {

		try {
			con = connection.getConnection();
			statement = con.prepareStatement("SELECT * FROM BENZ_EMPLOY");
			System.out.println("employ data display");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while displaying employ data");
			e.printStackTrace();
		}
		return statement;
	}

	public boolean deletingEmployData(String empID) {
		con = connection.getConnection();
		try {
			statement = con.prepareStatement("DELETE FROM BENZ_EMPLOY WHERE EMP_ID=?");
			statement.setString(1, empID);
			System.out.println("delete emp from table : " + empID);
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while deleting data in service method");
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatingEmployData(Employe employe) {
		con = connection.getConnection();
		try {
			statement = con.prepareStatement(
					"update BENZ_EMPLOY set EMP_NAME=?, EMP_PHONE_NUMBER=?, EMP_ADDRESS=?, EMP_GENDER=?, EMP_EMAIL=? WHERE EMP_ID=?");
			statement.setString(1, employe.getEmpName());
			statement.setLong(2, employe.getEmpPhoneNumber());
			statement.setString(3, employe.getEmpAddress());
			statement.setString(4, employe.getEmpGender());
			statement.setString(5, employe.getEmpEmail());
			statement.setString(6, employe.getEmpId());
			System.out.println("query updating in service method");
			return statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while updating query in service method");
			e.printStackTrace();
		}
		return false;
	}

	public Employe getEmployeeData(String empId) {
		Employe employe = null;
		try {
			con = connection.getConnection();
			statement = con.prepareStatement("SELECT * FROM BENZ_EMPLOY WHERE EMP_ID=?");
			statement.setString(1, empId);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				employe = new Employe();
				employe.setEmpId(set.getString(1));
				employe.setEmpName(set.getString(2));
				employe.setEmpPhoneNumber(set.getLong(3));
				employe.setEmpAddress(set.getString(4));
				employe.setEmpGender(set.getString(5));
				employe.setEmpEmail(set.getString(6));
			}
			System.out.println("employ data display");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while displaying employ data");
			e.printStackTrace();
		}
		return employe;
	}
}
