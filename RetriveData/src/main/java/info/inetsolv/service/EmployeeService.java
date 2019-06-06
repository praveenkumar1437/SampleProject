package info.inetsolv.service;

import java.util.List;

import info.inetsolv.dao.EmployeeDAO;
import info.inetsolv.dto.Employee;

public class EmployeeService {
	
	private List<Employee> list;
	
	public List<Employee> Retrive(Employee employee) {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();

		Integer eno = employee.getEno();
		
		if (eno == 0) {
			
			list = employeeDAO.retriveAllData(employee);
		
		}else {
			
			list = employeeDAO.retriveData(employee);
			
		}
				
		return list;
	}

}
