package unionfind;


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private boolean [][]grid;
	private int size;
    private  WeightedQuickUnionUF un;
    private  WeightedQuickUnionUF un2;
	   public Percolation(int N)               // create N-by-N grid, with all sites blocked
	   {
		   if(N<=0)
			   throw new  IllegalArgumentException("N is ellegal");
		   this.size=N;
		   this.grid=new boolean[N+1][N+1];
		   un=new WeightedQuickUnionUF(size*size);
		   un2=new WeightedQuickUnionUF(size*size);
		   if(N>1){
			   for(int i=0;i<N-1;i++)
			   {
				   un.union(i, i+1);
			   }
			   for(int i=N*N-N;i<N*N-1;i++)
			   {
				   un.union(i, i+1);
			   }
			
			   for(int i=0;i<N-1;i++)
			   {
				   un2.union(i, i+1);
			   } 
		   }
		    
		   
	   }
	   public void open(int i, int j)          // open site (row i, column j) if it is not open already
	   {
		   if (i <= 0 || i > size||j <= 0 || j > size)
			   throw new IndexOutOfBoundsException("row index i out of bounds");
		 if(isOpen(i,j))
			 return;
		 grid[i][j]=true;
	    
	    
	    
		   if(i>1&&isOpen(i-1,j))
		   { 
			   un.union((i-1)*size+j-1, (i-1-1)*size+j-1);
			   un2.union((i-1)*size+j-1, (i-1-1)*size+j-1);
		   }    
		   if(i<size&&isOpen(i+1,j))
		   {
			   un.union((i-1)*size+j-1, i*size+j-1);
			   un2.union((i-1)*size+j-1, i*size+j-1);
		   }
		   if(j>1&&isOpen(i,j-1))
		   {
			   un.union((i-1)*size+j-1, (i-1)*size+j-2);
			   un2.union((i-1)*size+j-1, (i-1)*size+j-2);
		   }
		   if(j<size&&isOpen(i,j+1))
		   {
			   un.union((i-1)*size+j-1, (i-1)*size+j);
			   un2.union((i-1)*size+j-1, (i-1)*size+j);
		   }
		   
		   
	   }
	   
	   public boolean isOpen(int i, int j)     // is site (row i, column j) open?
	   {
		   if (i <= 0 || i > size||j <= 0 || j > size)
			   throw new IndexOutOfBoundsException("row index i out of bounds");
		   boolean cc= grid[i][j]==true?true:false;
		   return cc;
	   }
	   
	   public boolean isFull(int i, int j)     // is site (row i, column j) full?
	   {
		   if (i <= 0 || i > size||j <= 0 || j > size)
			   throw new IndexOutOfBoundsException("row index i out of bounds");
		   if(size==1)
			   return isOpen(i,j);
		   if(!isOpen(i,j))
			   return false;
		  
		    	if(un2.connected(0, size*(i-1)+j-1))
		    		return true;
		   return false;
	   }
	   
	   public boolean percolates()            // does the system percolate?
	   {
//			 HashMap<Integer,Integer> bottom=new HashMap<Integer,Integer>(); 
//		 for(int k=1;k<size+1;k++)
//		   { 
//			int c=un.find(size*(size-1)+k-1);
//			if(!bottom.containsKey(c))
//				bottom.put(c,1);
//				
//			} 
//		 for(int k=1;k<size+1;k++)
//		 {
//			 int c=un.find(k-1);
//			 if(bottom.containsKey(c))
//				 return true;
//		 }
		   if(size==1)
			   return(isFull(1,1));
		   if(un.connected(0,size*size-1))
			return true;
		  return false;
	   }

	   public static void main(String[] args)  // test client (optional)
	   {
		  
	   }
	}