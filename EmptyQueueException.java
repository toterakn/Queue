

/**
 * 
 * Friday February 20, 2015
 * DataStructures and Algorithms
 * EmptyQueueException, exception, if trying to remove data from an empty list
 * Used in Queue.java
 * Given in the HW4 pdf, @author professor
 */
public class EmptyQueueException extends Exception {
    public EmptyQueueException(String message) {
        super(message);
    }
    public EmptyQueueException() {
        super("Attempt to remove data from an empty queue.");
    }
}
