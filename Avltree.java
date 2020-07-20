package lab8_AVLTree;

public class Avltree extends binarytree {

	private AvlNode getRoot() {
		return (AvlNode) root;

	}

	// the getheight method computes the height of an avel tree
	static int getheight(AvlNode tree) {

		if (tree == null)
			return -1;

		else
			return tree.height;

	}

	// the add method adds a value to this tree
	public boolean add(int x) {

		root = add((AvlNode) root, x);
		return true;
	}

	private AvlNode add(AvlNode btree, int x) {

		if (btree == null) {
			return new AvlNode(x);

		}

		if (x < btree.data) {
			btree.left = add(btree.getLeft(), x);
		} else {
			btree.right = add(btree.getright(), x);
		}

		// conmpute heigths of the left and right subtree
		// and rebalance the tree if needed.
		int leftheight = getheight(btree.getLeft());
		int rightheight = getheight(btree.getright());

		if (Math.abs(leftheight) - rightheight == 2) {
			return balance(btree);

		} else {
			btree.resetheight();
			return btree;
		}

	}

	// the balance method rebalances the aveltree
	private AvlNode balance(AvlNode btree) {

		int rheight = getheight(btree.getright());
		int lheight = getheight(btree.getLeft());

		if (rheight > lheight) {

			AvlNode rightChild = btree.getright();
			int rrheight = getheight(rightChild.getright());
			int rlheight = getheight(rightChild.getLeft());

			if (rrheight > rlheight) {
				return rrBalance(btree);
			}
			else {
				return rlBalance(btree);
			}
			
		}
		else {
			AvlNode leftChild = btree.getLeft();
			int llheight = getheight(leftChild.getLeft());
			int lrheight = getheight(leftChild.getright());

			if (llheight > lrheight) {
				return llBalance(btree);
			} 
				else 
				{
				return lrBalance(btree);
				}
		}
	}

	// corredts an rr imbalance
	private AvlNode rrBalance(AvlNode btree) {

		AvlNode rightChild = btree.getright();
		AvlNode rightLeftChild = rightChild.getLeft();

		rightChild.left = btree;
		btree.right = rightLeftChild;
		btree.resetheight();
		rightChild.resetheight();

		return rightChild;
	}

	// corrects an rl imbalanace
	private AvlNode rlBalance(AvlNode btree) {

		AvlNode root = btree;
		AvlNode rnode = root.getright();
		AvlNode rlnode = rnode.getLeft();
		AvlNode rlrtree = rlnode.getright();
		AvlNode rlltree = rlnode.getLeft();

		// build the restructured tree

		rnode.left = rlrtree;
		root.right = rlltree;
		rlnode.left = root;
		rlnode.right = rnode;

		// adjust heights
		rnode.resetheight();
		root.resetheight();
		rlnode.resetheight();

		return rlnode;

	}

	// corrects and ll imbalance
	private AvlNode llBalance(AvlNode btree) {

		AvlNode leftChild = btree.getLeft();
		AvlNode lrtree = leftChild.getright();
		leftChild.right = btree;
		btree.left = lrtree;
		btree.resetheight();
		leftChild.resetheight();
		return leftChild;

	}

	private AvlNode lrBalance(AvlNode btree) {
		AvlNode root = btree;
		AvlNode lnode = root.getLeft();
		AvlNode lrnode = lnode.getright();
		AvlNode lrltree = lrnode.getLeft();
		AvlNode lrrtree = lrnode.getright();

		// build the restructured tree
		lnode.right = lrltree;
		root.left = lrrtree;
		lrnode.left = lnode;
		lrnode.right = root;

		// adjust heights
		lnode.resetheight();
		root.resetheight();
		lrnode.resetheight();

		return lrnode;

	}

}
