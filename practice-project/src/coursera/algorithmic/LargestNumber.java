package coursera.algorithmic;

import java.util.*;

public class LargestNumber {
	
	private static String compare(String A, String B) {
		String AB = A.concat(B);
		int valAB = Integer.valueOf(AB);
		String BA = B.concat(A);
		int valBA = Integer.valueOf(BA);
		
		if (valBA > valAB) return B;
		return A;
	}

    private static String largestNumber(String[] a) {
    	String result = "";
    	List<String> list = Arrays.asList(a);
    	LinkedList<String> ll = new LinkedList<String>(list);

    	
    	while (!ll.isEmpty()) {
    		String best = "0";
    		
    		for(String str : ll) {
    			String tempBest = compare(str, best);
    			best = tempBest;	
    		}
    		
    		ll.remove(best);
			result = result.concat(best);
			best = "0";
    	}
  

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }
        
        System.out.println(largestNumber(a));
        
    }
}
