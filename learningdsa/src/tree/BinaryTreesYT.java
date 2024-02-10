package tree;

public class BinaryTreesYT {
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			super();
			this.data = data;
			this.left=null;
			this.right=null;
		}
		
	}
	
	static class BinaryTree{
		//Build Tree PreOrder
		static int indx=-1;
		public Node buildTree(int [] nodes) {
			indx++;
			if(nodes[indx]==-1) {
				return null;
			}
			Node root=new Node(nodes[indx]);
			root.left=buildTree(nodes);
			root.right=buildTree(nodes);
			return root;
		}
		
		//PreOrder Traversal - O(n)
		//Root
		//Left Subtree
		//Right Subtree
		public void preOrderTraversal(Node root) {
			if(root == null) {
				return;
			}
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
		//InOrder Traversal - O(n)
		//Left Subtree
		//Root
		//Right Subtree
		public void inOrderTraversal(Node root) {
			if(root==null) {
				return;
			}
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
		//InOrder Traversal - O(n)
		//Left Subtree
		//Right Subtree
		//Root
		public void postOrderTraversal(Node root) {
			if(root==null) {
				return;
			}
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}
	}
	
	
//	static class Node{
//		int data;
//		Node left;
//		Node right;
//		
//		Node(int data){
//			this.data=data;
//			this.left=null;
//			this.right=null;
//		}
//	}
//	static class BinaryTree{
//		static int idx=-1;
//		public static Node buildTree(int nodes[]) {
//			
//			idx++;
//			if(nodes[idx]==-1) {
//				return null;
//			}
//			Node newNode=new Node(nodes[idx]);
//			newNode.left=buildTree(nodes);
//			newNode.right=buildTree(nodes);
//			return newNode;
//		}
//	}
	public static void main(String[] args) {
		int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		BinaryTree tree=new BinaryTree();
		Node root=tree.buildTree(nodes);
		System.out.println(root.data);
		tree.postOrderTraversal(root);
	}
}
