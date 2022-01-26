import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
    	int[] count = new int[points.length];
        
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int k = 0; k < points.length; k++) {
        	int c = 0;
        	int i = 0, j = 0; // Indices for segment starts and segment ends

        	while (i < starts.length && starts[i] <= points[k]) {
        		i++;
        		c++;
        	}
        	while (j < ends.length && ends[j] < points[k]) {
        		j++;
        		c--;
        	}
        	count[k] = c;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }

        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}