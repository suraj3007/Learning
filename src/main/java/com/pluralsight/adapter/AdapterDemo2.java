package main.java.com.pluralsight.adapter;

import java.util.List;

/**
 * Client wants the list of employees from different database
 */
public class AdapterDemo2 {
    public static void main(String[] args) {

        EmployeeClient client = new EmployeeClient();
        List<Employee> employeeList = client.getEmployeesList();
        System.out.println(employeeList);
    }
}
