package info.inetsolv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import info.inetsolv.dto.Employee;

public class EmployeeDAO {

	private static Connection connection = null;

	List<Employee> empList = new ArrayList<Employee>();

	public List<Employee> retriveData(Employee employee) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kumar", "kumar");
			String sql = "select * from emp_tbl where eno=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, employee.getEno());
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {

				employee.setEno(resultSet.getInt("eno"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setAddress(resultSet.getString("address"));
				employee.setGender(resultSet.getString("gender"));
				employee.setMaritalStatus(resultSet.getString("maritalStatus"));
				empList.add(employee);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return empList;
	}

	public List<Employee> retriveAllData(Employee employee) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kumar", "kumar");
			String sql = "select * from emp_tbl";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {

				employee.setEno(resultSet.getInt("eno"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setAddress(resultSet.getString("address"));
				employee.setGender(resultSet.getString("gender"));
				employee.setMaritalStatus(resultSet.getString("maritalStatus"));
				empList.add(employee);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				connection.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return empList;
	}
}
