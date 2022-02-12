import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Request {
	public Request(int arrival_time, int process_time) {
		this.arrival_time = arrival_time;
		this.process_time = process_time;
	}

	public int arrival_time;
	public int process_time;
}

class Response {
	public Response(boolean dropped, int start_time) {
		this.dropped = dropped;
		this.start_time = start_time;
	}

	public boolean dropped;
	public int start_time;
}

class Buffer {

	public Buffer(int size) {
		this.size_ = size;
		this.finish_time_ = new ArrayList<Integer>();
		this.finish_time_.add(0);
	}

	public Response Process(Request request) {
		int i = 0;
		while (i < this.finish_time_.size()) {
			if (this.finish_time_.get(i) <= request.arrival_time) {
				this.finish_time_.remove(i);
			} else {
				break;
			}
		}
		if (this.finish_time_.size() < this.size_) {
			if (this.finish_time_.size() >= 1) {
				int bt = this.finish_time_.get(this.finish_time_.size() - 1);
				int ft = bt + request.process_time;
				this.finish_time_.add(ft);
				return new Response(false, bt);
			} else {
				int ft = request.arrival_time + request.process_time;
				this.finish_time_.add(ft);
				return new Response(false, request.arrival_time);
			}
		}
		return new Response(true, -1);
	}

	private int size_;
	private ArrayList<Integer> finish_time_;
}

class ProcessPackages {
	private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
		int requests_count = scanner.nextInt();
		ArrayList<Request> requests = new ArrayList<Request>();
		for (int i = 0; i < requests_count; ++i) {
			int arrival_time = scanner.nextInt();
			int process_time = scanner.nextInt();
			requests.add(new Request(arrival_time, process_time));
		}
		return requests;
	}

	private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
		ArrayList<Response> responses = new ArrayList<Response>();
		for (int i = 0; i < requests.size(); ++i) {
			responses.add(buffer.Process(requests.get(i)));
		}
		return responses;
	}

	private static void PrintResponses(ArrayList<Response> responses) {
		for (int i = 0; i < responses.size(); ++i) {
			Response response = responses.get(i);
			if (response.dropped) {
				System.out.println(-1);
			} else {
				System.out.println(response.start_time);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int buffer_max_size = scanner.nextInt();
		Buffer buffer = new Buffer(buffer_max_size);

		ArrayList<Request> requests = ReadQueries(scanner);
		ArrayList<Response> responses = ProcessRequests(requests, buffer);
		PrintResponses(responses);

//        Buffer bf = new Buffer(1);
//        Request rq = new Request(0, 1);
//        Response rs = bf.Process(rq);
//        System.out.println(rs.start_time + " Saved? " +rs.dropped);
	}
}