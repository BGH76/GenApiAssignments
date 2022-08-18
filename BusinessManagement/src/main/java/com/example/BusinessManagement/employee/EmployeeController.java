package com.example.BusinessManagement.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/employee")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/past")
    public List<Employee> getPastEmployees() {
        return employeeService.getPastEmployees();
    }

    @PostMapping
    public void addNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") int id, String name, String phoneNumber, String address, String email) {
        employeeService.updateEmployee(id, name, phoneNumber, address, email);
    }

    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int id) {
        employeeService.deleteEmployee(id);
    }
}
