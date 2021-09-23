import java.util.Stack;

public class Preorder {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
        }
    }
    public static void PreorderPrintRec(Node root){// this is simple recursion method of preorder Printing
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        PreorderPrintRec(root.left);
        PreorderPrintRec(root.right);
    }

    public static void PreorderIter(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack= new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node rem=stack.pop();
            System.out.println(rem.data);
            if(rem.right!=null){
                stack.push(rem.right);
            }if(rem.left!=null){
                stack.push(rem.left);
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

        PreorderIter(root);
    }
}
