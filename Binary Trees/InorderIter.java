import java.util.Stack;

public class InorderIter {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    public static void InorderPrintIter(Node root){
        //create an empty stack
        Stack<Node> stack= new Stack<>();
        Node curr=root;

        //If there is no node and the stack is also empty we are done
        while(curr!=null || !stack.isEmpty()){
           if(curr!=null){
               stack.push(curr);
               curr=curr.left;
           }else{//if curr==null pop the node from the stack and move to the right of the node 
               curr=stack.pop();
               System.out.println(curr.data);
               curr=curr.right;
           }

        }

    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.right=new Node(34);
        //          1
        //         / \
        //        2  3
        //       /    \
        //      4      34 

        InorderPrintIter(root);

    }
}
    

