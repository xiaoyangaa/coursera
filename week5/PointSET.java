package week5;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.RedBlackBST;

public class PointSET {
	   
	
	  private RedBlackBST<Point2D,Integer> cc; 
	  private int Num;
	   public         PointSET()                               // construct an empty set of points 
	   {
		   cc=new RedBlackBST<Point2D,Integer>();
	   }
	   public           boolean isEmpty()                      // is the set empty? 
	   {
		   return cc.isEmpty();
	   }
	   public               int size()                         // number of points in the set 
	   {
		   return Num;
	   }
	   public              void insert(Point2D p)              // add the point to the set (if it is not already in the set)
	   {
		  cc.put(p, 1);
	   }
	   public           boolean contains(Point2D p)            // does the set contain point p? 
	   {
		  return  cc.contains(p);
	   }
	   public              void draw()                         // draw all points to standard draw 
	   {
		   
	   }
	   public Iterable<Point2D> range(RectHV rect)             // all points that are inside the rectangle 
	   {
		   List<Point2D> ran=new ArrayList<Point2D>();
		   for(Point2D ccc:cc.keys())
			   if(rect.contains(ccc))
				   ran.add(ccc);
			return ran;
	   }
	   public           Point2D nearest(Point2D p)             // a nearest neighbor in the set to point p; null if the set is empty 
	   {
		   double min=10;
		   Point2D tempp=new Point2D(0.5,0.5);
		   for(Point2D ccc:cc.keys())
			   {
			   double dis=ccc.distanceTo(p);
			   if(dis<min)
				   {
				   	min=dis;
				   	tempp=ccc;
				   }
			   }
		   return tempp;
	   }
	   public static void main(String[] args)                  // unit testing of the methods (optional) 
	   {
		   
	   }
	}