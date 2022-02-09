package main.java.com.parkingLot.account;

import main.java.com.parkingLot.Person;
import main.java.com.parkingLot.enums.AccountStatus;

public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

//    public boolean resetPassword();
}
