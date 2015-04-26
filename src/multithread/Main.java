package multithread;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		String address = "http://cs.lth.se/eda095";
		String address2 = "http://cs.lth.se/pierre_nugues/";

		Spider spider = new Spider(address);

		ArrayList<Thread> nbrOfThreads = new ArrayList<Thread>();
		System.out.print("Starting scan:");

		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Processor(spider));
			t.start();
			nbrOfThreads.add(t);
		}

		for (Thread t : nbrOfThreads) {
			try {
				t.join();
				
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		spider.result();

	}

}
