package line;

import java.util.ArrayList;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


public class BruteCollinearPoints{
	  private int linenum=0;
	  private ArrayList<LineSegment> ls=new ArrayList<LineSegment>();
	  
	   public  BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
	   {
		   
		  if(points.length<4)
			  return;
		  int length=points.length;
		  for(int i=0;i<length;i++)
			  for(int j=i+1;j<length;j++)
			  {
				  for(int k=j+1;k<length;k++)
					  for(int l=k+1;l<length;l++)
					  {
						  if(points[i].slopeTo(points[j])==points[i].slopeTo(points[k])&&points[i].slopeTo(points[k])==points[i].slopeTo(points[l]))
						  {
							  Point p1=(points[i].compareTo(points[j])>0)?points[i]:points[j];
							  Point p2=(points[k].compareTo(points[l])>0)?points[k]:points[l];
							  Point p=(p1.compareTo(p2)>0)?p1:p2;
							  Point p3=(points[i].compareTo(points[j])<0)?points[i]:points[j];
							  Point p4=(points[k].compareTo(points[l])<0)?points[k]:points[l];
							  Point q=(p3.compareTo(p4)<0)?p3:p4;
							  LineSegment ln=new LineSegment(q,p);
							  ls.add(ln);
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
		   for(LineSegment l:ls)
			   cc[i++]=l;
		   return cc;
	   }
	   public static void main(String[] args) {
	        /* YOUR CODE HERE */
		   In in = new In("E:\\0000android»·¾³´î½¨\\eclipse-jee-indigo-win32\\eclipse\\11\\coursera-algorithms\\equidistant.txt");
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
		    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
		    for (LineSegment segment : collinear.segments()) {
		        StdOut.println(segment);
		        segment.draw();
		    }
	   }
}