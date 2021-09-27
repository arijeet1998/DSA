public class CheckForBalancedTree {
    
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

class Tree
{
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        int lh;//store  the left height
        int rh;//store the  right height
        
       
        
        if(root==null){
            return true;// a leaf node is always balanced
        }
        //can't be placed above the base condition because null.left or null.right is null pointer exception
        lh=getHeight(root.left);//get the left height
        rh=getHeight(root.right);//get the right height
        
        //Here checks three things and if all are true then its ok
        //the difference between the heights of left subtree and right is <=1
        //the left subtree is balanced
        //the right subtree is balanced
        if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        //one of the condition above is not met and thus 
        return false;//not a balanced tree
	
    }//it just gives the height
    int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int getLeft=getHeight(root.left);
        int getRight=getHeight(root.right);
        
        if(getLeft>getRight){
            return getLeft+1;
        }else{
            return getRight+1;
        }
    }
    
    
    
}
}
