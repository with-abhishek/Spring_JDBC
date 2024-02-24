package spring.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import spring.entity.Employee;

public class EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Employee> getAll(Employee e)
	{
		return jdbcTemplate.query("select * from employee", new EmployeeMapper());
	}

	public int saveEmployee(Employee e) {
		String query = "insert into employee values('" + e.getId() + "','" + e.getName() + "','" + e.getGender() + "','"
				+ e.getSalary() + "')";
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	public Boolean saveEmployeeByPreparedStatement(Employee e) {
		String query = "insert into employee values(?,?,?,?)";
		return jdbcTemplate.execute(query, (PreparedStatementCallback<Boolean>) ps -> {
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getGender());
			ps.setInt(4, e.getSalary());
			return ps.execute();
		});
	}

	public int updateEmployee(Employee e) {
		String query = "update employee set name='" + e.getName() + "',gender='" +e.getGender()+"',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "' ";
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e) {
		String query = "delete from employee where id='" + e.getId() + "' ";
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

}
