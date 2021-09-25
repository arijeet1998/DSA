//User function Template for Java
import java.util.*;

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> al= new ArrayList<>();
	    Queue<Node> q= new LinkedList<>();
	    q.add(root);
	    int count=0;
	    //bfs traversal
	    while(!q.isEmpty()){
	        int size=q.size();
	        //if its even then move from left to right
	        if(count%2==0){
	            for(int i=0;i<size;i++){
	                Node rem=q.poll();
	                al.add(rem.data);
	                
	                //enter the left child into the queue
	                if(rem.left!=null){
	                    q.add(rem.left);
	                }
	                //if the right child is found enter the right child into the node
	                if(rem.right!=null){
	                    q.add(rem.right);
	                }
	            }
	        }else{//if its "odd line" then push it into stack and pop it into a array thereby reversing the elements entered in the ArrayList
	            Stack<Integer> st= new Stack<>();
	             for(int i=0;i<size;i++){
	                Node rem=q.poll();
	                st.push(rem.data);
	                
	                //enter the left child into the queue
	                if(rem.left!=null){
	                    q.add(rem.left);
	                }
	                //if the right child is found enter the right child into the node
	                if(rem.right!=null){
	                    q.add(rem.right);
	                }
	            }//add into the list the popped element from the stack thereby reversing the entry
	            while(!st.isEmpty()){
	                al.add(st.pop());
	            }
	            
	        }
	        count++;
	    }
	    return al;
	}
}