import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {
    	Arrays.sort(segments, (o1, o2) -> Integer.compare(o1.end, o2.end));
    	
    	int point = -5;
    	List<Integer> points = new ArrayList<>();
        for (Segment seg : segments) {
        	if (!seg.touchesSegment(point)) {
        		point = seg.end;
        		points.add(point);
        	}
        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        boolean touchesSegment(int point) {
        	return point >= start && point <= end;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}