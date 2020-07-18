package main.java.learning1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumber {

    private static boolean isPrime(double num){

        if(num <= 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        double num = 18;
        if(num == 2 || isPrime(num)){
            System.out.println(num + " is a prime number");
        }else{
            System.out.println(num + " is not a prime number");
        }

//        List<Integer> primes = new ArrayList<>();
//        IntStream.range(2, 100)
//                .filter(n -> primes.parallelStream().noneMatch(p -> n % p == 0))
//                .forEach(primes::add);
//        System.out.println(primes);
    }
}
