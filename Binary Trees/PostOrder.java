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

        PostOrderRec(root);
    }
}
