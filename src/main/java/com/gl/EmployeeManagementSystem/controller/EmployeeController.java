package com.gl.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gl.EmployeeManagementSystem.model.Employee;
import com.gl.EmployeeManagementSystem.repository.EmployeeRepository;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeRepository.findAll());
		return "employee/list";
	}

	@GetMapping("/new")
	public String createEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/form";
	}

	@PostMapping("/new")
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employees";
	}

	@GetMapping("edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
		model.addAttribute("employee", employee);
		return "employee/update_form";
	}

	@PostMapping("edit/{id}")
	public String updateEmployee(@ModelAttribute("employee") Employee updatedEmployee) {
		// Retrieve the existing employee from the database
		Employee existingEmployee = employeeRepository.findById(updatedEmployee.getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + updatedEmployee.getId()));

		// Update the existing employee's information
		existingEmployee.setFirstName(updatedEmployee.getFirstName());
		existingEmployee.setLastName(updatedEmployee.getLastName());
		existingEmployee.setEmail(updatedEmployee.getEmail());

		// Save the updated employee to the database
		employeeRepository.save(existingEmployee);

		// Redirect to the list of employees
		return "redirect:/employees";
	}

	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		return "redirect:/employees";
	}

}
