package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;
import service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/home")
	public ModelAndView displayEmployees() {
		ModelAndView mv = new ModelAndView();
		List<Employee> employeeList = employeeService.getAllEmployees();
		mv.addObject("employeeList", employeeList);
		mv.setViewName("home.html");
		return mv;
	}

	// gets the add employee form
	@GetMapping("/addEmp")
	public String getAddEmployeeForm() {
		return "add_employee.html";
	}

	// post call for employee
	@PostMapping("/employee")
	public String addEmployee(Employee employee, Model model) {
		model.addAttribute("message", "Employee added successfully!");
		Employee emp = employeeService.addEmployee(employee);
		return "success.html";
	}

	// gets the delete form
	@GetMapping("/deleteEmp")
	public String getDeleteEmpForm() {
		return "delete_employee.html";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam String eid, Model model) {
		Employee emp = employeeService.getEmployee(Integer.parseInt(eid));
		if (emp != null) {
			employeeService.deleteEmployee(Integer.parseInt(eid));
			model.addAttribute("message", "Employee Deleted Successfully!");
		} else {
			model.addAttribute("message", "Employee with the eid " + eid + " does not exist!");
		}
		return "success.html";
	}

	// gets the delete form
	@GetMapping("/updateEmp")
	public String getUpdateForm() {
		return "update_employee.html";
	}

	@RequestMapping("/update")
	public String updateEmployee(Employee employee, Model model) {
		Employee emp = employeeService.getEmployee(employee.getEid());
		if (emp != null) {
			Employee empl = employeeService.addEmployee(employee);
			model.addAttribute("message", "Employee Updated Successfully!");
		}else {
			model.addAttribute("message", "Employee with the id "+employee.getEid()+" does not exist!");
		}
		return "success.html";
	}
}
