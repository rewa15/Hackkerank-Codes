import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node node, int n1, int n2) {
      	if (node == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (node.data > n1 && node.data > n2) 
            return lca(node.left, n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (node.data < n1 && node.data < n2)  
            return lca(node.right, n1, n2); 
   
        return node; 
    }

	public static Node insert(Node root, int data) {
