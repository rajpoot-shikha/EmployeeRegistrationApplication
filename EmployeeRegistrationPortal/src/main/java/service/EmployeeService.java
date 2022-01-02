package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Employee;
import repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
 
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
		return employeeList;
	}
	
	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;	
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee getEmployee(int id) {
		Employee emp = (Employee)employeeRepository.findById(id).orElse(null);
		return emp;
	}
}
