import java.util.*;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        long startTime = System.nanoTime(); 

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            
            System.out.print("Pass " + i + ": ");
            printArray(arr);
        }

        long endTime = System.nanoTime(); 

        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Original array: ");
        printArray(arr);

        insertionSort(arr);

        System.out.print("Sorted array: ");
        printArray(arr);

        sc.close();
    }

}
/*output 
5
64 34 25 12 22
Original array: 64 34 25 12 22

Pass 1: 34 64 25 12 22  
Pass 2: 25 34 64 12 22  
Pass 3: 12 25 34 64 22  
Pass 4: 12 22 25 34 64  

Execution Time: 132400 nanoseconds

Sorted array: 12 22 25 34 64 */