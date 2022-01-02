package repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
}
