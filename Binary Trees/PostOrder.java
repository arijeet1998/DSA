import java.util.Stack;

public class PostOrder {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    public static void PostOrderRec(Node root){
        if(root==null){
            return;
        }
        
        PostOrderRec(root.left);
        PostOrderRec(root.right);
        System.out.print(root.data+" ");
    }
    
    public static void PostOrderIter(Node root){
        Stack<Node> stack=new Stack<>();
        Stack<Integer> output=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            //pop the element from the stack and push it into the output stack
            Node curr=stack.pop();
            output.push(curr.data);

            //if theres left child push it into the stack
            if(curr.left!=null){
                stack.push(curr.left);
            }
            //if theres right child push that into the stack
            if(curr.right!=null){
                stack.push(curr.right);
            }
        }
        //finally pop the output stack one by one printing them
        while(!output.isEmpty()){
            int rem=output.pop();
            System.out.println(rem);        
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

        PostOrderIter(root);
    }
}
