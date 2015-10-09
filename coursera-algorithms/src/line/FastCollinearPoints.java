package line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {
	  private ArrayList<LineSegment> lines=new ArrayList<LineSegment>();
	  
	  private int linenum=0;
	  private HashMap <Point,Point> map=new HashMap <Point,Point>();
	   public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
	   {
		  
		   int length=points.length;
			Point[]points2=new Point[length];
			int k=0;
				for(Point p:points)
				   points2[k++]=p;
			Arrays.sort(points2);			
			for(int j=0;j<length-1;j++)
				if(points2[j].equals(points2[j+1]))
					throw new IllegalArgumentException();
		   for(int i=0;i<length;i++)
		   {
			  Point[]cc=new Point[length];
			   int j=0;
			   for(Point p:points2)
				   	{ 
				   		cc[j++]=p;  
				   	}
			   Arrays.sort(cc,points2[i].slopeOrder());
				   int index=0;
				   int temp=0;
				   while(index<length-1)
				   {
					 
					  if(cc[index].slopeTo(points2[i])==cc[index+1].slopeTo(points2[i]))
					   {
						  index++;	  
					   }
					  else
				      {
						  int times=index-temp;
						  if(times>=2)
							  {
							    
							     if(points2[i].compareTo(cc[temp])<0)
							    	{
							    		LineSegment ln=new LineSegment(points2[i],cc[index]);
								    	lines.add(ln);
								    	linenum++;								
							    	}
							   }
						  temp=index+1;
						  index++;
				      }
				   }
				   int times=index-temp;
					  if(times>=2)
						  {
						     if(points2[i].compareTo(cc[temp])<0)
						    	{
							    		LineSegment ln=new LineSegment(points2[i],cc[index]);
								    	lines.add(ln);
								    	linenum++;
						    	}
						   } 
		   }
	   }
	   public int numberOfSegments()        // the number of line segments
	   {
		   return linenum;
	   }
	   public LineSegment[] segments()                // the line segments
	   { 
		   
		   LineSegment[] cc=new LineSegment[linenum];
		   int i=0;
		   for(LineSegment ln:lines)
			   {    
			   		cc[i++]=ln;
			   }
		   return cc;
	   }
	   public static void main(String[] args) {
	        /* YOUR CODE HERE */
		   
		   In in = new In("E:\\0000android»·¾³´î½¨\\eclipse-jee-indigo-win32\\eclipse\\11\\coursera-algorithms\\input56.txt");
		    int N = in.readInt();
		    Point[] points = new Point[N];
		    for (int i = 0; i < N; i++) {
		        int x = in.readInt();
		        int y = in.readInt();
		        points[i] = new Point(x, y);
		    }
		    // draw the points
		    StdDraw.show(0);
		    StdDraw.setXscale(0, 32768);
		    StdDraw.setYscale(0, 32768);
		    for (Point p : points) {
		        p.draw();
		    }
		    StdDraw.show();
		    // print and draw the line segments
		    FastCollinearPoints collinear = new FastCollinearPoints(points);
		    for (LineSegment segment : collinear.segments()) {
		        StdOut.println(segment.toString());
		        segment.draw();
		    }
	   }
	}