
class Stack{
	private int top;
	private int[] stack;
	public Stack() {
		top = -1;
		stack = new int[10];
	}
	
	public void push(int value) {
		checkSize();
		stack[++top] = value;
	}
	
	public int pop() {
		return stack[top--];
	}
	
	public int peek() {
		return stack[top];
	}
	
	public void printStack() {
		for(int i = top;i>=0;i--) {
			System.out.println(" | " + stack[i] + " | ");
		}
		System.out.println();
	}
	
	public void checkSize() {
		if(top >= stack.length-1) {
			System.out.println("Resizing array");
			int[] newStack = new int[stack.length * 2];
			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
	}
}
public class ArrayStack {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(4);
		stack.push(3);
		stack.push(14);
		stack.push(34);
		stack.push(44);
		stack.push(45);
		stack.push(47);
		stack.push(94);
		stack.push(47);
		stack.push(64);
		stack.push(44);
		stack.printStack();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();

	}

}
