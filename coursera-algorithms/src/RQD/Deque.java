package RQD;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int N;
	private class Node{
		Item item;
		Node next;
		Node front;
	}
	   public Deque()                           // construct an empty deque
	   {
		   this.first=null;
		   this.last=null;
	   }
	   public boolean isEmpty()                 // is the deque empty?
	   {
		   if(first==null||last==null)
			   return true;
		   return false;
	   }
	   public int size()                        // return the number of items on the deque
	   {
		   return N;
	   }
	   public void addFirst(Item item)          // add the item to the front
	   {
		   if(item==null)
			   throw new NullPointerException("item is null");	   
		   Node oldfirst=first;
		   first=new Node();
		   first.item=item;
		   if(isEmpty())
			   {
			   first.next=null;
			   first.front=null;
			   last=first;
			   N++;
			   }
		   else{
			   first.front=null;
			   first.next=oldfirst;
			   oldfirst.front=first;
			   N++;
		   }
		  
	   }
	   public void addLast(Item item)           // add the item to the end
	   {
		   if(item==null)
			   throw new NullPointerException("item is null");
		   Node oldlast=last;
		   last=new Node();
		   last.item=item; 
		   if(isEmpty()) 
			{
			   last.front=null;
			   last.next=null;
			   first=last;
			   N++;
			}
		   else
			{
				last.next=null;
				last.front=oldlast;
				oldlast.next=last;
				N++;	
			}	
	   }
	   public Item removeFirst()                // remove and return the item from the front
	   {
		   if(isEmpty())
		   throw new  NoSuchElementException("the queue is already empty");
		   Item item=first.item;
		   first=first.next;
		   if(isEmpty())
		   {
			   last=null;
			   N--;
			   return item;
		   }
		   else
		   {
			   first.front=null;
			   N--;
			   return item; 
		   }
		
	   }
	   public Item removeLast()                 // remove and return the item from the end
	   {
		   if(isEmpty())
			   throw new  NoSuchElementException("the queue is already empty");
			   Item item=last.item;
			   last=last.front;
			   if(isEmpty())
			   {
				   first=null;
				   N--;
				   return item;
			   }
			   else{
				   last.next=null;
				   N--;
				   return item;
			   }
			 
	   }
	   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
	   {
		  return new listiterator();
	   }
	   private class listiterator implements Iterator<Item>{
		   private Node current =first;
		   public boolean hasNext()
		   {
			   return current!=null;
		   }
		   public void remove(){
			  throw new UnsupportedOperationException();
		   }
		   public Item next()
		   {
			   if(!hasNext())
				   throw new NoSuchElementException();
			   Item item=current.item;
			   current=current.next;
			   return item;
		   }
	   }
	   
	   public static void main(String[] args)   // unit testing
	   {
		   Deque<Integer> cc=new Deque<Integer>();
		   Integer a=(Integer) 1;
		   Integer b=(Integer) 2;
		   Integer c=(Integer) 3;
		   cc.addLast(a);
		   System.out.println(a);
		   cc.addFirst(b);
		   System.out.println(b);
		   cc.addLast(c);
		   System.out.println(c);
		   cc.removeLast();
		  
			   for(int d:cc)
				   System.out.println(cc.size());
	   }
	   
	}


