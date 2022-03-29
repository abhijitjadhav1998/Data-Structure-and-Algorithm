class Queue {
	private int front;
	private int rear;
	private int[] queue;

	public Queue() {
		queue = new int[10];
		front = -1;
		rear = 0;
	}

	public void enqueue(int value) {
		checkSize();
		queue[++front] = value;
	}

	public int dequeue() {
		if (rear > front)
			return -1;
		return queue[++rear];
	}

	public int peek() {
		return queue[front];
	}

	public void checkSize() {
		if (front >= queue.length-1) {
			System.out.println("resizing array");
			int newQueue[] = new int[(front - rear) * 2];
			int index = 0;
			for (int i = rear; i <= front; i++) {
				newQueue[index++] = queue[i];
			}
			queue = newQueue;
		}
	}

	public void printQueue() {
		for (int i = rear; i < front; i++) {
			System.out.print(queue[i] + " " );
		}
		System.out.println();
	}
}

public class ArrayQueue {

	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.enqueue(23);
		queue.enqueue(223);
		queue.enqueue(323);
		queue.enqueue(237);
		queue.enqueue(243);
		queue.enqueue(923);
		queue.enqueue(253);
		queue.enqueue(233);
		queue.enqueue(623);
		queue.enqueue(423);
		queue.enqueue(723);
		queue.enqueue(923);
		queue.enqueue(293);
		queue.enqueue(239);
		queue.printQueue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		System.out.println(queue.peek());


	}

}
