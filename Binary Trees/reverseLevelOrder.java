class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class BinaryTree{
    Node root;

    BinaryTree(){
        root=null;
    }

    void printrevLevelOrder(){
        int height=getHeight(root);
        //this is the only difference 
        for(int i=height;i>=1;i--){
            getRevLevelOrder(root,i);
        }
    }
    void getRevLevelOrder(Node root,int level){
        if(root ==null){
            return;
        }
        if(level==1){
            System.out.print(root.data+" ");
        }
        getRevLevelOrder(root.left, level-1);
        getRevLevelOrder(root.right, level-1);
    }
    
    int getHeight(Node root){

        if(root ==null){
            return 0;
        }
        int lheight=getHeight(root.left);
        int rheight=getHeight(root.right);

        if(lheight>rheight){
            return lheight+1;
        }else{
            return rheight+1;
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
        // tree.getLevelOrder(tree.root);
        tree.printrevLevelOrder();
        

    }
}