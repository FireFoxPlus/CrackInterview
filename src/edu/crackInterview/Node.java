package edu.crackInterview;

public class Node {
	private Node left;
	private Node right;
	public Node()
	{
		left = null;
		right = null;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}
