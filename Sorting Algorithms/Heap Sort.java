/*
 * 
 * Description:
 * Heap Sort is a powerful comparison-based sorting algorithm built on the concept 
 * of a Binary Heap (specifically, a Max Heap). 
 * It organizes the array into a heap structure, then repeatedly extracts the largest 
 * element and places it at the end of the array until everything is sorted.
 * 
 * Unlike simple algorithms like Bubble or Selection Sort, Heap Sort balances 
 * performance with a clear structure that helps understand how tree-based data 
 * organization can be used for sorting.
 * 
 * Use Cases:
 * - Ideal when a consistent O(n log n) time complexity is required.
 * - Useful for sorting large datasets in memory.
 * - Common in priority queue implementations and scheduling systems.
 * 
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n log n)
 * 
 * Space Complexity:
 * - O(1) → in-place sorting (no additional memory used)
 * 
 * Approach:
 * 1. Convert the array into a Max Heap (largest element at the root).
 * 2. Swap the root (largest) element with the last element in the heap.
 * 3. Reduce the heap size by one and restore the heap property.
 * 4. Repeat the process until the heap size is 1.
 */

public class HeapSort {

    // Function to perform Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        //  1: Build the Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        //  2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Restore the heap property on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Helper function to maintain the heap property
    private static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;     // Initialize largest as root
        int left = 2 * rootIndex + 1; // left child index
        int right = 2 * rootIndex + 2; // right child index

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than the current largest
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the root
        if (largest != rootIndex) {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, heapSize, largest);
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        int[] numbers = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Before sorting:");
        printArray(numbers);

        heapSort(numbers);

        System.out.println("After sorting:");
        printArray(numbers);
    }
}
