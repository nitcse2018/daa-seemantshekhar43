

import java.util.Arrays;
import java.util.Scanner;

/**
 * Divide and Conquer technique is used in many algorithms like Quick sort, Merge sort and Binary Search.
 * I am using this technique in Binary Search
 */
public class DivideAndConquer {

    /**
     * Binary Search
     * @param l left index
     * @param r right index
     * @param arr sorted array
     * @param q query no.
     * @return index
     *
     * This function is using divide and conquer technique. It compares the query no. with middle element of
     * the array and based on the result it divides the array into smaller left half or right half and continues the same
     * process till it finds the query no. or l>r that is element does not exist.
     */
    public static int binarySearch(int l, int r, int[] arr, int q){
        int index = -1;
        if(l > r){
            return -1;
        }

        int m = (l+r)/2;
        if(arr[m]==q){
            return m;
        }

        if(q > arr[m])
            index= binarySearch(m+1, r, arr, q);
        else{
            index= binarySearch(l, m-1, arr, q);
        }
        return index;
    }
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Total no of elements
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = (int) (Math.random()*100);
        }
        Arrays.sort(arr);
        System.out.println(" Array of "+n+" elements is: ");
        for(int i = 0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("Enter a number to search in the array.");
        int q = scanner.nextInt();
        int index = binarySearch(0, n-1, arr, q);
        if(index == -1){
            System.out.println("Does not Exist!!");
        }else {
            System.out.println(q+ " exists at index: "+ index);
        }

    }
}
