import java.util.*;
import java.io.*;

/*
 * Task: Implement a stack supporting the operations Push(), Pop(), and Max()
 * Input: The first line of input contains the number q of queries. Each of the following q lines
 * specifies a query of one of the following formats: push v, pop, or max.
 * Constraints: 1 <= q <= 400000, 0 <= v <= 10^5
 * Output: For each max query, output (on a separate line) the maximum value of the stack
 */
public class StackWithMax {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner(); 
        int queries = scanner.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> queue = new ArrayList<Integer>();
        //LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                int tm = stack.pop();
                if (queue.get(queue.size() - 1) == tm) {
                	// Every time we pop one element from stack, also remove last maximum from queue
                	queue.remove(queue.size()-1); 
                }	
                
            } else if ("max".equals(operation)) {
            	if (queue.isEmpty()) { // If "max" has never been called
            		int max = Collections.max(stack); // Find the maximum in stack
            		System.out.println(max);
            		queue.add(max);
            	} else {
            		int lastMax = 0;
            		if (queue.size() >= 2)
            			lastMax = queue.get(queue.size() - 2);
            		else if (queue.size() < 2)
            			lastMax = stack.lastElement();
            		int max = Math.max(queue.get(queue.size()-1), lastMax);
            		queue.remove(queue.size()-1); // Remove previous maximum
            		queue.add(max); // Add new maximum
            		System.out.println(max);
            	}
                
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}