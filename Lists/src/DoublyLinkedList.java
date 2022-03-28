class DoublyNode {
	int data;
	DoublyNode next;
	DoublyNode prev;

	public DoublyNode(int data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}

}

class DoublyLinkedListOperations {
	DoublyNode head, tail;

	public void insert(int value) {
		DoublyNode node = new DoublyNode(value);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			DoublyNode tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
			node.prev = tempNode;
			tail = node;

		}
	}

	public void inserAtFront(int value) {
		DoublyNode node = new DoublyNode(value);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			DoublyNode tempNode = head;
			node.next = tempNode;
			tempNode.prev = node;
			head = node;

		}
	}

	public void inserAtMiddle(int value, int pos) {
		DoublyNode node = new DoublyNode(value);
		DoublyNode tempNode = head;
		for (int i = 0; i < pos; i++) {
			tempNode = tempNode.next;
		}
		node.next = tempNode.next;
		node.prev = tempNode;
		tempNode.next.prev = node;
		tempNode.next = node;
	}

	public void display() {
		DoublyNode node = head;
		System.out.print("head => ");
		while (node != null) {
			System.out.print(node.data + " <=> ");
			node = node.next;
		}
		System.out.println("tail");
	}

	public void reverseDisplay() {
		DoublyNode node = tail;
		System.out.print("tail => ");
		while (node != null) {
			System.out.print(node.data + " <=> ");
			node = node.prev;
		}
		System.out.println("head");
	}

	public void insertFromBack(int value) {
		DoublyNode node = new DoublyNode(value);
		DoublyNode tempNode = tail;
		tempNode.next = node;
		tail = node;
		node.prev = tempNode;

	}

	public void deleteFromFront() {
		DoublyNode node = head;
		head = node.next;
		node.next.prev = null;
	}

	public void deleteFromBack() {
		DoublyNode node = tail;
		tail = node.prev;
		node.prev.next = null;
		
	}

	public void deleteAtPos(int pos) {
		DoublyNode node = head;
		for (int i = 0; i < pos-1; i++) {
			node = node.next;
		}
		node.next = node.next.next;
		node.next.prev = node;
	}
}

public class DoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedListOperations list = new DoublyLinkedListOperations();
		list.insert(5);
		list.insert(3);
		list.insert(43);
		list.inserAtFront(431);
		list.inserAtMiddle(56, 2);
		list.insertFromBack(23);
		list.display();
		list.reverseDisplay();
		list.deleteFromFront();
		list.display();
		list.reverseDisplay();
		list.deleteFromBack();
		list.display();
		list.reverseDisplay();
		list.deleteAtPos(2);
		list.display();
		list.reverseDisplay();
		
	}

}
