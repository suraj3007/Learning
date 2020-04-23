package main.java.com.pluralsight.adapter;

/**
 * Here, this adapter will implement the Employee interface.
 * Adapter will return the value as per requirement from the wrapped instance of EmployeeCsv.
 */
public class EmployeeAdapterCsv implements Employee {

    //Here, we will create the instance for which the Adapter we are writing
    EmployeeCsv instance;

    public EmployeeAdapterCsv(EmployeeCsv instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return instance.getId() + "";
    }

    @Override
    public String getFirstName() {
        return instance.getFirstName();
    }

    @Override
    public String getLastName() {
        return instance.getLastName();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }

    @Override
    public String toString() {
        return "ID : "+ getId() + ", FirstName : " + getFirstName() +
                ", LastName : " + getLastName() + ", Email : " + getEmail();
    }
}
