import java.util.Arrays;

class CircularQueue {
	private int front;
	private int rear;
	private int[] queue;

	public CircularQueue() {
		queue = new int[2];
	}

	public void enqueue(int value) {
		System.out.println("Original array" + Arrays.toString(queue));
		System.out.println("Front : " + front + " Rear: " + rear);
		if (size() == queue.length - 1) {
			resizeQueue();
		}
		queue[front] = value;
		if (front < queue.length - 1) {
			front++;
		} else {
			front = 0;
		}

	}

	public int size() {
		if (rear < front)
			return front - rear;
		else
			return front - rear + queue.length;
	}

	private void resizeQueue() {
		int newQueue[] = new int[queue.length * 2];
		int index = 0;

		for (int i = rear; i < queue.length; i++) {
			newQueue[index++] = queue[i];
		}
		if(front != queue.length-1) {
			for (int i = 0; i <= front; i++) {
				newQueue[index++] = queue[i];
			}
		}
		queue = newQueue;
		rear = 0;
		front = index-1;
	}

	public int dequeue() {
		rear = rear % queue.length;
		System.out.println("Original array" + Arrays.toString(queue));
		System.out.println("Front : " + front + " Rear: " + rear);
		return queue[++rear];
	}

	public int peek() {
		front = front % queue.length;
		return queue[front];
	}

	public void printQueue() {
		System.out.println("From Print Queue" + Arrays.toString(queue));

		if (rear > front) {
			for (int i = rear; i < queue.length; i++) {
				System.out.print(queue[i] + "=> ");
			}

			for (int i = 0; i <= front; i++) {
				System.out.print(queue[i] + "=> ");
			}
		} else {
			for (int i = 0; i <= front; i++) {
				System.out.print(queue[i] + " ");
			}
		}
		System.out.println();
	}
}

public class ArrayCircularQueue {

	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue();
		queue.enqueue(23);
		queue.enqueue(223);
		queue.dequeue();
		queue.enqueue(323);
		queue.enqueue(237);
		queue.enqueue(243);
		queue.dequeue();

		queue.enqueue(923);
		queue.dequeue();

		queue.enqueue(623);

		queue.enqueue(723);

		queue.printQueue();
	}

}
