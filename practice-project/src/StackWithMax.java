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
        LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
                if (queue.size() >= 1)
                	queue.remove(queue.size() - 1);
            } else if ("max".equals(operation)) {
            	if (queue.isEmpty()) {
            		int max = Collections.max(stack);
            		System.out.println(max);
            		queue.add(max);
            	} else {
            		int max = Math.max(queue.get(queue.size() - 1), stack.lastElement());
            		queue.add(max);
            		System.out.println(max);
            	}
                
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}