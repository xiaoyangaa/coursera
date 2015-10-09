package finalPuzzle;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Board {
	private int dimension;
	private int[][]block;
	private int indexi;
	private int indexj;
    public Board(int[][] blocks)           // construct a board from an N-by-N array of blocks
                                           // (where blocks[i][j] = block in row i, column j)
    {
    	this.dimension=blocks.length;
    	this.block=new int[dimension][dimension];
    	for(int i=0;i<dimension;i++)
    	{
    		for(int j=0;j<dimension;j++)
			{
    			block[i][j]=blocks[i][j];
			}
    	}
    }
    public int dimension()                 // board dimension N
    {
    	return dimension;
    }
    public int hamming()                   // number of blocks out of place
    {
    	int hamm=0;
    	for(int i=0;i<dimension;i++)
    	{
    		for(int j=0;j<dimension;j++)
			{
	    			if(block[i][j]==0)
				{
					this.indexi=i;
					this.indexj=j;
					continue;
				}
				if(block[i][j]!=(i*dimension+j)+1)
					{
					hamm++;
					}
			}
    	}
    		
    	return hamm;
    				
    }
    public int manhattan()                 // sum of Manhattan distances between blocks and goal
    {
    	int manha=0;
    	for(int i=0;i<dimension;i++)
    	{
    		for(int j=0;j<dimension;j++)
			{
    			if(block[i][j]==0)
    			{
    				this.indexi=i;
					this.indexj=j;
    				continue;
    			}
    			if(block[i][j]-(i*dimension+j)!=1)
    				{
    				manha+=Math.abs((block[i][j]-1)/dimension-i)+Math.abs((block[i][j]-1)%dimension-j);
    				}
			}
			
    	}
    	return manha;
    }
    public boolean isGoal()                // is this board the goal board?
    {
    	return (this.hamming()==0)?true:false;
    }
    public Board twin()                    // a board that is obtained by exchanging any pair of blocks
    {
    	
    	int[][] neighblock=new int[dimension][dimension];
		for(int i=0;i<dimension;i++)
			for(int j=0;j<dimension;j++)
				neighblock[i][j]=this.block[i][j];
    	if(neighblock[0][0]!=0&&neighblock[0][1]!=0)
    	{
    		int temp=neighblock[0][0];
    		neighblock[0][0]=neighblock[0][1];
    		neighblock[0][1]=temp;
    	}
    	else
    	{
    		int temp=neighblock[1][0];
    		neighblock[1][0]=neighblock[1][1];
    		neighblock[1][1]=temp;
    	}
    	Board twinboard=new Board(neighblock);
    	twinboard.indexi=this.indexi;
    	twinboard.indexj=this.indexj;
    	return twinboard;
  }
    public boolean equals(Object y)        // does this board equal y?
    {
    	if(y==null)
    		return false;
    	if(this==y)
    		return true;
    	if(y.getClass()!=this.getClass())
    		return false;
    	
    	Board yy=(Board) y;
    	if(yy.dimension!=this.dimension)
    		return false;
    	for(int i=0;i<dimension;i++)
    		for(int j=0;j<dimension;j++)
    	{
    		if(this.block[i][j]!=yy.block[i][j])
    			return false;
    	}
    	return true;
    }
    public Iterable<Board> neighbors()     // all neighboring boards
    {
    	for(int i=0;i<dimension;i++)
    	{
    		for(int j=0;j<dimension;j++)
			{
    			if(block[i][j]==0)
    			{
    				this.indexi=i;
					this.indexj=j;
    				break;
    			}
			}
    	}
    	List<Board> neighbors=new ArrayList<Board>();
    	if(this.indexi>0)
    	{
    		int[][] neighblock1=new int[dimension][dimension];
    		for(int i=0;i<dimension;i++)
    			for(int j=0;j<dimension;j++)
    				neighblock1[i][j]=this.block[i][j];
    		neighblock1[indexi][indexj]=neighblock1[indexi-1][indexj];
    		neighblock1[indexi-1][indexj]=0;
    		Board neigh1=new Board(neighblock1);
//    		neigh.previousNode=this;
    		neighbors.add(neigh1);
    		
    	}	
    	if(this.indexj>0)
    	{
    		int[][] neighblock=new int[dimension][dimension];
    		for(int i=0;i<dimension;i++)
    			for(int j=0;j<dimension;j++)
    				neighblock[i][j]=this.block[i][j];
    		neighblock[indexi][indexj]=neighblock[indexi][indexj-1];
    		neighblock[indexi][indexj-1]=0;
    		Board neigh=new Board(neighblock);
//    		neigh.previousNode=this;
    		neighbors.add(neigh);
    	}
    	if(this.indexi<dimension-1)
    	{
    		int[][] neighblock=new int[dimension][dimension];
    		for(int i=0;i<dimension;i++)
    			for(int j=0;j<dimension;j++)
    				neighblock[i][j]=this.block[i][j];
    		neighblock[indexi][indexj]=neighblock[indexi+1][indexj];
    		neighblock[indexi+1][indexj]=0;
    		Board neigh=new Board(neighblock);
//    		neigh.previousNode=this;
    		neighbors.add(neigh);
    	}
    	if(this.indexj<dimension-1)
    	{
    		int[][] neighblock=new int[dimension][dimension];
    		for(int i=0;i<dimension;i++)
    			for(int j=0;j<dimension;j++)
    				neighblock[i][j]=this.block[i][j];
    		neighblock[indexi][indexj]=neighblock[indexi][indexj+1];
    		neighblock[indexi][indexj+1]=0;
    		Board neigh=new Board(neighblock);
//    		neigh.previousNode=this;
    		neighbors.add(neigh);
    	}
    	return neighbors;
    }
    public String toString()               // string representation of this board (in the output format specified below)
    {
    	String cc=dimension+"\r";
  
    	for(int i=0;i<dimension;i++)
    		{
    			for(int j=0;j<dimension;j++)
    				cc=cc+this.block[i][j]+" ";
    			cc+="\r";
    		}
    	return cc;
    }
    public static void main(String[] args) // unit tests (not graded)
    {
    	In in = new In("E:\\0000android»·¾³´î½¨\\eclipse-jee-indigo-win32\\eclipse\\11\\coursera-algorithms\\puzzle00.txt");
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);
        StdOut.println(initial.toString());
        Iterable<Board> neighbors2=initial.neighbors();
        for (Board board : neighbors2)
            StdOut.println(board.toString());
    	
    }
}