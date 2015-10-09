package week5;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdDraw;

public class RectHV {
	private double xmin;
	private double ymin;
	private double xmax;
	private double ymax;
	  private RedBlackBST<Point2D,Integer> rect; 
	   public    RectHV(double xmin, double ymin,double xmax,double ymax)      // construct the rectangle [xmin, xmax] x [ymin, ymax] 
	   																			// throw a java.lang.IllegalArgumentException if (xmin > xmax) or (ymin > ymax)
	   {
		   this.xmax=xmax;
		   this.xmin=xmin;
		   this.ymax=ymax;
		   this.ymin=ymin;
	   }
	   public  double xmin()                           // minimum x-coordinate of rectangle 
	   {
		   return this.xmin;
		  
	   }
	   public  double ymin()                           // minimum y-coordinate of rectangle 
	   {
		   return this.ymin;
	   } 
	   public  double xmax()                           // maximum x-coordinate of rectangle 
	   {
		   return this.xmax;
	   } 
	   public  double ymax()                           // maximum y-coordinate of rectangle  
	   {
		   return this.ymax;
	   }
	   public boolean contains(Point2D p)              // does this rectangle contain the point p (either inside or on boundary)?  
	   {
		   if(p.x()<=this.xmax&&p.x()>=this.xmin&&p.y()<=this.ymax&&p.y()>=this.ymin)
			   return true;
		   return false;
	   }
	   public boolean intersects(RectHV that)          // does this rectangle intersect that rectangle (at one or more points)?  
	   {
		   if(this.xmax<that.xmin)
			   return false;
		   if(this.xmin>that.xmax)
			   return false;
		   if(this.ymax<that.ymax)
			   return false;
		   if(this.ymin<that.ymin)
			   return false;
		   return true;
	   }
	   public  double distanceTo(Point2D p)            // Euclidean distance from point p to closest point in rectangle  
	   {
		   if(this.contains(p))
			   return 0.0;
		    if(p.x()<=this.xmin)
		    {
		    	if(p.y()<this.ymin)
		    		return p.distanceTo(new Point2D(this.xmin,this.ymin));
		    	else if(p.y()>this.ymax)
		    		 return p.distanceTo(new Point2D(this.xmin,this.ymax));
		    	else
		    		return this.xmin-p.x();
		    }
		    else if(p.x()>=this.xmax)
		    {
		    	if(p.y()<this.ymin)
		    		return p.distanceTo(new Point2D(this.xmax,this.ymin));
		    	else if(p.y()>this.ymax)
		    		 return p.distanceTo(new Point2D(this.xmax,this.ymax));
		    	else
		    		return p.x()-this.xmax;
		    }
		    else
		    {
		    	if(p.y()<=this.ymin)
		    		return this.ymin-p.y();
		    	else
		    		return ymax-p.y();
		    }
	   }
	   public  double distanceSquaredTo(Point2D p)     // square of Euclidean distance from point p to closest point in rectangle 
	   {
		   double dis=this.distanceTo(p);
		   return dis*dis;
	   } 
	   public boolean equals(Object that)              // does this rectangle equal that object?  
	   {
		   if(that==null)
			   return false;
		   if(this==that)
			   return true;
		   if(this.getClass()!=that.getClass())
			   return false;
		   RectHV tha=(RectHV)that;
		   if(this.xmax!=tha.xmax||this.xmin!=tha.xmin||this.ymax!=tha.ymax||this.ymin!=tha.ymin)
			   return false;
		   return true;
	   }
	   public    void draw()                           // draw to standard draw 
	   {
		   StdDraw.setPenColor(StdDraw.RED);
		   StdDraw.line(this.xmin, this.ymin, this.xmin, this.ymax);
		   StdDraw.line(this.xmin, this.ymin, this.xmax, this.ymin);
		   StdDraw.line(this.xmax, this.ymin, this.xmax, this.ymax);
		   StdDraw.line(this.xmax, this.ymax, this.xmin, this.ymax);
	   } 
	   public  String toString()                       // string representation  
	   {
		   String cc="";
		  return cc;
	   }
	}