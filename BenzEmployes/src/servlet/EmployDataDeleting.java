package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.EmployService;

public class EmployDataDeleting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empID = request.getParameter("empid");
		EmployService service = new EmployService();
		boolean status = service.deletingEmployData(empID);
		try {
			if (status) {
				request.getRequestDispatcher("/display.do").forward(request, response);
			}
		} catch (Exception e1) {
			System.out.println("Error while deleting data in servlet statement");
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
