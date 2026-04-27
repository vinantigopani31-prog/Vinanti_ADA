import java.util.*;

public class MergeSort{

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        // Print after each merge (acts like pass)
        System.out.print("Merge [" + left + "," + right + "]: ");
        printArray(arr);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.print("Original array: ");
        printArray(arr);

        long startTime = System.nanoTime(); // Start time

        mergeSort(arr, 0, n - 1);

        long endTime = System.nanoTime(); // End time

        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");

        System.out.print("Sorted array: ");
        printArray(arr);

        sc.close();
    }
}
/* output 
  5
  64 34 25 12 22
  Original array: 64 34 25 12 22

Merge [0,1]: 34 64 25 12 22  
Merge [0,2]: 25 34 64 12 22  
Merge [3,4]: 25 34 64 12 22  
Merge [0,4]: 12 22 25 34 64  

Execution Time: 120500 nanoseconds

Sorted array: 12 22 25 34 64*/