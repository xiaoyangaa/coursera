package week5;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.RedBlackBST;
import finalPuzzle.Solver.SearchNode;

public class twodtree {
       private class tree implements  Comparable <tree>{
    	   private Point2D p;
    	   private int level;
    	   public tree(Point2D p,int level)
    	   {
    		   this.p=p;
    		   this.level=level;
    	   }
    	   public int getlevel(){
    		   return this.level;
    	   }
    	   public void setlevel(int level){
    		  this.level= level;
    	   }
    	   public int compareTo(tree that)
    	   {
    		   if(that.level%2!=0)
    		   {
    			   if(this.p.x()<that.p.x())
    				   return -1;
    			   if(this.p.x()==that.p.x())
    				   return 0;
    			   else
    				   return 1;
    		   }
    		   else
    		   {
    			   if(this.p.y()<that.p.y())
    				   return -1;
    			   if(this.p.y()==that.p.y())
    				   return 0;
    			   else
    				   return 1;
    		   }
    	   }
       }
       private static Node root;
       private static class Node {
    	   private Point2D p;      // the point
    	   private RectHV rect;    // the axis-aligned rectangle corresponding to this node
    	   private Node lb;        // the left/bottom subtree
    	   private Node rt;        // the right/top subtree
    	   private int N;
    	   
    	   public boolean isEmpty() {
    	        return size() == 0;
    	    }

    	    /**
    	     * Returns the number of key-value pairs in this symbol table.
    	     * @return the number of key-value pairs in this symbol table
    	     */
    	    public int size() {
    	        return size(root);
    	    }

    	    // return number of key-value pairs in BST rooted at x
    	    private int size(Node x) {
    	        if (x == null) return 0;
    	        else return x.N;
    	    }




    	}


       private int Num;
       private BST<tree,Integer> cc;
	   public         PointSET()                               // construct an empty set of points 
	   {
		   
	   }
	   public           boolean isEmpty()                      // is the set empty? 
	   {
		   
	   }
	   public               int size()                         // number of points in the set 
	   {
		   
	   }
	   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
	   {
		   
	   }
	   public           boolean contains(Point2D p)            // does the set contain point p? 
	   {
		   
	   }
	   public              void draw()                         // draw all points to standard draw 
	   {
		   
	   }
	   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
	   {
		   
	   }
	   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 
	   {
		   
	   }
	   public static void main(String[] args)                  // unit testing of the methods (optional) 
	   {
		   
	   }
}
