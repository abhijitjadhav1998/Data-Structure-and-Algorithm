class Heap {
	private int[] heap;
	private int size;

	public Heap(int capacity) {
		super();
		this.heap = new int[capacity];
	}

	public void insert(int value) {
		if (isFull()) {
			resizeHeap();
		}
		heap[size] = value;
		heapifyAbove(size);
		size++;
	}

	private void heapifyAbove(int size2) {
		// TODO Auto-generated method stub
		
	}

	private void resizeHeap() {
		int tempHeap[] = heap;
		heap = new int[tempHeap.length * 2];
		for (int i = 0; i < tempHeap.length; i++) {
			heap[i] = tempHeap[i];
		}

	}

	private boolean isEmpty() {
		return size == 0;
	}

	private boolean isFull() {
		return size == heap.length;
	}

}

public class MaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
