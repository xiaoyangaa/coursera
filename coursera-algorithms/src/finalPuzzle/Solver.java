package finalPuzzle;

import java.util.ArrayList;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
  
	private Board initialboard;
    private MinPQ<SearchNode> minpq = new MinPQ<SearchNode>();
    private SearchNode finalnode;
    public Solver(Board initial)           // find a solution to the initial board (using the A* algorithm)
    {
		this.initialboard=initial;
		SearchNode initialnode=new SearchNode(initialboard,0,null,false);
		Board twinboard=initialboard.twin();
		SearchNode twinode=new SearchNode(twinboard,0,null,true);
		minpq.insert(initialnode);
		minpq.insert(twinode);
		
		while(!minpq.isEmpty())
		{
			SearchNode currentnode=minpq.delMin();
			if(currentnode.board.isGoal())
			{
				this.finalnode=currentnode;
					break;
			}
			else
			{
				if(currentnode.istwin)
				{	
					Board currentboard=currentnode.board;
					Iterable<Board> neighbors=currentboard.neighbors();
					for(Board neigh:neighbors)
					 if(currentnode.previousNode==null)
					 {
						 SearchNode neighnode=new SearchNode(neigh,currentnode.moves+1,currentnode,true);
						 minpq.insert(neighnode);
					 }
					 else if(!currentnode.previousNode.board.equals(neigh))
					 {
						 SearchNode neighnode=new SearchNode(neigh,currentnode.moves+1,currentnode,true);
						 minpq.insert(neighnode);
					 }
				}
				else
				{
					Board currentboard=currentnode.board;
					Iterable<Board> neighbors=currentboard.neighbors();
					for(Board neigh:neighbors)
					 if(currentnode.previousNode==null)
					 {
						 SearchNode neighnode=new SearchNode(neigh,currentnode.moves+1,currentnode,false);
						minpq.insert(neighnode);
					 }
					 else if(!currentnode.previousNode.board.equals(neigh))
					 {
						 SearchNode neighnode=new SearchNode(neigh,currentnode.moves+1,currentnode,false);
						 minpq.insert(neighnode);
					 }
				}
			}
				
		}
    }

    private class  SearchNode implements Comparable <SearchNode>{
    	private int moves;
    	private int priority;
    	private Board board;
    	private SearchNode previousNode;
    	private boolean istwin;
    	public SearchNode(Board board,int moves,SearchNode previousNode,boolean istwin)
    	{
    		this.board=board;
    		this.moves=moves;
    		this.priority=moves+board.manhattan();
    		this.previousNode=previousNode;
    		this.istwin=istwin;
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
    public boolean isSolvable()            // is the initial board solvable?
    {
    	if(this.finalnode.istwin)
    		return false;
    	else
    		return true;
    }
    public int moves()                     // min number of moves to solve initial board; -1 if unsolvable
    {
    	if(!this.isSolvable())
    	{
    		return -1;
    	}
    	return finalnode.moves;
    }
    public Iterable<Board> solution()      // sequence of boards in a shortest solution; null if unsolvable
    {
    	if(!this.isSolvable())
    	{
    		return null;
    	}
    	 Stack<Board> result= new Stack<Board>(); 
    	SearchNode cc=new SearchNode(finalnode.board,finalnode.moves,finalnode.previousNode,finalnode.istwin);
    	while(cc!=null)
    	{
    		result.push(cc.board);
    		SearchNode node=cc.previousNode;
    		cc=node;
    	}
    	return result;
    }
    public static void main(String[] args) // solve a slider puzzle (given below)
    {
    	In in = new In("E:\\0000android»·¾³´î½¨\\eclipse-jee-indigo-win32\\eclipse\\11\\coursera-algorithms\\puzzle07.txt");
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
