public class leftView {
    static class Node{
        int data;
        Node left,right;
        static int maxHeight=0;

        Node(int data){
            this.data=data;
            left=right=null;
        }

    }

       public static void getLeftView(Node root){
           getLeftViewUtil(root,1);
       }
       public static void getLeftViewUtil(Node root,int level){
           if(root==null){
               return;
           }
           if(Node.maxHeight<level){
                System.out.println(root.data);
                Node.maxHeight=level;
           }

           //recursively calling the left child and the right child
           getLeftViewUtil(root.left,level+1);
           getLeftViewUtil(root.right,level+1);

       }

    

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(7);
        root.right.left=new Node(4);
        root.right.right=new Node(5);
        root.right.right.left=new Node(9);
        root.right.right.right=new Node(8);

        getLeftView(root);
    }
    
}
