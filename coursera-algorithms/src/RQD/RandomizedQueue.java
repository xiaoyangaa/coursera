package RQD;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] a;
	private int N;
	
	
	   public RandomizedQueue()                 // construct an empty randomized queue
	   {
		   this.N=0;
		   this.a=null; 
	   }
	   public boolean isEmpty()                 // is the queue empty?
	   {
		   return N==0;
	   }
	   public int size()                        // return the number of items on the queue
	   {
		   return N;
	   }
	   public void enqueue(Item item)           // add the item
	   {
		   if(item==null)
			   throw new NullPointerException("nono");
		   if(isEmpty())
		   { 
			   	a=(Item[]) new Object[2];
		   		a[N++]=item;
		   }
		   else
			   if(N==a.length)
			   {
				   Item[] temp=(Item[]) new Object[2*a.length];
				   for(int i=0;i<a.length;i++)
					   temp[i]=a[i];
				   a=temp;
				   a[N++]=item;
			   }
			   else
			   { 
				a[N++]=item;
			   }
	   }
	   public Item dequeue()                    // remove and return a random item
	   {
		   if(isEmpty())
			  throw new NoSuchElementException("the queue is empty");
		   int index=StdRandom.uniform(N);
		   Item temp=a[index];
		   a[index]=a[--N];
		   a[N]=null;
		   if(N>0&&N==a.length/4)
		   {
			   Item[] temp2=(Item[]) new Object[a.length/2];
			   for(int i=0;i<a.length/2;i++)
				   temp2[i]=a[i];
			   a=temp2;
		   }   
		   return temp;
	   }
	   public Item sample()                     // return (but do not remove) a random item
	   {
		   if(isEmpty())
				  throw new NoSuchElementException("the queue is empty");
			   int index=StdRandom.uniform(N);
			   Item temp=a[index];
			   int temN=N-1;
			   a[index]=a[temN];
			   a[temN]=temp;
			   return temp;
	   }
	   public Iterator<Item> iterator()         // return an independent iterator over items in random order
	   {
		   return new ArrayIterator();
	   }
	   private class ArrayIterator implements Iterator<Item>{
		   private boolean []visited=new boolean[N];
		   private int times=N;
		   private int i=StdRandom.uniform(N);
		   public boolean hasNext(){
			   return times>0;
		   }
		   public void remove(){throw new UnsupportedOperationException();}
		   public Item next(){
			   if(!hasNext())
				   throw new NoSuchElementException();
			   while(visited[i]==true)
			   {
					   i=StdRandom.uniform(N);
			   }
			   times--;
			   visited[i]=true;
			   
			   return a[i];
		   }
	   }
	   public static void main(String[] args)   // unit testing
	   {
		   RandomizedQueue<Integer>cc=new RandomizedQueue<Integer>();
		   cc.enqueue(1);
		   cc.dequeue();
		   System.out.println(cc.size());
		   cc.enqueue(2);
		   cc.enqueue(3);
		   cc.enqueue(4);
		 cc.dequeue();
			   System.out.println(cc.size());
	   }
	}



