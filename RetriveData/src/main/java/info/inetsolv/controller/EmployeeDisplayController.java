package info.inetsolv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "display", urlPatterns = { "/display" })
public class EmployeeDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getAttribute("list");
				
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("displayData.jsp");
		requestDispatcher.forward(request, response);
	}

}
