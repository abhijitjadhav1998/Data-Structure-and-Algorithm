class Node {
	Node next;
	int data;

	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
}

class LinkedListOperations {

	Node head;

	public void add(int value) {
		Node node = new Node(value);
		if(head == null) {
			head = node;
		}else {
			Node tempNode = head;
			while(tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}
	}
	
	public void insertFromFront(int value) {
		Node node = new Node(value);
		if(head == null) {
			head = node;
		}else {
			Node tempNode = head;
			node.next = tempNode;
			head = node;
		}
	}
	
    public void display(){
        Node node = head;
        System.out.print("head => " );
        while(node != null){
            System.out.print(node.data + " => ");
            node = node.next ;
        }
        System.out.println("null");
    }

	public void delete() {
		Node node = head;
		while(node.next.next != null) {
			node = node.next;
		}
		node.next = null;
	}

	public void deleteFromFront() {
		Node node = head;
		head = node.next;
	}

	public void insertInMiddles(int position, int value) {
		Node tempNode = head;
		Node node = new Node(value);
		if(position == 0) {
			insertFromFront(value);
			return;
		}
		for(int i=1;i<position-1;i++) {
			tempNode = tempNode.next;
		}
		node.next = tempNode.next;
		tempNode.next = node;
		
	}

	public void deleteFromMiddle(int position) {
		Node node = head;
		if(position == 0) {
			deleteFromFront();
			return;
		}
		for(int i=1;i<position;i++) {
			node = node.next;
		}
		if(node.next == null){
			node = null;
		}else {
			node.next = node.next.next;
		}
	}

}

public class LinkedList {

	public static void main(String[] args) {
		LinkedListOperations list = new LinkedListOperations();
		list.add(20);
		list.add(40);
		list.add(50);
		list.insertFromFront(10);
		list.insertFromFront(30);
		list.display();
		list.delete();
		list.display();
		list.deleteFromFront();
		list.display();
		list.insertInMiddles(1,60);
		list.display();
		list.deleteFromMiddle(2);
		list.display();


	}

}
