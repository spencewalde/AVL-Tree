package lab8_AVLTree;

public class node {

	node right;
	node left;
	int data;
	
	public node() {
		
	}
	
	public node(int data, node left1, node right1) {
		this.data = data;
		this.left = left1;
		this.right= right1;
		
	}
	public void setData(int value) {
		data = value;
	}
	
	
}
