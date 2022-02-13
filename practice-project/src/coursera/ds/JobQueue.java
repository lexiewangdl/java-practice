package coursera.ds;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
	
	public class Worker implements Comparable<Worker> {
		public int id;
		public long finishTime;
		
		public Worker(int a) {
			id = a;
			finishTime = 0;
		}
		
		public void setId(int a) {
			this.id = a;
		}

		public void setFinish(long job) {
			this.finishTime += (long)job;
		}

		@Override
		public int compareTo(Worker otherWorker) {
			if (this.finishTime == otherWorker.finishTime)
				return Integer.compare(id, otherWorker.id);
				// returns 0 if x == y, negative if x < y, positive if x > y
			else
				return Long.compare(finishTime, otherWorker.finishTime);
		}
	}
	
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }
    
    private void assignJobs() {
    	assignedWorker = new int[jobs.length];
    	startTime = new long[jobs.length];
    	PriorityQueue<Worker> workers = new PriorityQueue<Worker>(Comparator.naturalOrder());

    	for (int i = 0; i < numWorkers; i++) {
    		Worker wo = new Worker(i);
    		workers.add(wo);
    	}
    	
    	int j = 0;
    	for (int job : jobs) {
    		Worker w = workers.remove();
    		assignedWorker[j] = w.id;
    		startTime[j] = w.finishTime;
    		j++;
    		
    		w.setFinish(job);
    		workers.add(w);
    	}
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

// https://www.baeldung.com/java-comparator-comparable
// https://stackoverflow.com/questions/2555284/java-priority-queue-with-a-custom-anonymous-comparator
// https://www.w3schools.com/java/java_constructors.asp
// https://www.geeksforgeeks.org/priority-queue-class-in-java/

