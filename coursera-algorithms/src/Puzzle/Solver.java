package Puzzle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private SearchNode finalnode;
	private Board initialboard;
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
		this.initialboard=initial;
    }
    private class  SearchNode implements Comparable <SearchNode>{
    	private int moves;
    	private int priority;
    	private Board board;
    	private SearchNode previousNode;
    	public SearchNode(Board board)
    	{
    		this.board=board;
    		this.priority=0;
    		this.moves=0;
    		this.previousNode=null;
    	}
    	public int compareTo(SearchNode that){
    		if(that==null)
    			throw new NullPointerException("that point is null");
    		if(this.board.equals(that.board))
    			return 0;
    		if(this.priority<that.priority)
    			return -1;
    		else
    			return 1;
    	}
    }
private  class MyThread  implements  Runnable {
	   private MinPQ<SearchNode> minpq = new MinPQ<SearchNode>(new Comparator<SearchNode>() {  
		          public int compare(SearchNode o1, SearchNode o2) {  
		             if (o1.priority < o2.priority) return -1;  
		             else if (o1.priority == o2.priority) return 0;  
		              else return 1;  
		         }  
		       });  

	private Board initialboard;
	private boolean flag;
		public MyThread(Board initial) {
			this.initialboard=initial;
			// TODO Auto-generated constructor stub
		}
		public void run() {  
			SearchNode initialNode=new SearchNode(initialboard);
		    if(initialboard.isGoal())
		    	{
		    	this.flag=true;
		    	finalnode=initialNode;
		    		return;
		    	}
	    	Iterable<Board> neighbors=initialboard.neighbors();
	    	for(Board neigh:neighbors)
	    			 {
	    				SearchNode neighnode=new SearchNode(neigh);
	    				neighnode.moves=1;
	    				neighnode.priority=neigh.manhattan()+neighnode.moves;
	    				neighnode.previousNode=initialNode;
	    				minpq.insert(neighnode);
	    			 }
	    	while(!minpq.isEmpty())
	    	{
	    		SearchNode currentnode=minpq.delMin();
	    		System.out.println(currentnode.priority);
	    		Board currentboard=currentnode.board;  
	    		if(currentboard.isGoal())
	    			{
		    			this.flag=true;
		    			finalnode=currentnode;
		    			  break;
	    			}
	    		Iterable<Board> neighbors2=currentboard.neighbors();
	        	for(Board neigh:neighbors2)
	        		{
	        		 if(!currentnode.previousNode.board.equals(neigh))
	        			 {
		        			SearchNode neighnode=new SearchNode(neigh);
		     				neighnode.moves=currentnode.moves+1;
		     				neighnode.priority=neigh.manhattan()+neighnode.moves;
		     				neighnode.previousNode=currentnode;
		     				minpq.insert(neighnode);
	        			 }
	        		}
	    	}
		}  
	}   
    
    public boolean isSolvable()            // is the initial board solvable?
    {
    	Board twinb=initialboard.twin();
    	MyThread mythread = new MyThread(initialboard);  
		Thread thread = new Thread(mythread);  
		thread.start();
		MyThread mythread2 = new MyThread(twinb);  
		Thread thread2 = new Thread(mythread2);  
		thread2.start();
		while(thread.isAlive()&&thread2.isAlive()){
		}
		thread.stop();
		thread2.stop();
    	return(mythread.flag&!mythread2.flag);
    }
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    {
    	return finalnode.moves;
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
    	ArrayList<Board> result=new ArrayList<Board>();
    	while(finalnode!=null)
    	{
    		result.add(finalnode.board);
    		SearchNode node=finalnode.previousNode;
    		finalnode=node;
    	}
    	return result;
    }
    public static void main(String[] args) // solve a slider puzzle (given below)
    {
    	In in = new In("E:\\0000android»·¾³´î½¨\\eclipse-jee-indigo-win32\\eclipse\\11\\coursera-algorithms\\puzzle4x4-49.txt");
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
      // solve the puzzle
        Solver solver = new Solver(initial);
        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board.toString());
        	}
}
}
