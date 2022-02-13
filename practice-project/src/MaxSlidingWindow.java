import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Given a sequence of n integers and an integer m <= n, find the maximum among
 * {ai, ..., a(i+m-1)} for every 1 <= i <= n - m + 1.
 * Goal is to design an O(n) algorithm.
 */
public class MaxSlidingWindow {
	
	public static LinkedList<Integer> findMax(int m, int[] arr) {
		LinkedList<Integer> max = new LinkedList<Integer>();
		LinkedList<Integer> ans = new LinkedList<Integer>();
		
		for (int i = 0; i < m; ++i) {
			if (i == 0 || max.size() == 0) {
				max.add(i);
			} else {
				while (max.size() > 0 && arr[max.get(max.size() - 1)] < arr[i]) {
					max.removeFirst();
				}
				max.add(i);
			}
		}
		ans.addFirst(arr[max.get(0)]); 
		System.out.println("Ans: "+ans.toString());

		for (int i = m; i < arr.length; ++i) {
			System.out.println("Max: "+max.toString());
			System.out.println("i = "+i);
			if (max.get(max.size() - 1) == i - m) {
				max.removeFirst();
			}
			if (max.size() == 0) {
				max.add(i);
			}
			else {
				while (max.size() > 0 && arr[max.get(max.size() - 1)] < arr[i]) {
					max.removeFirst();
				}
				max.add(i);
			}
			ans.add(arr[max.get(0)]);
			System.out.println("Ans: "+ans.toString());
		}

		return ans;
	}
	
	public static void main(String[] agrs) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int a = in.nextInt();
			arr[i] = a;
		}
		int m = in.nextInt();
//		System.out.println("n "+n+" m "+m);
//		System.out.println(al.toString());
		
		LinkedList<Integer> ans = findMax(m, arr);
		System.out.println(ans.toString());
	}

}
