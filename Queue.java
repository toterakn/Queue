# Queue

/**
 * @author KristinaTotera
 * Friday, February 20, 2015
 * DataStructues and Algorithms
 * Program that implements a queue using a doubly linked list
 * @param <AnyType>
 */

// queue is first in, first out
//public class Queue <AnyType extends QueueInterface<? super AnyType>>{
public class Queue <AnyType> implements QueueInterface<AnyType>{
	   
    /******** an inner class  **********************
     * The node type for a doubly linked list Queue
     */
    private static class Node<AnyType> {
        
        public Node(AnyType x) {
            data = x; next = null; prev = null;        
        } 
        public AnyType data;
        public Queue.Node<AnyType> next;
        public Queue.Node<AnyType> prev;
    }
    /**********************************************************/
    
    private Queue.Node<AnyType> front; // front marker
    private Queue.Node<AnyType> tail; // tail marker	
	
	/**
	 * no argument constructor
	 * sets tail and front to null
	 * list starts off empty
	 */
    public Queue () {
        tail = null;
        front = null;  // When list is empty, front is null
    }
	
    
	/**
	 * enqueue method
	 * add item to back of line
	 * @param Anytype x, the item to add
	 */
	public void enqueue(AnyType x){
		Node<AnyType> newNode = new Node<AnyType>(x);
		if (isEmpty() == true){
			front = newNode;
		}else{
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		
	}
		
	/**
	 * dequeue method
	 * removes item from front of line, return it
	 * throws EmptyQueueException if list is empty
	 * @return the item removed
	 */
	public AnyType dequeue() throws EmptyQueueException{
		if (isEmpty() == true){
			throw new EmptyQueueException();
		}
		Node<AnyType> removedItem = front;
		if (front.next == null){
			tail = null;
		}else{
			front.next.prev = null;
		}
		front = front.next;
		return (AnyType) removedItem.data;
	}
	
	/**
	 * checks if the list is empty
	 * @return boolean, true if empty, false if not empty
	 * used in both enqueue and dequeue methods
	 */
	private boolean isEmpty(){
		return front == null;
	}
	
	/**
	 * toString method to be able to test results
	 * is the code provided method professor
	 */
	public String toString(){
        Node<AnyType> walker = front;
        String returnString = "";
        while (walker != null){
            returnString += walker.data + "\n";
            walker = walker.next;
        }  
        return returnString;
    }
	
    
   public static void main(String[] args){
   	try{
   		Queue<Integer> o = new Queue<Integer>();
   		
   		//adding items to end of list
   		o.enqueue(2);
   		o.enqueue(5);
   		o.enqueue(7);
   		o.enqueue(1);
   		System.out.println(o.toString());
   		
   		//remove from front
   		o.dequeue();
   		System.out.println(o.toString());
   		o.dequeue();
   		System.out.println(o.toString());
   		o.dequeue();
   		System.out.println(o.toString());
   		
   		//does the dequeue return the correct removed value...
   		System.out.println("Item removed: ");
   		System.out.println(o.dequeue());
   		
   		System.out.println(o.toString());
   		
   		//should throw exception since list is empty
   		o.dequeue();
   		System.out.println(o.toString());
   		      
   	}catch(EmptyQueueException e){
   		System.out.println(e);		
   	}
   	
   }

}
