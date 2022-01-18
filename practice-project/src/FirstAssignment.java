import java.util.*;

public class FirstAssignment {

	public boolean isBalanced(String str) {
		LinkedList<String> ll = new LinkedList<String>();
		String[] substrings = str.split("");

		for (String ch : substrings) {
			boolean a = ch.equals("(");
			boolean b = ch.equals("[");
			boolean c = ch.equals("{");

			if (a || b || c) {
				ll.push(ch);
			} else {
				if (ll.isEmpty())
					return false;
				String top = ll.pop();
				if ((top.equals("(") && ch != ")") || top.equals("[") && ch != "]" || top.equals("{") && ch != ("}")) {
					return false;
				}
			}
		}

		return ll.isEmpty();
	}

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		String[] substrings = "[]".split("");
		
		for (String ch : substrings) {
			System.out.println(ch);
			
			boolean a = ch.equals("(");
			boolean b = ch.equals("[");
			boolean c = ch.equals("{");
			
			if (a || b || c) {
				ll.push(ch);
				System.out.println("First element in stack is "+ll.getFirst());
			} else {
				if (ll.isEmpty())
					System.out.println("Stack is empty");
				String top = ll.pop();
				System.out.println(top.equals("[") && !ch.equals("]"));
				if ((top.equals("(") && ch != ")") || (top.equals("[") && ch != "]") || (top.equals("{") && ch != ("}"))) {
					System.out.println("no no");
				}
			}
		}
	}
}