package main.java.com.pluralsight.adapter;

/**
 * Here, this adapter will implement the Employee interface.
 * Adapter will return the value as per requirement from the wrapped instance of EmployeeLdap.
 */
public class EmployeeAdapterLdap implements Employee {

    //Here, we will create the instance for which the Adapter we are writing
    private EmployeeLdap instance;

    public EmployeeAdapterLdap(EmployeeLdap instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return instance.getSurName();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
    }

    @Override
    public String toString() {
        return "ID : "+ getId() + ", FirstName : " + getFirstName() +
                ", LastName : " + getLastName() + ", Email : " + getEmail();
    }
}
