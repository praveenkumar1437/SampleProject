package info.inetsolv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.inetsolv.dto.Employee;
import info.inetsolv.service.EmployeeService;

@WebServlet(name = "employee", urlPatterns = { "/employee" })
public class EmployeeFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String eno = request.getParameter("eno");

		Integer number = 0;
		
		try {
			
			if(eno != null) 
				number = Integer.parseInt(eno);
			
		}catch (Exception e) {

			number = 0;
		}
		
		Employee employee = new Employee();
		employee.setEno(number);
		
		EmployeeService employeeService = new EmployeeService();
		List<Employee> list = employeeService.Retrive(employee);
		
		request.setAttribute("list", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("display");
		requestDispatcher.forward(request, response);

	}

}
