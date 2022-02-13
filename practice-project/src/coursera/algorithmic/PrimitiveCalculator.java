package coursera.algorithmic;

import java.util.*;

public class PrimitiveCalculator {
	
	public static int min(int a, int b, int c) {
		if (a <= b && a <= c) return a;
		if (b <= a && b <= c) return b;
		else return c;
	}
	
	
	public static int minOperations(int n) {
		if (n == 1) return 0;
		if (n == 2 || n == 3) return 1;
		
		int result = 0;
		if (n % 3 == 0 && n % 2 == 0) 
			result = min(minOperations(n/3) + 1, minOperations(n/2) + 1, minOperations(n - 1) + 1);
		else if (n % 3 == 0)
			result = Math.min(minOperations(n/3) + 1, minOperations(n/2) + 1);
		else if (n % 2 == 0)
			result = Math.min(minOperations(n/2) + 1, minOperations(n - 1) + 1);
		else 
			result = minOperations(n - 1) + 1;
		

		return result;
	}
	
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        List<Integer> sequence = optimal_sequence(n);
//        System.out.println(sequence.size() - 1);
//        for (Integer x : sequence) {
//            System.out.print(x + " ");
//        }
    	System.out.println(minOperations(1));
    	System.out.println(minOperations(5));
    	System.out.println(minOperations(96234));
    }
}
