package main.java.interview;

public class TestWallet {

    public static void main(String[] args) {
        WalletImplementation wallet = new WalletImplementation();
        wallet.load("1,100,200,200,1000,1");
        System.out.println(wallet.getBalance());
        System.out.println(wallet.peek());
        System.out.println("****** After spending **********");
        System.out.println(wallet.spend(1080L));
        System.out.println(wallet.peek());
        System.out.println(wallet.getBalance());
    }
}
