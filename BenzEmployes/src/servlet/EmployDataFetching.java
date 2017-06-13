package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employe;
import jdbc.EmployService;

public class EmployDataFetching extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empID = request.getParameter("empid");
		EmployService service = new EmployService();

		Employe employe = service.getEmployeeData(empID);
		if (employe != null) {
			request.setAttribute("empData", employe);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp_pages/EmployUpdate.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/display.do");
			dispatcher.forward(request, response);
		}
	}

}
