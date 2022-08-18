package com.example.BusinessManagement.employee;

import java.time.LocalDate;

public class Employee {

    private  int id;
    private  String name;
    private  String phoneNumber;
    private  String address;
    private  String email;
    private  LocalDate hireDate;
    private  boolean activeEmployee;

    public Employee() {
    }

    public Employee(int id, String name, String phoneNumber, String address, String email, LocalDate hireDate, boolean activeEmployee) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.hireDate = hireDate;
        this.activeEmployee = activeEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isActiveEmployee() {
        return activeEmployee;
    }

    public void setActiveEmployee(boolean activeEmployee) {
        this.activeEmployee = activeEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", hireDate=" + hireDate +
                ", activeEmployee=" + activeEmployee +
                '}';
    }
}
