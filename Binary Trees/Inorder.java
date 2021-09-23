public class Inorder {
    static class Node{
        // Inorder 
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    public static void InorderPrint(Node root){
        if(root ==null){
            return ;
        }
        InorderPrint(root.left);
        System.out.println(root.data);
        InorderPrint(root.right);
    }


    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.right.right=new Node(34);
        root.left.right=new Node(6);
        //          1
        //         / \
        //        2  3
        //       /\    \
        //      4  6    34

        InorderPrint(root);

    }
}
