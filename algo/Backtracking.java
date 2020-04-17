

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Backtracking algorithm is used when we have different paths leading to our solution and we have to consider
 * all of them.
 * I am using this algorithm to solve n-valid parentheses pair problem.
 */
public class Backtracking {



    public  static void backtrack(List<String> list, int n, int open, int close, String current){
        if(current.length() == n*2){
            list.add(current);
            return;
        }
        if(open < n) backtrack(list, n, open+1, close, current + "(");
        if(close < open) backtrack(list , n, open, close + 1, current + ")");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // total pairs of parentheses
        List<String> list = new ArrayList<>();
        backtrack(list,n, 0, 0, "" );

        for(String s: list)
            System.out.println(s);
    }
}
