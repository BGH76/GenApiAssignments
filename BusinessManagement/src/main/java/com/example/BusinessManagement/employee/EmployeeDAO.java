package com.example.BusinessManagement.employee;

import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDAO {

    public List<Employee> getData() {
        try {
            List<Employee> employeeData = Files.readAllLines(Paths.get("employee.txt"))
                    .stream()
                    .map(m -> m.split(","))
                    .map(e -> new Employee(Integer.parseInt(e[0]), e[1], e[2], e[3], e[4], LocalDate.parse(e[5]), Boolean.valueOf(e[6])))
                    .collect(Collectors.toList());
            return employeeData;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveData(List<Employee> list) {
        try {
            PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("Employee.txt")));
            list.stream()
                    .map(m -> String.format("%s,%s,%s,%s,%s,%s,%s",
                            m.getId(),
                            m.getName(),
                            m.getPhoneNumber(),
                            m.getAddress(),
                            m.getEmail(),
                            m.getHireDate(),
                            m.isActiveEmployee()))
                    .forEach(pw::println);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
