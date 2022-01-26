import java.util.*;

public class Inversions {

	/*
	 * 5 Number of Inversions Task: The goal is to count the number of inversions of
	 * a given sequence.
	 */
	public static long merge(int[] arr, int left, int mid, int right) {
		
		int[] leftArr = Arrays.copyOfRange(arr, left, mid);
		int[] rightArr = Arrays.copyOfRange(arr, mid, right);
//		System.out.println("n1: "+ (mid - left + 1));
//		System.out.println("Left Length:" + leftArr.length);
//		System.out.println(Arrays.toString(leftArr));
//		System.out.println("n2: "+(right - mid));
//		System.out.println("Right Length:" +rightArr.length);
//		System.out.println(Arrays.toString(rightArr));
		
		int i = 0, j = 0; // Initial indices of left and right array
		long swaps = 0; // Keep track of number of inversions
		int k = left; // Initial index of merged 
		
		while (i < leftArr.length && j < rightArr.length) {
			
			if (leftArr[i] <= rightArr[j]) { // If left item is smaller than right item
				arr[k] = leftArr[i]; // Put left item in merged array
				i++; // Update index of left subarray
			} 
			else { // If right item is smaller than left item
				arr[k] = rightArr[j]; // Put right item in merged array
				j++; // Update index of right subarray
				
				swaps += ((long)mid + 1l) - ((long)left + (long)i); // If leftArr[i] > rightArr[j], then
												 // there are (mid - i) inversions
			}
			k++; // Update index of merged array
		}
		
		while (i < leftArr.length) {
			arr[k] = leftArr[i];
			i++; 
			k++;
		}
		while (j < rightArr.length) {
			arr[k] = rightArr[j];
			j++; 
			k++;
		}
				
		return swaps;
	}

	public static long mergeSort(int[] arr, int left, int right) {
		long inv = 0;
		
		if (right <= left + 1) {
			return inv;
		}
		
		// Find the middle point, divide array into two parts
		int mid = (left + right) / 2;
			
		// Sort the first half
		inv += mergeSort(arr, left, mid);
		// Sort the second half
		inv += mergeSort(arr, mid + 1, right);
		
		// Merge the two parts
		inv += merge(arr, left, mid, right);

		return inv;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int[] b = new int[n];
		System.out.println(mergeSort(a, 0, a.length));
//		int[] lkx = new int[] {9, 8, 7, 3, 2, 1};
//		int mid = (0 + lkx.length) / 2;
//		long c = merge(lkx, 0, mid, lkx.length);
//		System.out.println(Arrays.toString(lkx));

	}
}

// https://www.geeksforgeeks.org/merge-sort/
// https://www.geeksforgeeks.org/counting-inversions/