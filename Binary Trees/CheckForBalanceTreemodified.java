//User function Template for Java


/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
//here since it is modified it is in O(n)
class Tree
{
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	// Your code here
	    if(isBalancedTree(root)!=-1){
	        return true;
	    }else{
	        return false;
	    }
    }
    int isBalancedTree(Node root){
        
        if(root==null){
            return 0;//the tree is always balanced
        }
        
        //check if the left subtree is balanced
        int checkl=isBalancedTree(root.left);
        if(checkl==-1){
            return -1;
        }
        
        //check if the right subtree is balanced
        int checkr=isBalancedTree(root.right);
        if(checkr==-1){
            return -1;
        }
        //if node is  balanced return the height
        if(Math.abs(checkr-checkl)<=1){
            return Math.max(checkr,checkl)+1;
        }
        else{
            //the node is unbalanced and return -1
            return -1;
        }
    }
}
