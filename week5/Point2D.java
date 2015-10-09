package week5;

import edu.princeton.cs.algs4.StdDraw;

public class Point2D implements Comparable<Point2D> {
	private double x;
	private double y;
	public Point2D(double x, double y)              // construct the point (x, y)
	   {
		   this.x=x;
		   this.y=y;
	   }
	   public  double x()                              // x-coordinate 
	   {
		   return x;
	   }
	   public  double y()                              // y-coordinate 
	   {
		   return y;
	   }
	   public  double distanceTo(Point2D that)         // Euclidean distance between two points 
	   {
		   double dis=Math.sqrt((this.x()-that.x())*(this.x()-that.x()) +(this.y()-that.y())*(this.y()-that.y()));
			return dis;	  
	   }
	   public  double distanceSquaredTo(Point2D that)  // square of Euclidean distance between two points 
	   {
		   double dis=this.distanceTo(that);
		   return dis*dis;
	   }
	   public     int compareTo(Point2D that)          // for use in an ordered symbol table 
	   {
		   if(this.x()<that.x())
			   return -1;
		   else if(this.x()==that.x()&&this.y()==that.y())
			   return 0;
		   else
			   return 1;
	   }
	   public boolean equals(Object that)              // does this point equal that object? 
	   {
		   if(this==that)
			   return true;
		   if(this.getClass()!=that.getClass())
			   return false;
		   Point2D tha=(Point2D)that;
		   if(this.x!=tha.x||this.y!=tha.y)
			   return false;
		   return true;
	   }
	   public    void draw()                           // draw to standard draw 
	   {
		   StdDraw.setPenColor(StdDraw.BLACK);
		   StdDraw.setPenRadius(.01);
		   StdDraw.point(x, y);
	   }
	   public  String toString()                       // string representation 
	   {
		   
	   }
	   
	}