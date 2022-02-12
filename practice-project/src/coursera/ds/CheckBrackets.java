import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

/*
 * Input: string S which consists of big and small latin letters, digits, punctuation 
 * marks and brackets from the set {}[]()
 * Output: If the code in S uses brackets correctly, output "Success." Otherwise, output
 * the 1-based index of the first unmatched closing bracket, and if there are no unmatched
 * closing brackets, output the 1-based index of the first unmatched opening bracket
 */
class CheckBrackets {
	public static boolean isMatched(char next, char top) {
		if (top == '[' && next == ']')
			return true;
		if (top == '{' && next == '}')
			return true;
		if (top == '(' && next == ')')
			return true;
		return false;
	}

	public static String isBalanced(String text) {
		Stack<Character> obs = new Stack<Character>(); // Stack to store opening brackets
		Stack<Integer> idx = new Stack<Integer>(); // Stack to store indices of opening brackets

		for (int position = 0; position < text.length(); position++) { // For each char in string
			char next = text.charAt(position);
			if (next == '(' || next == '[' || next == '{') { // If char is one of opening brackets
				obs.push(next); // Put on top of stack
				idx.push(position);
			} else { // If char is not opening bracket
				if (next == ')' || next == ']' || next == '}') { // If char is closing bracket
					if (obs.empty()) {// and there's no opening bracket
						int ind = (position + 1);
						return Integer.toString(ind); // Return 1-based index of char
					}
					char top = obs.pop(); // Get item on top of stack
					int id = idx.pop();
					if (!isMatched(next, top)) { // If brackets don't match
						int ind = (position + 1);
						return Integer.toString(ind); // Return 1-based index of char
					}
				}
			}
		}

		if (!idx.empty()) {
			int f = idx.firstElement();
			return Integer.toString(f + 1);
		}
		return "Success";
	}

	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();

		System.out.println(isBalanced(text));
		// Good job! (Max time used: 0.10/1.50, max memory used: 31670272/2147483648.)
	}
}