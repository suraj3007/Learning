package main.java.com.pluralsight.adapter;

import java.util.ArrayList;
import java.util.List;

//Creating the list of employees from different sources
public class EmployeeClient {

    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        Employee employeeFromDb = new EmployeeDb("123", "Suraj", "Singh", "suraj.singh@here.com");
        employees.add(employeeFromDb);

        //Will not work..!! This is where Adapter comes into play
        //Employee employeeFromLdap = new EmployeeLdap("123", "Suraj", "Singh", "suraj.singh@here.com");

        /**
         * AdapterLdap : Since EmployeeLdap (Consider it as legacy code) not implmenting the Employee interface
         * Sometime in real world scenario, we are unable to touch the legacy code.
         * So we use Adapter to plugin legacy code with new requirement
         */
        EmployeeLdap employeeLdap = new EmployeeLdap("456", "tank", "milan", "milan.tank@here.com");
        employees.add(new EmployeeAdapterLdap(employeeLdap));

        /**
         * AdapterCsv : Since EmployeeCsv (Consider it as legacy code) not implmenting the Employee interface
         * Sometime in real world scenario, we are unable to touch the legacy code.
         * So we use Adapter to plugin legacy code with new requirement
         */
        EmployeeCsv employeeCsv = new EmployeeCsv("789,Abhishek,Tiwari,abhishek.tiwari@here.com");
        employees.add(new EmployeeAdapterCsv(employeeCsv));

        return employees;
    }
}
