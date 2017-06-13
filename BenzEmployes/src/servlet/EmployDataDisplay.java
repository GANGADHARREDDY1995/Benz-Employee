package servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employe;
import jdbc.EmployService;


public class EmployDataDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployService service = new EmployService();
		PreparedStatement statement=service.displayEmployData();
		
		ArrayList<Employe> employList = new ArrayList<Employe>();
		try {
			ResultSet set=statement.executeQuery();
			while (set.next()) {
				Employe employe = new Employe();
				employe.setEmpId(set.getString(1));
				employe.setEmpName(set.getString(2));
				employe.setEmpPhoneNumber(set.getLong(3));
				employe.setEmpAddress(set.getString(4));
				employe.setEmpGender(set.getString(5));
				employe.setEmpEmail(set.getString(6));
				employList.add(employe);
			}
			System.out.println("Loaded all employees data: "+employList.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while Employ data display");
			e.printStackTrace();
		}
		request.setAttribute("employData", employList);
				RequestDispatcher dispatcher = getServletConfig().getServletContext()
				.getRequestDispatcher("/jsp_pages/EmployDisplay.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
}
