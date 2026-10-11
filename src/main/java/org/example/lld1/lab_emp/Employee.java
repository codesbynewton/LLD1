package org.example.lld1.lab_emp;


public class Employee {
    String empId;
    String name;
    String email;
    String dept;
    double salary;
    int yoe;


    void promoteEmployee(int salPercentage){
        salary = salary + (salary*salPercentage/100);
        System.out.println("The employee has been promoted");
    }

    void changeDept(String newDept){
        dept = newDept;
        System.out.println("The employee has been promoted");
    }

    void displayDetails(){
        System.out.println(empId);
        System.out.println(name);
        System.out.println(email);
        System.out.println(dept);
        System.out.println(salary);
    }


}
