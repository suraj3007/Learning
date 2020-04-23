package main.java.com.pluralsight.adapter;

//Not implementing the Employee interface
public class EmployeeLdap {
    private String cn;
    private String surName;
    private String givenName;
    private String mail;

    public EmployeeLdap(String cn, String surName, String givenName, String mail) {
        this.cn = cn;
        this.surName = surName;
        this.givenName = givenName;
        this.mail = mail;
    }

    public String getCn() {
        return cn;
    }

    public String getSurName() {
        return surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMail() {
        return mail;
    }

}
