package spring.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.dao.EmployeeDAO;
import spring.entity.Employee;

public class App {

	public static void main(String[] args) {

		ApplicationContext IOC = new ClassPathXmlApplicationContext("Application.xml");
		EmployeeDAO edb = IOC.getBean("edb", EmployeeDAO.class);
    	Employee emp = new Employee(3,"Boby","Male",12500);
    	edb.saveEmployeeByPreparedStatement(emp);
//    	edb.saveEmployee(emp);
//    	edb.updateEmployee(emp);
    	
    	System.out.println("Update successfully");
    	List employee = edb.getAll(emp);
    	for (Object object : employee) {
			System.out.println(object);
		}
	}

}
