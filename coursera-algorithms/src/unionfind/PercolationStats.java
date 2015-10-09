package unionfind;

import java.util.HashMap;

import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
	private static double []threashold;
	private int size;
	private int times;
	   public PercolationStats(int N, int T)   // perform T independent experiments on an N-by-N grid
	   {
		 if(N<=0||T<=0)
		   throw new IllegalArgumentException("the input number is illegal");
		   this.size=N;
		   this.times=T;
		   this.threashold=new double[T];
		 for(int j=0;j<T;j++)
		   {
			 Percolation perc=new Percolation(N);
			 HashMap <Integer,Integer> map=new HashMap <Integer,Integer>(); 
		    while(true)
		   {  
			   int c1=1+StdRandom.uniform(N);
			   int c2=1+StdRandom.uniform(N);
			   if(!map.containsKey(c1*N+c2))
			   {
				   map.put(c1*N+c2,1);
				   perc.open(c1, c2);
				  
				   if(perc.percolates())
				   	{
					   threashold[j]=(map.size())/(N*N+0.0);
				       break;
				    }
			   }
		   }
		 }
		
	   } 
	   public double mean()                      // sample mean of percolation threshold
	   {
		   double sum=0.0;
		   for(int i=0;i<times;i++)
			   sum+=threashold[i];
		 
		   return sum/times;
	   }
	   
	   public double stddev()                    // sample standard deviation of percolation threshold
	   {
		   double sum=0;
		   double mean=mean();
		   for(int i=0;i<times;i++)
			   sum+=(threashold[i]-mean)*(threashold[i]-mean);
			sum= Math.sqrt(sum/(times-1));
		   return sum;
	   }
	   public double confidenceLo()              // low  endpoint of 95% confidence interval
	   {
		   double confidencelo=mean()-1.96*stddev()/Math.sqrt(times);
		   return confidencelo;
	   }
	   
	   public double confidenceHi()              // high endpoint of 95% confidence interval
	   {
		   double confidencehi=mean()+1.96*stddev()/Math.sqrt(times);
		   return confidencehi;
	   }
	   
	   public static void main(String[] args)    // test client (described below)
	   {
		   
		   PercolationStats cc=new PercolationStats(20, 10);
		   System.out.println(cc.stddev());
		   
		   
		   System.out.println(cc.confidenceLo()+"   "+cc.confidenceHi());
		    
		
	   }
	}