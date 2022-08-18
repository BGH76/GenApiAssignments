package com.example.BusinessManagement.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee getEmployee(int id) {
        List<Employee> temp = employeeDAO.getData()
                .stream()
                .filter(f -> f.getId() == id).toList();
        if(temp.size() > 0 && temp.get(0).isActiveEmployee()) {
            return temp.get(0);
        }
        return null;
    }
    public List<Employee> getEmployees() {
        List<Employee> temp = employeeDAO.getData()
                .stream()
                .filter(f -> f.isActiveEmployee())
                .collect(Collectors.toList());
        return temp;
    }

    public List<Employee> getPastEmployees() {
        List<Employee> temp = employeeDAO.getData()
                .stream()
                .filter(f -> !f.isActiveEmployee())
                .collect(Collectors.toList());
        return temp;
    }
    public void addNewEmployee(Employee employee) {
        List<Employee> temp = employeeDAO.getData();
        List<Integer> idNumber = temp.stream().map(Employee::getId).toList();
        employee.setId(Collections.max(idNumber) + 1);
        employee.setActiveEmployee(true);
        employee.setHireDate(LocalDate.now());
        temp.add(employee);
        employeeDAO.saveData(temp);
    }
    public void updateEmployee(int id, String name, String phoneNumber, String address, String email) {
        List<Employee> temp = employeeDAO.getData();
        temp.forEach(e -> {
            if(e.getId() == id) {
                e.setName(name);
                e.setPhoneNumber(phoneNumber);
                e.setAddress(address);
                e.setEmail(email);
            }
        });
        employeeDAO.saveData(temp);
    }
    public void deleteEmployee(int id) {
        List<Employee> temp = employeeDAO.getData();
        temp.forEach(e -> {
            if(e.getId() == id) {
                e.setActiveEmployee(false);
            }
        });
        employeeDAO.saveData(temp);
    }
}
