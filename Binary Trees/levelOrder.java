
class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

class BinaryTree {
    // Node which is the root of the binary tree
    Node root;

    public BinaryTree() {
        root = null;
    }

    void getLevelOrder(Node root){
        int height=getHeight(root);
        // System.out.println(height);
        for(int i=1;i<=height;i++){
            printLevelOrder(root,i);//concentrate more here
        }
    }

    int getHeight(Node root){
        if(root == null){
            return 0;// youb can't use if(root.left == null || root.right==null return 1, because we are not mentioning what will happen if the node goes to null)
        }
        int hleft=getHeight(root.left);
        int hright=getHeight(root.right);

        if(hleft>hright){
            return hleft+1;
        }else{
            return hright+1;
        }
    }

    void printLevelOrder(Node root,int level){
        if(root== null){
            return;
        }if(level==1){
            System.out.print(root.data);
        }
        else if(level>1){
            printLevelOrder(root.left,level-1);
            printLevelOrder(root.right,level-1);
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right=new Node(6);
        //     1
        //     /\
        //    2 3
        //    /\
        //    4 5
        //      /\
        //      N  6      
        System.out.println("Height "+tree.getHeight(tree.root));
        tree.getLevelOrder(tree.root);
        

    }

}