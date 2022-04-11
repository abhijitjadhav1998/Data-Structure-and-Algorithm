class TreeNode {
	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public TreeNode(int value) {
		this.data = value;
	}

	public void insert(int value) {
		if (value == data) {
			return;
		}
		if (value < data) {
			if (leftChild == null) {
				leftChild = new TreeNode(value);
			} else {
				leftChild.insert(value);
			}
		} else {
			if (rightChild == null) {
				rightChild = new TreeNode(value);
			} else {
				rightChild.insert(value);
			}
		}
	}

	public int min() {
		if (leftChild == null) {
			return data;
		} else {
			return leftChild.min();
		}
	}

	public int max() {
		if (rightChild == null) {
			return data;
		} else {
			return rightChild.max();
		}
	}

	public void traverseInOrder() {
		if (leftChild != null) {
			leftChild.traverseInOrder();
		}
		System.out.print(data + ", ");
		if (rightChild != null) {
			rightChild.traverseInOrder();
		}
	}

	public TreeNode search(int value) {
		if (value == data) {
			return this;
		}

		if (value < data) {
			if (leftChild != null) {
				return leftChild.search(value);
			}
		} else {
			if (rightChild != null) {
				return rightChild.search(value);
			}
		}
		return null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}

}

class Tree {
	private TreeNode root;

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			root.insert(value);
		}
	}

	public void traverseInOrder() {
		if (root != null) {
			root.traverseInOrder();
		}
	}

	public TreeNode search(int value) {
		if (root != null) {
			return root.search(value);
		}
		return null;
	}

	public void delete(int value) {
		root = delete(root, value);
	}

	private TreeNode delete(TreeNode subTreeRoot, int value) {
		if (subTreeRoot == null) {
			return subTreeRoot;
		}

		if (value < subTreeRoot.getData()) {
			subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
		} else if (value > subTreeRoot.getData()) {
			subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
		} else {
			// Cases 1 and 2: node to delete has 0 or 1 child(ren)
			if (subTreeRoot.getLeftChild() == null) {
				return subTreeRoot.getRightChild();
			} else if (subTreeRoot.getRightChild() == null) {
				return subTreeRoot.getLeftChild();
			}
			// Case 3: node to delete has 2 children

			// Replace the value in the subtreeRoot node with the smallest value
			// from the right subtree
			subTreeRoot.setData(subTreeRoot.getRightChild().min());

			// Delete the node that has the smallest value in the right subtree
			subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
		}

		return subTreeRoot;
	}

	public int min() {
		if (root != null) {
			return root.min();
		}
		return Integer.MIN_VALUE;
	}

	public int max() {
		if (root != null) {
			return root.max();
		}
		return Integer.MAX_VALUE;
	}

}

public class TreeMain {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(25);
		tree.insert(20);
		tree.insert(27);
		tree.insert(15);
		tree.insert(22);
		tree.insert(26);
		tree.insert(30);
		tree.insert(29);
		tree.insert(32);
		tree.insert(33);

		tree.traverseInOrder();
		System.out.println();
//		System.out.println(tree.search(37));
//		System.out.println(tree.search(22));
//		System.out.println(tree.search(15));
//		System.out.println("Min value : " + tree.min());
//		System.out.println("Max value : " + tree.max());
		// tree.delete(15);
		tree.delete(30);

		tree.traverseInOrder();

	}

}
