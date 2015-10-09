package fortest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SimpleThread extends Thread{
	
	
    public static int minimumTotal(List<List<Integer>> triangle) {
       if(triangle==null)
    	   return 0;
    	
       int  minimum=Integer.MAX_VALUE;
       for(int k=0;k<triangle.get(triangle.size()-1).size();k++)
       {
    	   int num=minimumTotal(triangle,triangle.size()-1,k);
    	   if(num<minimum)
    		   minimum=num;
       } 	
       return minimum;
    }
    public static int minimumTotal(List<List<Integer>> triangle,int row,int column) {
      
           if(row==0)
        	   return triangle.get(0).get(0);
     
    	   List<Integer> currentlist=triangle.get(row);
    	   if(column==0)
    		   return currentlist.get(0)+minimumTotal(triangle,row-1,column);
    	   else if(column==currentlist.size()-1)
    		   return currentlist.get(column)+minimumTotal(triangle,row-1,column-1);
    	   else
    		   return Math.min(currentlist.get(0)+minimumTotal(triangle,row-1,column), currentlist.get(column)+minimumTotal(triangle,row-1,column-1));
    	    
       }
    
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        
    }
    public void rotate2(int[][] matrix,int length,int n) {
       int []temparr=new int[length];
       temparr=matrix[length-n];
       for(int i=0;i<n;i++)
    	   matrix[]
        
    }
    public int[] searchRange2(int[] nums, int target,int low,int hi) {
    	if(low>hi)
    		return null;
        int mid=low+(hi-low)/2;
        
        if(target==nums[mid])
         {
	        if(mid-1>=0&&target==nums[mid-1])
	          {
	        	 int []cc={mid-1,mid};
	        	 return cc;
	          }
	         else if(mid+1<nums.length)
	         {
	        	 int []cc={mid,mid+1};
	        	 return cc;
	         }
         }
        if(target<nums[mid])
        {
        	return searchRange2(nums,target,low,mid-1);
        }
        else
        	{
        		return searchRange2(nums,target,mid+1,hi);
        	}
      
        
    }
	
	  public SimpleThread(String str){
	   super(str);
	  }
	 

	  public void run(){//复写父类的run()方法
		 
	    System.out.println(getName());
	    try{
	    	sleep((int)(Math.random() * 1000));//线程休眠，把控制权交出去
	   }
	    catch(InterruptedException e) {}
	   }
	  
	  public boolean containsDuplicate(int[] nums) {
	        HashMap<Integer,Integer> cc=new HashMap<Integer,Integer>();
	        for(int i=0;i<nums.length;i++)
	         if(!cc.containsKey(nums[i]))
	        	 cc.put(nums[i], i);
	         else
	        	 return true;
	        return false;
	    }
	  public static void setZeroes(int[][] matrix) {
		  if(matrix==null)
		        return;
		        int rowlen=matrix.length;
		        int columnlen=matrix[0].length;
		        HashMap<Integer,Integer> row=new HashMap<Integer,Integer>();
		        List<Integer> rownum=new ArrayList<Integer>();
		        HashMap<Integer,Integer> column=new HashMap<Integer,Integer>();
		        List<Integer> columnnum=new ArrayList<Integer>();
		        for(int i=0;i<rowlen;i++)
		        	for(int j=0;j<columnlen;j++)
		        	{
		        		if(matrix[i][j]==0)
		        		{
		        			if(!row.containsKey(i))
		        			{
		        				row.put(i, 1);
		        				rownum.add(i);
		        			}if(!column.containsKey(j))
		        			{
		        				column.put(j, 1);
		        				columnnum.add(j);
		        			}
		        		}
		        			
		        	}
		       if(rownum!=null)
		    	   for(int i:rownum)
		    	     for(int k=0;k<columnlen;k++)
		    	    	 matrix[i][k]=0;
		       if(columnnum!=null)
		    	   for(int i:columnnum)
			    	     for(int k=0;k<rowlen;k++)
			    	    	 matrix[k][i]=0;
		        
	    }
	  
	  public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> result= new ArrayList<List<Integer>>();
	        
	       List<Integer> firstrow=new ArrayList<Integer>();
	        firstrow.add(1);
	        result.add(firstrow);
	        if(numRows==1)
	         return result;
	         List<Integer> templist=firstrow;
	         for(int i=1;i<numRows;i++)
	          {
	              List<Integer> currentrow=new ArrayList<Integer>();
	              currentrow.add(1);
	              for(int j=0;j<templist.size()-1;j++)
	            	  currentrow.add(templist.get(j)+templist.get(j+1));
	              currentrow.add(1);
	              result.add(currentrow);
	              templist=currentrow;
	          }
	         return result;
	        
	    }
	  public static int uniquePaths(int m, int n) {
	        if(m==1||n==1)
	         return 1;
	        int p= uniquePaths(m-1,n)+uniquePaths(m,n-1);
	        return p;
	        
	    }
	 public static void main(String args[]){
	
		 System.out.println(uniquePaths(23, 60));
	  }
	}
