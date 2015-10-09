package RQD;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Subset {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = Integer.parseInt(args[0]);
		 
		RandomizedQueue q = new RandomizedQueue();
		 
		while(!StdIn.isEmpty()) {
		 
		q.enqueue(StdIn.readString());
		 
		}
		 
		for(int i=0; i<k; i++) {
		 
		StdOut.println(q.dequeue());
		 
		}
		 
		}

		

}
