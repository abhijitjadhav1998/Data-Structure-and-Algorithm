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

	public int delete(int index) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is Empty");
		}
		// int parent = getParent(index);
		int deletedValue = heap[index];
		heap[index] = heap[size - 1];
		if (heap[index] > heap[getParent(index)]) {
			heapifyAbove(index);
		} else {
			heapifyBelow(index, size);
		}
		size--;
		return deletedValue;
	}

	private void heapifyBelow(int index, int lastIndex) {
		int childToSwap;

		while (index < lastIndex) {
			int leftChild = getChild(index, true);
			int rightChild = getChild(index, false);
			if (leftChild <= lastIndex) {
				if (rightChild > lastIndex) {
					childToSwap = leftChild;
				} else {
					childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
				}

				if (heap[index] < heap[childToSwap]) {
					int tmp = heap[index];
					heap[index] = heap[childToSwap];
					heap[childToSwap] = tmp;
				} else {
					break;
				}

				index = childToSwap;
			} else {
				break;
			}
		}
	}

	public void printHeap() {
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i]);
			System.out.print(", ");
		}
		System.out.println();
	}

	private int getChild(int index, boolean leftChild) {
		return (2 * index) + (leftChild ? 1 : 2);
	}

	private void heapifyAbove(int index) {
		while (index > 0) {
			int parent = getParent(index);
			if (heap[parent] < heap[index]) {
				int temp = heap[index];
				heap[index] = heap[parent];
				heap[parent] = temp;
				index = parent;
			} else {
				return;
			}
		}
	}

	private int getParent(int index) {
		return (index - 1) / 2;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Heap is empty");
		}

		return heap[0];
	}

	private void resizeHeap() {
		int tempHeap[] = heap;
		heap = new int[tempHeap.length * 2];
		for (int i = 0; i < tempHeap.length; i++) {
			heap[i] = tempHeap[i];
		}

	}

	public void sort() {
		int lastHeapIndex = size - 1;
		for (int i = 0; i < lastHeapIndex; i++) {
			int temp = heap[0];
			heap[0] = heap[lastHeapIndex - i];
			heap[lastHeapIndex - i] = temp;

			heapifyBelow(0, lastHeapIndex - i - 1);
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
		Heap heap = new Heap(10);
		heap.insert(80);
		heap.insert(75);
		heap.insert(60);
		heap.insert(68);
		heap.insert(55);
		heap.insert(40);
		heap.insert(52);
		heap.insert(67);

		heap.printHeap();
		heap.sort();
//		System.out.println(heap.peek());
//
//		heap.delete(0);
		heap.printHeap();

		// System.out.println(heap.peek());
	}

}
