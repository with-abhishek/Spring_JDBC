package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.entity.Employee;

public  class EmployeeMapper implements RowMapper <Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setGender(rs.getString("gender"));
		e.setSalary(rs.getInt("salary"));
		
		return e;
	}
	}

