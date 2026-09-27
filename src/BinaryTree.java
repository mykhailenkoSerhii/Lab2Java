public class BinaryTree
{
	private Node root = null;

	public BinaryTree() {}

	public BinaryTree(int rootValue)
	{
		root = new Node(rootValue);
	}

	public void insert(int value)
	{
		root = insertRecurse(root, value);
	}

	private Node insertRecurse(Node current, int value)
	{
		if(current == null)
			return new Node(value);

		if(value < current.value)
			current.left = insertRecurse(current.left, value);
		else if (value > current.value)
			current.right = insertRecurse(current.right, value);

		return current;
	}

	public boolean contains(int value)
	{
		return containsRecurse(root, value) != null;
	}

	public Node get(int value)
	{
		return containsRecurse(root, value);
	}

	private Node containsRecurse(Node current, int value)
	{
		if (current == null || current.value == value)
			return current;

		if (value < current.value)
			return containsRecurse(current.left, value);

		return containsRecurse(current.right, value);
	}

	public void remove(int value)
	{
		root = removeRecurse(root, value);
	}

	private Node removeRecurse(Node current, int value)
	{
		if (current == null)
			return null;

		if (value < current.value)
			current.left = removeRecurse(current.left, value);
		else if (value > current.value)
			current.right = removeRecurse(current.right, value);
		else
		{
			if (current.left == null)
				return current.right;
			else if (current.right == null)
				return current.left;

			current.value = findSmallestValue(current.right);
			current.right = removeRecurse(current.right, current.value);
		}

		return current;
	}

	private int findSmallestValue(Node root)
	{
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	public int getSmallestValue()
	{
		return findSmallestValue(root);
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof BinaryTree tree)
			return this.root.equals(tree.root);
		return super.equals(obj);
	}

	public static class Node
	{
		private int value;
		private Node left = null;
		private Node right = null;

		public Node(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return value;
		}

		public Node getRight()
		{
			return right;
		}

		public Node getLeft()
		{
			return left;
		}

		@Override
		public boolean equals(Object obj)
		{
			if(obj instanceof Node node)
			{
				return this.value == node.value &&
							   this.left.equals(node.left) &&
							   this.right.equals(node.right);
			}
			return super.equals(obj);
		}

		@Override
		public String toString()
		{
			return String.valueOf(value);
		}
	}
}
