public class MirrorTree{

    static class Node {
        int data;
        Node left,right;//pointer to the left child and pointer to the right Child

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);

    }

    static Node mirrorify(Node root){
        if(root==null){
            return null;
        }
        Node newNode= new Node(root.data);// create a new Tree which is mirror image of the previous tree
        newNode.left=mirrorify(root.right);//left pointer points to the right node
        newNode.right=mirrorify(root.left);//right pointer points to the left node
        return newNode;//return the root ultimately (postorder)
    }

    public static void main(String[] args) {
        
        Node root= new Node(5);
        root.left=new Node(3);
        root.right=new Node(6);
        root.left.left=new Node(2);
        root.left.right=new Node(4);

        inorder(root);
        System.out.println("now the mirror image tree in inorder");
       Node mroot= mirrorify(root);
        inorder(mroot);
    }
}
