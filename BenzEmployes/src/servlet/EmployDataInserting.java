package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employe;
import jdbc.EmployService;


public class EmployDataInserting extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	Employe employe = new Employe();
    	
    	employe.setEmpId(request.getParameter("empId"));
    	employe.setEmpName(request.getParameter("empName"));
    	employe.setEmpPhoneNumber(Long.parseLong(request.getParameter("empPhoneNumber")));
    	employe.setEmpAddress(request.getParameter("empAddress"));
    	employe.setEmpGender(request.getParameter("empGender"));
    	employe.setEmpEmail(request.getParameter("empEmail"));
    	
    	EmployService service =new EmployService();
    	PreparedStatement statement=service.insertingEmployData();
    	boolean status=false;
    	try {
    		
			statement.setString(1, employe.getEmpId());
			statement.setString(2, employe.getEmpName());
			statement.setLong(3, employe.getEmpPhoneNumber());
			statement.setString(4, employe.getEmpAddress());
			statement.setString(5, employe.getEmpGender());
			statement.setString(6, employe.getEmpEmail());
			 status=statement.execute();
			 
			System.out.println("inseting "+status);
			PrintWriter writer=response.getWriter();
			writer.print(status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while loading the statement");
			e.printStackTrace();
		}
    	if(status!=false){
    		RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp_pages/Home_failure.jsp");
        	dispatcher.forward(request, response);
    	}else {

        	RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp_pages/Home_success.jsp");
        	dispatcher.forward(request, response);
		}
    }    
   
}
