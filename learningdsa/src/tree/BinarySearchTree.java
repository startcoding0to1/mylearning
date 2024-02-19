package tree;

import java.util.ArrayList;

public class BinarySearchTree {
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	//Make BST --- -- O(H)-O(n)
	public static Node insert(Node root,int val) {
		if(root==null) {
			root=new Node(val);
			return root;
		}
		if(root.data>val) {
			//left subtree
			root.left=insert(root.left,val);
		}
		else {
			root.right=insert(root.right,val);
		}
		return root;
	}
	
	//Traverse through BST -- numbers stored in sorted incase of BST
	public static void inOrderTraversal(Node root) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	
	//search value in BST -- O(H)-O(n)
	public static boolean search(Node root, int key) {
		if(root==null) {
			return false;
		}
		if(root.data>key) {//left subtree
			return search(root.left,key);
		}
		else if(root.data==key) {
			return true;
		}
		else {//right subtree
			return search(root.right,key);
		}
	}
	
	//delete values from BST-- O(H)-O(n)
	public static Node delete(Node root,int val) {
		if(root.data>val) {
			root.left=delete(root.left,val);
		}
		else if(root.data<val){
			root.right=delete(root.right,val);
		}
		else {//root.data==val
			//case 1
			if(root.left==null && root.right==null) {
				return null;//delete root
			}
			//case 2
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			
			//case-3 ===> left+ most node in right subtree
			Node iOSuccessor=inOrderSuccessor(root.right);
			root.data=iOSuccessor.data;
			root.right=delete(root.right,iOSuccessor.data);
		}
		return root;
	}
	public static Node inOrderSuccessor(Node root) {
		while(root.left != null) {
			root=root.left;
		}
		return root;
	}
	
	//print in range (eg: print numbers between x==6 and y=10)
	public static void printInRange(Node root,int x,int y) {
		if(root==null) {
			return;
		}
		if(root.data>=x && root.data<=y) {
			printInRange(root.left,x,y);
			System.out.print(root.data+" ");
			printInRange(root.right,x,y);
		}
		else if(root.data>=y) {
			printInRange(root.left,x,y);
		}
		else {
			printInRange(root.right,x,y);
		}
	}
	
	//like-priorder treversal, along with remove statement
	//first print left paths
	//then print right paths
	//remove last element
	public static void printPath(Node root, ArrayList<Integer> path) {
		if(root==null) {
			return;
		}
		path.add(root.data);
		
		//leaf
		if(root.left==null && root.right==null) {
			//print path
			for(int i=0;i<path.size();i++) {
				System.out.print("->"+path.get(i));
			}
			System.out.println();
		}
		else {
			printPath(root.left,path);
			printPath(root.right,path);
		}
		path.remove(path.size()-1);
		
	}
	public static void main(String[] args) {
		int values[]= {5,1,3,8,9,4,2,7,6};
		Node root=null;
		for(int val:values) {
			root=insert(root,val);
		}		
		boolean res=search(root,1);
		System.out.println(res==true?"Exists":"Not Exists");
		
		inOrderTraversal(root);
//		delete(root, 3);
		System.out.println();
		inOrderTraversal(root);
		System.out.println();
		printInRange(root,3,8);System.out.println();
		printPath(root,new ArrayList<>());
	}
}
