


import java.util.Arrays;
import java.util.Scanner;

/**
 * Greedy Method is an approach in which we only care about our immediate goal. It is used in several cases in which
 * we have to achieve immediate goal to move forward,
 * I am using this algorithm to show bubble sort.
 */
public class GreedyMethod {

    /**
     * Bubble Sort
     * @param arr sorted array
     *
     *    This method just compares the 2 element at a time and sort them. This process continue until time comes
     *    when there is no swapping done in the whole array.
     */

    private static void bubbleSort(int[] arr) {
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    arr[i] = arr[i] + arr[i+1];
                    arr[i+1] = arr[i] - arr[i+1];
                    arr[i] = arr[i]- arr[i+1];
                    flag = true;
                }
            }
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Total no of elements
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = (int) (Math.random()*100);
        }
        System.out.println(" Unsorted array of "+n+" elements is: ");
        for(int i = 0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
        bubbleSort(arr);
        System.out.println(" Sorted array: ");
        for(int i = 0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }


}
