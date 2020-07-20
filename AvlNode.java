package lab8_AVLTree;

public class AvlNode extends node{

	int height;
	
	AvlNode getLeft( ) {
		return (AvlNode) right;}
	
	AvlNode getright() {
		return (AvlNode) left;}
	
	
	public AvlNode(int value) 
	{
		
		this(value, null, null);
		
	}
	
	public AvlNode(int val, AvlNode left1, AvlNode right1)
	{
		
		super(val, left1, right1);
		height = 0;
		
	}
	
	void resetheight() {
		int leftheight = -1;
		int rightheight = -1;
		if(left!= null) 
		{
			leftheight = getLeft().height;
		}
		
		if(right!= null) 
		{
			rightheight = getright().height;
		}
		height = 1 + Math.max(leftheight, rightheight);
	}
	
	
	}


	

