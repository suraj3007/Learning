package main.java.interview;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int empId;
    private int age;
    private String dept;

    public Employee(String name, int empId, int age, String dept) {
        this.name = name;
        this.empId = empId;
        this.age = age;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public int getEmpId() {
        return empId;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                '}';
    }
}

class EmployeeDemo {
    public static void main(String[] args) {

        List<Employee> listObj = new ArrayList<>();

        Employee e1 = new Employee("Aman", 100, 28, "IT");
        Employee e2 = new Employee("Shyam", 101, 29, "Accounting");
        Employee e3 = new Employee("Ranjit", 102, 32, "HR");
        Employee e4 = new Employee("Vijay", 103, 34, "Analyst");

        Employee e5 = new Employee("Ram", 104, 35, "IT");
        Employee e6 = new Employee("Manohar", 105, 39, "Accounting");
        Employee e7 = new Employee("Anil", 106, 30, "HR");
        Employee e8 = new Employee("Nikhil", 107, 31, "Analyst");

        listObj.add(e1);
        listObj.add(e2);
        listObj.add(e3);
        listObj.add(e4);
        listObj.add(e5);
        listObj.add(e6);
        listObj.add(e7);
        listObj.add(e8);

//         Optional<Employee> e = listObj.stream()
//                .max(Comparator.comparing(Employee::getAge));

         Map<String, Optional<Employee>> employeeMap = listObj.stream()
                 .collect(Collectors.groupingBy(Employee::getDept,
                         Collectors.maxBy(Comparator.comparing(Employee::getAge))));

        Map<String, List<Employee>> employeeMap1 = listObj.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.toList()));

//        System.out.println(employeeMap.values());
        System.out.println(employeeMap1);
    }
}
