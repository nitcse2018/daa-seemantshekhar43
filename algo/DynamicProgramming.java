

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Dynamic Programming is a technique used often with recursion. Basically it is an advanced form of recursion
 * in which we store the result for each call of recursion. Stored result is further utilised.
 * I am using this algorithm to find first n prime nos.
 */
public class DynamicProgramming {


    /**
     * Find Prime
     * @param n no of primes
     * @return list of primes
     *
     * This method stores the prime found in each step and then to find the next prime it utilises the same.
     * A no is prime if it is not divisible by prime numbers equal to less than square root of that number.
     */
    private static List<Integer> findPrime(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        int i = 3;
        while(list.size() < n){
            boolean flag = true;
            for(int j = 0; list.get(j) <= Math.sqrt(i);j++){
                if(i % list.get(j) == 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                list.add(i);
            i++;

        }
        return list;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of Prime nos you need

       List<Integer> PrimeList = findPrime(n);
       for(Integer i: PrimeList){
           System.out.print(i+ " ");
       }

    }


}
