import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        
        HashMap<Integer, Integer> c = new HashMap<Integer, Integer>();
        for (int num : a) {
        	if(c.containsKey(num)) {
        		int oldVal = c.get(num);
        		c.put(num, oldVal+1);
        	} else {
        		c.put(num, 1);
        	}
        }
        
        double n = (double)left + ((double)right - (double)left)/2;
        for (Map.Entry<Integer, Integer> set : c.entrySet()) {
        	if (set.getValue() > (int)n) 
        		return 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
