package main.java.interview;

import java.util.Collection;

public interface Wallet {

    void load(String filename); //loads coin into wallet - 1,100,200,200,1000,1

    Long getBalance();  //Returns the amount present in wallet

    Collection<Long> peek();    //Coins which exist in wallet

    Long spend(Long amount);
}

