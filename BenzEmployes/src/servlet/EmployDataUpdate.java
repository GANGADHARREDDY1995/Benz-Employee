package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employe;
import jdbc.EmployService;

public class EmployDataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employe employe = new Employe();

		employe.setEmpId(request.getParameter("empId"));
		employe.setEmpName(request.getParameter("empName"));
		employe.setEmpPhoneNumber(Long.parseLong(request.getParameter("empPhoneNumber")));
		employe.setEmpAddress(request.getParameter("empAddress"));
		employe.setEmpGender(request.getParameter("empGender"));
		employe.setEmpEmail(request.getParameter("empEmail"));

		EmployService service = new EmployService();
		boolean status = service.updatingEmployData(employe);
		if (status == false) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/display.do");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp_pages/Home_failure.jsp");
			dispatcher.forward(request, response);
		}
	}

}
