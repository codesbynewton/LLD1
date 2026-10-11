package org.example.lld1.lab_emp;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.empId = "1";
        emp1.name = "hari";
        emp1.dept = "IT";
        emp1.salary = 1000;
        emp1.yoe = 7;

        emp1.promoteEmployee(10);
        emp1.changeDept("developer");
        emp1.displayDetails();
    }
}
