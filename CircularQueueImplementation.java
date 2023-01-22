package com.CircularQueue.main;

import java.util.Arrays;

public class CircularQueueImplementation {
	
	public static void main(String[] args) {

        CircularQueue<Integer> circularQueue = new CircularQueue(8);

        circularQueue.enqueue(11);
        circularQueue.enqueue(12);
        circularQueue.enqueue(13);
        circularQueue.enqueue(14);
        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);

        System.out.println("Full Circular Queue" + circularQueue);

        System.out.print("Dequeued following element from circular Queue ");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(19);
        System.out.println("After enqueueing circular queue with element having value 19");
        System.out.println(circularQueue);
    }

}



class CircularQueue<E> {

  private int currentSize; 
  private E[] circularQueueElements;
  private int maxSize; 

  private int rear;
  private int front;       

  public CircularQueue(int maxSize) {
      this.maxSize = maxSize;
      circularQueueElements = (E[]) new Object[this.maxSize];
      currentSize = 0;
      front = -1;
      rear = -1;
  }

  /**
   * Enqueue elements to rear.
   */
  public void enqueue(E item) throws QueueFullException {
      if (isFull()) {
          throw new QueueFullException("Circular Queue is full. Element cannot be added");
      }
      else {
          rear = (rear + 1) % circularQueueElements.length;
          circularQueueElements[rear] = item;
          currentSize++;
          
          if (front == -1) {
				front = rear;
			}
      }
  }

  /**
   * Dequeue element from Front.
   */
  public E dequeue() throws QueueEmptyException {
      E deQueuedElement;
      if (isEmpty()) {
          throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
      }
      else {
          deQueuedElement = circularQueueElements[front];
          circularQueueElements[front] = null;
          front = (front + 1) % circularQueueElements.length;
          currentSize--;
      }
      return deQueuedElement;
  }

  /**
   * Check if queue is full.
   */
  public boolean isFull() {
      return (currentSize == circularQueueElements.length);
  }

  /**
   * Check if Queue is empty.
   */
  public boolean isEmpty() {
      return (currentSize == 0);
  }

  @Override
  public String toString() {
      return "CircularQueue [" + Arrays.toString(circularQueueElements) + "]";
  }

}


class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
  
