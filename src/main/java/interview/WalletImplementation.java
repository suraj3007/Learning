package main.java.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WalletImplementation implements Wallet{

    private Long totalBalance;
    List<Long> coinsInWallet;

    WalletImplementation() {
        totalBalance = 0L;
        coinsInWallet = new ArrayList<>();
    }

    @Override
    public void load(String filename) {
        String[] values = filename.split(",");
        for (String coin : values) {
            long value = Long.parseLong(coin);
            coinsInWallet.add(value);
            totalBalance += value;
        }
    }

    @Override
    public Long getBalance() {
        return totalBalance;
    }

    @Override
    public Collection<Long> peek() {
        return coinsInWallet;
    }

    @Override
    public Long spend(Long amount) {
        //1,100,200,200,1000,1
        //If spend amount is greater than totalBalance
        if (amount > totalBalance) {
            return 0L;
        }

        totalBalance -= amount;
        Long coinValue = 0L;
        List<Long> coinSpend = new ArrayList<>();
        for(int i = 0; i < coinsInWallet.size(); i++) {
            coinValue = coinsInWallet.get(i);
            coinSpend.add(coinValue);
            if(amount > coinValue) {
                 amount -= coinValue;
            } else {
                long remainingAmount = coinValue - amount;
                removeCoins(coinSpend);
                coinsInWallet.add(remainingAmount);
                return remainingAmount;
            }
        }

        return 0L;
    }

    private void removeCoins(List<Long> coinSpend) {
        for (Long coin : coinSpend) {
            coinsInWallet.remove(coin);
        }
    }
}
