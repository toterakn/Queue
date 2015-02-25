
/**
 * 
 * @author KristinaTotera
 * Friday February 20, 2015
 * DataStructures and Algorithms
 *  QueueInterface. Contains the enqueue and dequeue method
 * @param <AnyType>
 */


public interface QueueInterface<AnyType> {
	/**
	 * enqueue method: will add item to end of list
	 * @param x, AnyType
	 */
	public void enqueue(AnyType x);
	
	/**
	 * dequeue method: will remove item at front of list
	 * @return, the removed item
	 * @throws EmptyQueueException
	 */
	public AnyType dequeue() throws EmptyQueueException;
}
