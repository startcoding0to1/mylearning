package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesYT {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	static class BinaryTree {
		// Build Tree PreOrder
		static int indx = -1;

		public Node buildTree(int[] nodes) {
			indx++;
			if (nodes[indx] == -1) {
				return null;
			}
			Node root = new Node(nodes[indx]);
			root.left = buildTree(nodes);
			root.right = buildTree(nodes);
			return root;
		}

//		 PreOrder Traversal - O(n)
//		 Root
//		 Left Subtree
//		 Right Subtree
		public static void preOrderTraversal(Node root) {
			if (root == null) {
				return;
			}
			System.out.println(root.data);
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}

		// InOrder Traversal - O(n)
		// Left Subtree
		// Root
		// Right Subtree
		public static void inOrderTraversal(Node root) {
			if (root == null) {
				return;
			}
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}

		// PostOrder Traversal - O(n)
		// Left Subtree
		// Right Subtree
		// Root
		public static void postOrderTraversal(Node root) {
			if (root == null) {
				return;
			}
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.println(root.data);
		}

		// Breadth first traversal(BFS) (DeapthDFS) are any one in, post ,pre
		// Level order traversal - O(n)-linearity time complexity
		public static void levelOrderTraversal(Node root) {
			if (root == null) {
				return;
			}
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			q.add(null);
			while (root != null) {
				Node curNode = q.remove();
				if (curNode == null) {
					System.out.println();
					if (q.isEmpty()) {
						break;
					} else {
						q.add(null);
					}
				} else {
					System.out.print(curNode.data + " ");
					if (curNode.left != null) {
						q.add(curNode.left);
					}
					if (curNode.right != null) {
						q.add(curNode.right);
					}
				}
			}
		}

		// TimeComplexity - O(n) because in this process each node touches only one time
		// leftsubstree count
		// rightsubstree count
		// lst+rst+1;
		public static int countOfNodeS(Node root) {
			if (root == null) {
				return 0;
			}
			int lSubTree = countOfNodeS(root.left);
			int rSubTree = countOfNodeS(root.right);
			return lSubTree + rSubTree + 1;
		}

		// TimeComplexity - O(n) because in this process each node touches only one time
		// leftsubstree sum
		// rightsubstree sum
		// lst+rst+root.data;
		public static int sumOfNodes(Node root) {
			if (root == null) {
				return 0;
			}
			int lSubTree = sumOfNodes(root.left);
			int rSubTree = sumOfNodes(root.right);
			return lSubTree + rSubTree + root.data;
		}

		// TimeComplexity - O(n) because in this process each node touches only one time
		// leftsubstree height
		// rightsubstree height
		// lst+rst+1;
		public static int heightOfTree(Node root) {
			if (root == null) {
				return 0;
			}
			int lSubTree = heightOfTree(root.left);
			int rSubTree = heightOfTree(root.right);
			return Math.max(lSubTree, rSubTree)+1;
//			if (lSubTree < rSubTree) {
//				return rSubTree + 1;
//			} else {
//				return lSubTree + 1;
//			}
		}

		// Diameter of the tree - No of nodes in the longest path between any 2 nodes --
		// asked in adobe, snapdeal
		// Approch one - O(N2) - not optimized
		public static int diameter1(Node root) {
			if (root == null) {
				return 0;
			}
			int lSTDiameter = diameter1(root.left);// dia1
			int rSTDiameter = diameter1(root.right);// dia2
			int throughroot = heightOfTree(root.left) + heightOfTree(root.right) + 1;// dia3
			return Math.max(throughroot, Math.max(lSTDiameter, rSTDiameter));
//			if(lSTDiameter>rSTDiameter) {
//				if(lSTDiameter>throughroot) {
//					return lSTDiameter;
//				}
//				else {
//					return throughroot;
//				}
//			}
//			if(rSTDiameter>throughroot) {
//				return rSTDiameter;
//			}
//			else {
//				return throughroot;
//			}

		}

		// Approch two - O(N) - optimized -- find diameter and height simultaneously
		static class TreeInfo{
			int height;
			int diameter;
			public TreeInfo(int height, int diameter) {
				this.height = height;
				this.diameter = diameter;
			}
			
		}
		public static TreeInfo diameter2(Node root) {
			if(root==null) {
				return new TreeInfo(0,0);
			}
			TreeInfo lSTHandD=diameter2(root.left);
			TreeInfo rSTHandD=diameter2(root.left);
			
			int htOfTree = Math.max(lSTHandD.height, rSTHandD.height)+1;
			
			int dia1=lSTHandD.diameter;
			int dia2=rSTHandD.diameter;
			int dia3=lSTHandD.height+rSTHandD.height+1;
			
			int diaOfTree=Math.max(dia1, Math.max(dia2, dia3));
			
			TreeInfo treeInfo = new TreeInfo(htOfTree,diaOfTree);
			return treeInfo;
		}
		
		//Facebook, Amazon, Microsoft
		public static boolean isIdentical(Node root,Node subRoot) {
			if(root ==null && subRoot==null) {
				return true;
			}
			if(root ==null || subRoot==null) {
				return false;
			}
			if(root.data==root.data) {
				return isIdentical(root.left,subRoot.left)&&isIdentical(root.right,subRoot.right);
			}
			return false;
		}
		public static boolean isSubtree(Node root,Node subRoot) {			
			if(subRoot==null) {
				return true;
			}
			if(root==null) {
				return false;
			}
			if(root.data==subRoot.data) {
				return isIdentical(root,subRoot);
			}
			
			return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
			
						
		}
		public static void main(String[] args) {
			int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
			BinaryTree tree = new BinaryTree();
			Node root = tree.buildTree(nodes);
//			System.out.println(root.data);
			levelOrderTraversal(root);
			int count = countOfNodeS(root);
			System.out.println("Count of Nodes: " + count);
			int sum = sumOfNodes(root);
			System.out.println("Sum of Nodes: " + sum);
			int height = heightOfTree(root);
			System.out.println("Height of the Tree: " + height);
			int dia1 = diameter1(root);
			System.out.println("Diameter1 of the Tree: " + dia1);
			
			int dia2 = diameter2(root).diameter;
			System.out.println("Diameter2 of the Tree: " + dia2);
			
			int subNode[]= {2,4,-1,-1,5,-1,-1};
			BinaryTree subTree = new BinaryTree();
			Node subRoot = subTree.buildTree(subNode);
			levelOrderTraversal(subRoot);
			System.out.println("Is subtree: "+isSubtree(root,subRoot));
		}
	}
}
