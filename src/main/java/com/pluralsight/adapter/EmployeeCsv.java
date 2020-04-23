package main.java.com.pluralsight.adapter;

import java.util.StringTokenizer;

//Not implementing the Employee interface
public class EmployeeCsv {

    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public EmployeeCsv(String values) {

        StringTokenizer tokenizer = new StringTokenizer(values, ", ");
        if (tokenizer.hasMoreTokens()) {
            this.id = Integer.parseInt(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            this.firstName = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            this.lastName = tokenizer.nextToken();
        }
        if (tokenizer.hasMoreTokens()) {
            this.emailAddress = tokenizer.nextToken();
        }

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
